drop owned by john;

CREATE TABLE project (
    project_name text NOT NULL,
    date_i date NOT NULL,
    date_f date NOT NULL,
    saldo double precision NOT NULL,
    coord_university text NOT NULL,
    university_contact text NOT NULL,
    coord_local text NOT NULL,
    local_contact text NOT NULL,
    primary key(project_name)
);

CREATE TABLE holder (
    project_name text NOT NULL,
    cohort integer NOT NULL,
    app_nr integer NOT NULL,
    mobility text NOT NULL,
    mobility_type text NOT NULL,
    home_country text NOT NULL,
    status text,
    arrive_date date,
    departure_date date,
    tg integer NOT NULL,
    full_name text NOT NULL,
    real_duration integer NOT NULL,
    gender text NOT NULL,
    email text NOT NULL,
    host text NOT NULL,
    scientific_area text NOT NULL,
    situation text NOT NULL,
    ue_tutor text,
    tutor_email text,
    application boolean NOT NULL,
    passport boolean NOT NULL,
    visa boolean NOT NULL,
    inv_letter boolean NOT NULL,
    primary key(app_nr),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade
);

CREATE TABLE pcosts (
    project_name text NOT NULL,
    months int4range NOT NULL,
    value double precision NOT NULL,
    primary key(project_name, months),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade
);

CREATE TABLE scholarship (
    project_name text NOT NULL,
    type text NOT NULL,
    value double precision NOT NULL,
    primary key(project_name, type),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade
);


CREATE TABLE sum_holder (
    app_nr integer NOT NULL,
    type text NOT NULL,
    budget double precision NOT NULL,
    payment double precision NOT NULL,
    balance double precision NOT NULL,
    primary key(app_nr, type),
    foreign key(app_nr) references holder(app_nr)
    	on delete cascade
    	on update cascade
);

CREATE TABLE sum_project (
    project_name text NOT NULL,
    type text NOT NULL,
    budget double precision NOT NULL,
    payment double precision NOT NULL,
    balance double precision NOT NULL,
    primary key(project_name, type),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade

);

CREATE TABLE finance_holder (
    app_nr integer NOT NULL,
    sub_date date NOT NULL,
    sub_type text NOT NULL,
    description text NOT NULL,
    type text NOT NULL,
    value double precision NOT NULL,
    primary key(app_nr, description),
    foreign key(app_nr) references holder(app_nr)
    	on delete cascade
    	on update cascade
);

CREATE TABLE finance_project (
    project_name text NOT NULL,
    sub_date date NOT NULL,
    credit double precision NOT NULL,
    primary key(project_name, sub_date, credit),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade
);

CREATE FUNCTION alter_sum_holder() RETURNS trigger AS $$
    declare
        name text;
    begin
        select project_name into name from holder where app_nr = new.app_nr;

        update sum_holder set payment = payment + new.value where sum_holder.type = new.type and sum_holder.app_nr = new.app_nr;
        update sum_project set payment = payment + new.value where sum_project.type = new.type and sum_project.project_name = name;
        update sum_holder set balance = budget - payment where sum_holder.type = new.type and sum_holder.app_nr = new.app_nr;
        update sum_project set balance = budget - payment where sum_project.type = new.type and sum_project.project_name = name;
        return null;
    end;
$$ LANGUAGE plpgsql;

-- TRIGGERS AND FUNCTIONS --

CREATE TRIGGER sum_holder_alter 
	AFTER INSERT ON finance_holder 
	FOR EACH ROW EXECUTE PROCEDURE alter_sum_holder();


CREATE FUNCTION holder_status() RETURNS trigger AS $$
    declare
        dt date;
    begin
        select to_char(now(), 'YYYY-MM-DD') into dt;

        if ((new.arrive_date is null) or (new.departure_date is null)) then
            new.status = 'planned';
        elsif (dt < new.arrive_date) then
            new.status = 'planned';
        elsif (dt > new.departure_date) then 
            new.status = 'finished';
        else 
            new.status = 'started';
        end if;

        return new;
    end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER holder_before_insert 
	BEFORE INSERT ON holder 
	FOR EACH ROW EXECUTE PROCEDURE holder_status();


CREATE FUNCTION register_sum_holder() RETURNS trigger AS $$
    declare
        cost double precision;
        r int4range;
        pcost double precision;
    begin

        select value into cost from scholarship where project_name = new.project_name and type = new.mobility_type;

        for r in select months from pcosts where project_name = new.project_name
        loop
            if (select r @> new.real_duration) then
                select value into pcost from pcosts where months = r;
                exit;
            end if;
        end loop;

        insert into sum_holder values(new.app_nr, 'travel', 2000, 0, 2000);
        update sum_project set budget = budget + 2000 where project_name = new.project_name and type = 'travel';
        update sum_project set balance = balance + 2000 where project_name = new.project_name and type = 'travel';
        insert into sum_holder values(new.app_nr, 'pcosts', pcost, 0, pcost);
        update sum_project set budget = budget + pcost where project_name = new.project_name and type = 'pcosts';
        update sum_project set balance = balance + pcost where project_name = new.project_name and type = 'pcosts';
        insert into sum_holder values(new.app_nr, 'scholarship', (cost*new.real_duration), 0, (cost*new.real_duration));
        update sum_project set budget = budget + cost*new.real_duration where project_name = new.project_name and type = 'scholarship';
        update sum_project set balance = balance + cost*new.real_duration where project_name = new.project_name and type = 'scholarship';
        insert into sum_holder values(new.app_nr, 'insurance', 0, 0, 0);
        return null;
    end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER sum_holder_reg 
	AFTER INSERT ON holder 
	FOR EACH ROW EXECUTE PROCEDURE register_sum_holder();


CREATE FUNCTION register_sum_project() RETURNS trigger AS $$
    begin
        insert into sum_project values(new.project_name, 'travel', 0, 0, 0);
        insert into sum_project values(new.project_name, 'pcosts', 0, 0, 0);
        insert into sum_project values(new.project_name, 'scholarship', 0, 0, 0);
        insert into sum_project values(new.project_name, 'insurance', 0, 0, 0);
        return null;
    end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER sum_project_register 
	AFTER INSERT ON project 
	FOR EACH ROW EXECUTE PROCEDURE register_sum_project();


create function warn_user() returns trigger as $$
	declare
		budget double precision;
	begin
		select balance into budget from sum_holder where app_nr = new.app_nr and type = new.type;

		if(new.value > budget) then
			raise notice 'The value you are trying to insert is bigger than what you have available...';
			raise notice 'Only % available and trying to insert %', budget, new.value;
		end if;
		return new;
	end;
$$ language plpgsql;

create trigger warn_user_over_value
	before insert on finance_holder
	for each row execute procedure warn_user();


-- INSERTS -- 

insert into project values('fusion', '2017-01-01', '2017-02-02', 0, 'Cenas', 'cenas@cenas.cenas', 'Coisas', 'coisas@coisas.coisas');

insert into scholarship values('fusion', 'UG', 1000);
insert into scholarship values('fusion', 'O-UG', 1000);
insert into scholarship values('fusion', 'MsC', 1000);
insert into scholarship values('fusion', 'Doc', 1000);
insert into scholarship values('fusion', 'Doc-10', 1000);
insert into scholarship values('fusion', 'posdoc', 1000);
insert into scholarship values('fusion', 'staff', 1000);

insert into pcosts values('fusion', int4range(0, 10), 0);
insert into pcosts values('fusion', int4range(10, 20), 0);
insert into pcosts values('fusion', int4range(20, 27), 0);
insert into pcosts values('fusion', int4range(27, null), 0);

insert into holder values('fusion',	1, 612, 'Asia->EU', 'MsC', 'Bangladesh', null, '2014-12-06', '2015-11-28', 1, 'MD Sajib Ahmed', 10, 'm', 'jack6148@gmail.com', 'United International University', 'computer sciences', 'Mobilidade', 'Teresa Gonçalves', 'tcg@uevora.pt', 'f', 'f', 'f', 'f');
insert into holder values('fusion', 1, 779, 'Asia->EU', 'MsC', 'Pakistan', null, '2014-11-29', null, 2, 'MD Fahad Israr', 10, 'm', 'fahad_israr@hotmail.com', 'University of Peshawar', 'economics', 'Regular', 'Miguel Rocha de Sousa', null, 'f', 'f', 'f', 'f');

insert into finance_holder values(612, '2017-05-15', 'orcamento', 'orcamento da viagem', 'travel', 99.5);
insert into finance_holder values(779, '2017-05-15', 'pagamento', 'pagamento da bolsa',	'scholarship', 8000);