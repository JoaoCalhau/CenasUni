drop owned by john;

-- TABLES

-- Tabela projecto
-- Inclui todas as propriedades de um projecto
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

-- Tabela do aluno
-- Inclui todas as informacoes pessoais do aluno
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

-- Tabela dos Pcosts
-- tabela utilizada para cálculos de pcosts 
-- com base nos meses de participacao
CREATE TABLE pcosts (
    project_name text NOT NULL,
    months int4range NOT NULL,
    value double precision NOT NULL,
    primary key(project_name, months),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade
);

-- Tabela da Bolsa
-- Contem informacoes dos valores para cada bolsa
-- conforme o tipo de participacao 
-- (ex:licenciatura, mestrado, ...)
CREATE TABLE scholarship (
    project_name text NOT NULL,
    type text NOT NULL,
    value double precision NOT NULL,
    primary key(project_name, type),
    foreign key(project_name) references project(project_name)
    	on delete cascade
    	on update cascade
);

-- Tabela com informacao financeira do aluno
-- inclui uma descricao sobre o que pertence
-- (aviao, visita, despesa, etc)
-- um tipo (travel, pcost, scholarship,insurance) 
-- e um valor monetario
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

-- Tabela com informacao financeira do projeto
-- inclui uma data de insercao, e um credito 
CREATE TABLE finance_project (
    project_name text NOT NULL,
    sub_date date NOT NULL,
    credit double precision NOT NULL,
    primary key(project_name, sub_date, credit),
    foreign key(project_name) references project(project_name)
        on delete cascade
        on update cascade
);

-- Tabela do somatorio de valores financeiros
-- de um aluno pelos tipos de valores:
-- (travel, pcost, scholarship,insurance) 
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

-- Tabela do somatorio de valores financeiros
-- de todos os alunos de um projeto pelos tipos de valores:
-- (travel, pcost, scholarship,insurance) 
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



-- TRIGGERS AND FUNCTIONS --


-- Funcao que adiciona um dado financeiro
-- de um aluno ao somatorio do mesmo
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

-- Trigger que executa funcao anterior
-- apos insercao na tabela finance_holder
-- (dado financeiro de um aluno)
CREATE TRIGGER sum_holder_alter 
	AFTER INSERT ON finance_holder 
	FOR EACH ROW EXECUTE PROCEDURE alter_sum_holder();

-------------------------------------------------------------------------------

-- Funcao que determina se um aluno
-- ja se encontra no projeto, se acabou ou se
-- vai participar no projeto
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

-- Trigger que executa funcao anterior
-- antes de inserir-se um aluno novo
CREATE TRIGGER holder_before_insert 
	BEFORE INSERT ON holder 
	FOR EACH ROW EXECUTE PROCEDURE holder_status();

-------------------------------------------------------------------------------

-- Funcao que inicializa os valores do somatorio de um aluno
-- Para isso verificando dados como os meses que participa no projeto
-- e inserindo valor para viagem, entre outros
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


-- Trigger que executa funcao anterior
-- depois de um aluno novo ser inserido na base de dados
CREATE TRIGGER sum_holder_reg 
	AFTER INSERT ON holder 
	FOR EACH ROW EXECUTE PROCEDURE register_sum_holder();

-------------------------------------------------------------------------------

-- Funcao que inicializa os valores do somatorio de um projeto
CREATE FUNCTION register_sum_project() RETURNS trigger AS $$
    begin
        insert into sum_project values(new.project_name, 'travel', 0, 0, 0);
        insert into sum_project values(new.project_name, 'pcosts', 0, 0, 0);
        insert into sum_project values(new.project_name, 'scholarship', 0, 0, 0);
        insert into sum_project values(new.project_name, 'insurance', 0, 0, 0);
        return null;
    end;
$$ LANGUAGE plpgsql;


-- Trigger que executa funcao anterior
-- apos criar-se um novo projeto
CREATE TRIGGER sum_project_register 
	AFTER INSERT ON project 
	FOR EACH ROW EXECUTE PROCEDURE register_sum_project();

-------------------------------------------------------------------------------

-- Funcao que mostra um warning quando se pretende inserir
-- um valor monetario maior que o valor disponivel
-- para um aluno
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


-- Trigger que executa funcao anterior
-- antes de se inserir um novo valor financeiro para um aluno
CREATE TRIGGER warn_user_over_value
	BEFORE INSERT ON finance_holder
	FOR EACH ROW EXECUTE PROCEDURE warn_user();


-------------------------------------------------------------------------------

-- Funcao que atualiza o valor atual do saldo de um projecto
CREATE FUNCTION saldo_project() RETURNS TRIGGER AS $$
	declare
		total double precision;
	begin
		select sum(balance) into total from sum_project where project_name = new.project_name;

		update project set saldo = total where project_name = new.project_name;

		return null;
	end;
$$ LANGUAGE plpgsql;

-- Trigger que executa funcao anterior
-- depois de se fazer update ao somatorio do projecto
CREATE TRIGGER update_saldo_project
	AFTER UPDATE ON sum_project
	FOR EACH ROW EXECUTE PROCEDURE saldo_project();

-- INSERTS -- 

insert into project values('fusion', '2017-01-01', '2017-02-02', 0, 'Cenas', 'cenas@cenas.cenas', 'Coisas', 'coisas@coisas.coisas');

insert into scholarship values('fusion', 'UG', 1000);
insert into scholarship values('fusion', 'O-UG', 1000);
insert into scholarship values('fusion', 'MsC', 1000);
insert into scholarship values('fusion', 'Doc', 1500);
insert into scholarship values('fusion', 'Doc-10', 1500);
insert into scholarship values('fusion', 'posdoc', 1800);
insert into scholarship values('fusion', 'staff', 2500);

insert into pcosts values('fusion', int4range(0, 10), 0);
insert into pcosts values('fusion', int4range(10, 20), 3000);
insert into pcosts values('fusion', int4range(20, 27), 6000);
insert into pcosts values('fusion', int4range(27, null), 9000);

insert into holder values('fusion',	1, 612, 'Asia->EU', 'MsC', 'Bangladesh', null, '2014-12-06', '2015-11-28', 1, 'MD Sajib Ahmed', 10, 'm', 'jack6148@gmail.com', 'United International University', 'computer sciences', 'Mobilidade', 'Teresa Gonçalves', 'tcg@uevora.pt', 'f', 'f', 'f', 'f');
insert into holder values('fusion', 1, 779, 'Asia->EU', 'MsC', 'Pakistan', null, '2014-11-29', null, 2, 'MD Fahad Israr', 10, 'm', 'fahad_israr@hotmail.com', 'University of Peshawar', 'economics', 'Regular', 'Miguel Rocha de Sousa', null, 'f', 'f', 'f', 'f');

insert into finance_holder values(612, '2017-05-15', 'orcamento', 'orcamento da viagem', 'travel', 99.5);
insert into finance_holder values(779, '2017-05-15', 'pagamento', 'pagamento da bolsa',	'scholarship', 8000);

insert into finance_project values('fusion', '2017-05-18', 2000.6);