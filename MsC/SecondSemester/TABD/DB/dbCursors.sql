drop schema public cascade;
create schema public;
grant all on schema public to postgres;
grant all on schema public to public;

create table autocarro(
	matricula varchar(8) primary key,
	ano int,
	nPass int,
	marca varchar(20),
	modelo varchar(20)
);

create table funcionario(
	nome varchar(255),
	NIF varchar(9) primary key,
	BI varchar(13),
	morada varchar(255)
);

create table carreira(
	maxPass int,
	tempo time,
	num int primary key
);

create table paragem(
	local_ varchar(20),
	IDp int primary key
);


create table chefia(
	NIFboss varchar(9),
	NIFfunc varchar(9),
	primary key(NIFboss, NIFfunc),
	foreign key(NIFboss) references funcionario(NIF) 
		on delete cascade 
		on update cascade,
	foreign key(NIFfunc) references funcionario(NIF) 
		on delete cascade 
		on update cascade
);

create table viagem(
	inicio timestamp,
	fim timestamp,
	NIF varchar(9),
	matricula varchar(8),
	num int,
	IDv int primary key,
	foreign key(NIF) references funcionario(NIF) 
		on delete cascade 
		on update cascade,
	foreign key(matricula) references autocarro(matricula) 
		on delete cascade 
		on update cascade,
	foreign key(num) references carreira(num) 
		on delete cascade 
		on update cascade
);

create table bilhete(
	id int,
	hora time,
	IDp int,
	IDv int,
	primary key(id, IDv),
	foreign key(IDv) references viagem(IDv)
		on delete cascade
		on update cascade,
	foreign key(IDp) references paragem(IDp)
		on delete cascade
		on update cascade
);

create table percorre(
	seq int,
	num int,
	IDp int,
	primary key(num, IDp),
	foreign key(num) references carreira(num)
		on delete cascade
		on update cascade,
	foreign key(IDp) references paragem(IDp)
		on delete cascade
		on update cascade
);

insert into autocarro values('00-00-00', 2017, 20, 'Mercedes', 'SLK');
insert into autocarro values('00-00-01', 2017, 20, 'Mercedes', 'SLK');

insert into funcionario values('Manel', '000000000', '0000000000000', 'Bairro da Zueira 95');
insert into funcionario values('Ze', '000000001', '0000000000001', 'Bairro da Zueira 96');

insert into carreira values(20, '02:00:00', 21);
insert into carreira values(20, '02:00:00', 22);

insert into paragem values('Rossio', 1);
insert into paragem values('Terra do Nunca', 2);
insert into paragem values('Terra do Sempre', 3);

insert into viagem values('2007-11-07 09:00:00', '2007-11-07 11:00:00', '000000001', '00-00-00', 21, 1);
insert into viagem values('2007-11-07 09:00:00', '2007-11-07 11:00:00', '000000000', '00-00-01', 22, 2);

insert into bilhete values(1, '09:01:00', 1, 1);
insert into bilhete values(2, '09:01:00', 2, 2);
insert into bilhete values(3, '09:02:00', 1, 1);
insert into bilhete values(4, '09:02:00', 2, 2);

insert into percorre values(010101, 21, 1);
insert into percorre values(010101, 22, 2);


create view bus as (
	select matricula, marca, modelo, count(id) as numbilhetes 
	from autocarro natural inner join bilhete natural inner join viagem natural inner join carreira 
	where carreira.num=21 and viagem.inicio ='2007-11-07 09:00:00' 
	group by autocarro.matricula
);

create view buses as (
	select matricula, marca, modelo, local_, count(id) as numbilhetes
	from autocarro natural inner join bilhete natural inner join viagem natural inner join carreira natural inner join paragem
	group by autocarro.matricula, paragem.local_
);

-- % select * from buses;

-- % begin;

-- % update paragem set local_ = 'Praça da Figueira' where local_ = 'Rossio';

-- % commit;


create function num_stops(int) -- % This works :D
	returns bigint as $$
		select count(num) from percorre where num = $1;
$$ language sql;

create function num_stops_cenas(in route int, out stops bigint) -- % This too :D
	as 'select count(num) from percorre where num = route' language sql;

create function list_stops(int)
	returns setof record as $$
		select local_ as name
		from percorre natural inner join paragem
		where num = $1;
$$ language sql;

create function brand_model(int)
	returns setof record as $$
		select marca as brand, modelo as model
		from autocarro natural inner join viagem
		where num = $1;
$$ language sql;

create function list_routes(int)
	returns setof record as $$
		select IDv as RouteNumber
		from viagem natural inner join paragem natural inner join bilhete
		where IDp = $1;
$$ language sql;

create function list_routes_char(varchar(20))
	returns setof record as $$
		select IDv as RouteNumber
		from viagem natural inner join paragem natural inner join bilhete
		where local_ = $1;
$$ language sql;

declare
	type t_ref_cursor is ref cursor;
	c_cursor t_ref_cursor;
	l_row cursor_variable_test%rowtype;
begin
	open c_cursor for
		select num, inicio, fim
		from viagem
		where num = 21;
	loop
		fetch c_cursor;
		into l_row;
		exit when c_cursor%notfound;
	end loop;

	close c_cursor;
end;
