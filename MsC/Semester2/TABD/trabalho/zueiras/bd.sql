--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: alter_sum_holder(); Type: FUNCTION; Schema: public; Owner: john
--

CREATE FUNCTION alter_sum_holder() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
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
$$;


ALTER FUNCTION public.alter_sum_holder() OWNER TO john;

--
-- Name: holder_status(); Type: FUNCTION; Schema: public; Owner: john
--

CREATE FUNCTION holder_status() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
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
$$;


ALTER FUNCTION public.holder_status() OWNER TO john;

--
-- Name: register_sum_holder(); Type: FUNCTION; Schema: public; Owner: john
--

CREATE FUNCTION register_sum_holder() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
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
$$;


ALTER FUNCTION public.register_sum_holder() OWNER TO john;

--
-- Name: register_sum_project(); Type: FUNCTION; Schema: public; Owner: john
--

CREATE FUNCTION register_sum_project() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
	begin
		insert into sum_project values(new.project_name, 'travel', 0, 0, 0);
		insert into sum_project values(new.project_name, 'pcosts', 0, 0, 0);
		insert into sum_project values(new.project_name, 'scholarship', 0, 0, 0);
		insert into sum_project values(new.project_name, 'insurance', 0, 0, 0);
		return null;
	end;
$$;


ALTER FUNCTION public.register_sum_project() OWNER TO john;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: finance_holder; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE finance_holder (
    app_nr integer NOT NULL,
    sub_date date NOT NULL,
    sub_type text NOT NULL,
    description text NOT NULL,
    type text NOT NULL,
    value double precision NOT NULL
);


ALTER TABLE finance_holder OWNER TO john;

--
-- Name: finance_project; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE finance_project (
    project_name text NOT NULL,
    sub_date date NOT NULL,
    credit double precision NOT NULL
);


ALTER TABLE finance_project OWNER TO john;

--
-- Name: holder; Type: TABLE; Schema: public; Owner: john
--

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
    inv_letter boolean NOT NULL
);


ALTER TABLE holder OWNER TO john;

--
-- Name: pcosts; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE pcosts (
    project_name text NOT NULL,
    months int4range NOT NULL,
    value double precision NOT NULL
);


ALTER TABLE pcosts OWNER TO john;

--
-- Name: project; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE project (
    project_name text NOT NULL,
    date_i date NOT NULL,
    date_f date NOT NULL,
    saldo double precision NOT NULL,
    coord_university text NOT NULL,
    university_contact text NOT NULL,
    coord_local text NOT NULL,
    local_contact text NOT NULL
);


ALTER TABLE project OWNER TO john;

--
-- Name: scholarship; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE scholarship (
    project_name text NOT NULL,
    type text NOT NULL,
    value double precision NOT NULL
);


ALTER TABLE scholarship OWNER TO john;

--
-- Name: sum_holder; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE sum_holder (
    app_nr integer NOT NULL,
    type text NOT NULL,
    budget double precision NOT NULL,
    payment double precision NOT NULL,
    balance double precision NOT NULL
);


ALTER TABLE sum_holder OWNER TO john;

--
-- Name: sum_project; Type: TABLE; Schema: public; Owner: john
--

CREATE TABLE sum_project (
    project_name text NOT NULL,
    type text NOT NULL,
    budget double precision NOT NULL,
    payment double precision NOT NULL,
    balance double precision NOT NULL
);


ALTER TABLE sum_project OWNER TO john;

--
-- Data for Name: finance_holder; Type: TABLE DATA; Schema: public; Owner: john
--

COPY finance_holder (app_nr, sub_date, sub_type, description, type, value) FROM stdin;
612	2017-05-15	orcamento	orcamento da viagem	travel	99.5
779	2017-05-15	pagamento	pagamento da bolsa	scholarship	8000
\.


--
-- Data for Name: finance_project; Type: TABLE DATA; Schema: public; Owner: john
--

COPY finance_project (project_name, sub_date, credit) FROM stdin;
fusion	2017-05-05	21900.5
\.


--
-- Data for Name: holder; Type: TABLE DATA; Schema: public; Owner: john
--

COPY holder (project_name, cohort, app_nr, mobility, mobility_type, home_country, status, arrive_date, departure_date, tg, full_name, real_duration, gender, email, host, scientific_area, situation, ue_tutor, tutor_email, application, passport, visa, inv_letter) FROM stdin;
fusion	1	612	Asia->EU	MsC	Bangladesh	finished	2014-12-06	2015-11-28	1	MD Sajib Ahmed	10	m	jack6148@gmail.com	United International University	computer sciences	Mobilidade	Teresa Gonçalves	tcg@uevora.pt	f	f	f	f
fusion	1	779	Asia->EU	MsC	Pakistan	planned	2014-11-29	\N	2	MD Fahad Israr	10	m	fahad_israr@hotmail.com	University of Peshawar	economics	Regular	Miguel Rocha de Sousa	\N	f	f	f	f
\.


--
-- Data for Name: pcosts; Type: TABLE DATA; Schema: public; Owner: john
--

COPY pcosts (project_name, months, value) FROM stdin;
fusion	[0,10)	0
fusion	[10,20)	3000
fusion	[20,27)	6000
fusion	[27,)	9000
\.


--
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: john
--

COPY project (project_name, date_i, date_f, saldo, coord_university, university_contact, coord_local, local_contact) FROM stdin;
fusion	2017-01-01	2017-02-02	0	Cenas	cenas@cenas.cenas	Coisas	coisas@coisas.coisas
\.


--
-- Data for Name: scholarship; Type: TABLE DATA; Schema: public; Owner: john
--

COPY scholarship (project_name, type, value) FROM stdin;
fusion	UG	1000
fusion	O-UG	1000
fusion	MsC	1000
fusion	Doc	1500
fusion	Doc-10	1500
fusion	posdoc	1800
fusion	staff	2500
\.


--
-- Data for Name: sum_holder; Type: TABLE DATA; Schema: public; Owner: john
--

COPY sum_holder (app_nr, type, budget, payment, balance) FROM stdin;
612	pcosts	3000	0	3000
612	scholarship	10000	0	10000
612	insurance	0	0	0
779	travel	2000	0	2000
779	pcosts	3000	0	3000
779	insurance	0	0	0
612	travel	2000	99.5	1900.5
779	scholarship	10000	8000	2000
\.


--
-- Data for Name: sum_project; Type: TABLE DATA; Schema: public; Owner: john
--

COPY sum_project (project_name, type, budget, payment, balance) FROM stdin;
fusion	insurance	0	0	0
fusion	pcosts	6000	0	6000
fusion	travel	4000	99.5	3900.5
fusion	scholarship	20000	8000	12000
\.


--
-- Name: finance_holder finance_holder_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY finance_holder
    ADD CONSTRAINT finance_holder_pkey PRIMARY KEY (app_nr, description);


--
-- Name: finance_project finance_project_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY finance_project
    ADD CONSTRAINT finance_project_pkey PRIMARY KEY (project_name, sub_date, credit);


--
-- Name: holder holder_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY holder
    ADD CONSTRAINT holder_pkey PRIMARY KEY (app_nr);


--
-- Name: pcosts pcosts_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY pcosts
    ADD CONSTRAINT pcosts_pkey PRIMARY KEY (project_name, months);


--
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY project
    ADD CONSTRAINT project_pkey PRIMARY KEY (project_name);


--
-- Name: scholarship scholarship_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY scholarship
    ADD CONSTRAINT scholarship_pkey PRIMARY KEY (project_name, type);


--
-- Name: sum_holder sum_holder_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY sum_holder
    ADD CONSTRAINT sum_holder_pkey PRIMARY KEY (type, app_nr);


--
-- Name: sum_project sum_project_pkey; Type: CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY sum_project
    ADD CONSTRAINT sum_project_pkey PRIMARY KEY (type, project_name);


--
-- Name: holder holder_before_insert; Type: TRIGGER; Schema: public; Owner: john
--

CREATE TRIGGER holder_before_insert BEFORE INSERT ON holder FOR EACH ROW EXECUTE PROCEDURE holder_status();


--
-- Name: finance_holder sum_holder_alter; Type: TRIGGER; Schema: public; Owner: john
--

CREATE TRIGGER sum_holder_alter AFTER INSERT ON finance_holder FOR EACH ROW EXECUTE PROCEDURE alter_sum_holder();


--
-- Name: holder sum_holder_reg; Type: TRIGGER; Schema: public; Owner: john
--

CREATE TRIGGER sum_holder_reg AFTER INSERT ON holder FOR EACH ROW EXECUTE PROCEDURE register_sum_holder();


--
-- Name: project sum_project_register; Type: TRIGGER; Schema: public; Owner: john
--

CREATE TRIGGER sum_project_register AFTER INSERT ON project FOR EACH ROW EXECUTE PROCEDURE register_sum_project();


--
-- Name: finance_holder finance_holder_app_nr_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY finance_holder
    ADD CONSTRAINT finance_holder_app_nr_fkey FOREIGN KEY (app_nr) REFERENCES holder(app_nr) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: finance_project finance_project_project_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY finance_project
    ADD CONSTRAINT finance_project_project_name_fkey FOREIGN KEY (project_name) REFERENCES project(project_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: holder holder_project_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY holder
    ADD CONSTRAINT holder_project_name_fkey FOREIGN KEY (project_name) REFERENCES project(project_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: pcosts pcosts_project_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY pcosts
    ADD CONSTRAINT pcosts_project_name_fkey FOREIGN KEY (project_name) REFERENCES project(project_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: scholarship scholarship_project_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY scholarship
    ADD CONSTRAINT scholarship_project_name_fkey FOREIGN KEY (project_name) REFERENCES project(project_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: sum_holder sum_holder_app_nr_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY sum_holder
    ADD CONSTRAINT sum_holder_app_nr_fkey FOREIGN KEY (app_nr) REFERENCES holder(app_nr) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: sum_project sum_project_project_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: john
--

ALTER TABLE ONLY sum_project
    ADD CONSTRAINT sum_project_project_name_fkey FOREIGN KEY (project_name) REFERENCES project(project_name) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

