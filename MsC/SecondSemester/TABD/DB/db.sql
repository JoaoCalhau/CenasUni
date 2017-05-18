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
	locali varchar(20) primary key
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
	inicio timestamp unique,
	fim timestamp,
	NIF varchar(9),
	matricula varchar(8),
	num int unique,
	primary key(inicio, num),
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
	inicio timestamp,
	locali varchar(20),
	num int,
	primary key(id, inicio, num),
	foreign key(inicio) references viagem(inicio)
		on delete cascade
		on update cascade,
	foreign key(num) references viagem(num)
		on delete cascade
		on update cascade
);

create table percorre(
	seq int,
	num int,
	locali varchar(20),
	primary key(num, locali),
	foreign key(num) references carreira(num)
		on delete cascade
		on update cascade,
	foreign key(locali) references paragem(locali)
		on delete cascade
		on update cascade
);


