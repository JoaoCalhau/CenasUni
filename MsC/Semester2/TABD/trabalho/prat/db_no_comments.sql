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

CREATE FUNCTION warn_user() RETURNS trigger AS $$
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
$$ LANGUAGE plpgsql;


CREATE TRIGGER warn_user_over_value
    BEFORE INSERT ON finance_holder
    FOR EACH ROW EXECUTE PROCEDURE warn_user();


CREATE FUNCTION saldo_project() RETURNS TRIGGER AS $$
    declare
        total double precision;
    begin
        select sum(balance) into total from sum_project where project_name = new.project_name;

        update project set saldo = total where project_name = new.project_name;

        return null;
    end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_saldo_project
    AFTER UPDATE ON sum_project
    FOR EACH ROW EXECUTE PROCEDURE saldo_project();