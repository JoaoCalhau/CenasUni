drop schema public cascade;
create schema public;


Create Table autor (
Proprio Char(10),
Apelido Char(10),
Primary Key (Proprio, Apelido)
);

Create Table autorOrcid (
Proprio Char(10),
Apelido Char(10),
ORCID Varchar(5) unique,
Primary Key (Proprio, Apelido),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade
);

Create Table autorEmail (
Proprio Char(10),
Apelido Char(10),
Email Varchar(20) unique,
Primary Key (Proprio, Apelido),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade
);

Create Table autorDeGois (
Proprio Char(10),
Apelido Char(10),
DeGois Varchar(5) unique,
Primary Key (Proprio, Apelido),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade
);

Create Table instituicao (
nomeI Char(30),
localI Varchar(20),
Primary Key (nomeI, localI)
);

Create Table vinculo ( --R1
Proprio Char(10),
Apelido Char(10),
nomeI Char(30),
localI Varchar(20),
dataI Timestamp,
dataF Timestamp,
Primary Key (Proprio, Apelido, nomeI, localI),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade,
Foreign Key (nomeI, localI) References instituicao On Delete Cascade
);

Create Table artigos (
IDArtigos Varchar(5),
Primary Key (IDArtigos)
);

Create Table artigosC (
IDArtigos Varchar(5),
TiuloC char(10),
TituloL Char(10),
AnoL Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigos On Delete Cascade
);

Create Table artigosCP (
IDArtigos Varchar(5),
Paginas Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosC On Delete Cascade
);

Create Table artigosCE (
IDArtigos Varchar(5),
Editora Char(10),
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosC On Delete Cascade
);

Create Table artigosR (
IDArtigos Varchar(5),
TituloA Char(30),
NomeR Char(10),
AnoR Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigos On Delete Cascade
);

Create Table artigosRP (
IDArtigos Varchar(10),
Paginas Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosR On Delete Cascade
);

Create Table artigosRM (
IDArtigos Varchar(10),
Mes Char(8),
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosR On Delete Cascade
);

Create Table artigosRN (
IDArtigos Varchar(10),
NumeroR Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosR On Delete Cascade
);

Create Table artigosA (
IDArtigos Varchar(10),
TituloConf Char(10),
TituloR Char(10),
AnoC Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigos On Delete Cascade
);

Create Table artigosAL (
IDArtigos Varchar(10),
LocalC Varchar(20),
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosA On Delete Cascade
);

Create Table artigosAP (
IDArtigos Varchar(5),
Paginas Integer Not Null,
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosA On Delete Cascade
);

Create Table artigosAE (
IDArtigos Varchar(5),
Editora Char(10),
Primary Key (IDArtigos),
Foreign Key (IDArtigos) References artigosA On Delete Cascade
);

Create Table criou ( --R2
Proprio Char(10),
Apelido Char(10),
IDArtigos Varchar(5),
Primary Key (Proprio, Apelido, IDArtigos),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade,
Foreign Key (IDArtigos) References artigos On Delete Cascade
);

Create Table patente (
Referencia Varchar(5),
Periodo Integer Not Null,
Descricao Char(100),
DataP Timestamp,
Primary Key (Referencia)
);

Create Table registou ( --R3
IDArtigos Varchar(5),
NomeI Char(30),
LocalI Varchar(20),
Referencia Varchar(5),
DataA Timestamp,
Primary Key (IDArtigos, NomeI, LocalI, Referencia),
Foreign Key (IDArtigos) References artigos On Delete Cascade,
Foreign Key (NomeI, LocalI) References instituicao On Delete Cascade,
Foreign Key (Referencia) References patente On Delete Cascade
);

Create Table patenteou ( --R4
Proprio Char(10),
Apelido Char(10),
Referencia Varchar(5),
Primary Key (Proprio, Apelido, Referencia),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade,
Foreign Key (Referencia) References patente On Delete Cascade
);

Create Table bibliometria (
IDArtigosB Varchar(5),
Indice Varchar(30),
DataB Timestamp,
Primary Key (IDArtigosB, Indice),
Foreign Key (IDArtigosB) References artigos(IDArtigos) On Delete Cascade
);

Create Table tem ( --R5
IDArtigos Varchar(5),
IDArtigosB Varchar(5),
Indice Varchar(30),
Primary Key (IDArtigos, IDArtigosB, Indice),
Foreign Key (IDArtigos) References artigos On Delete Cascade,
Foreign Key (IDArtigosB, Indice) References bibliometria On Delete Cascade
);


--9--

Insert into autor values('Ricardo', 'Benedito');
Insert into autorOrcid values('Ricardo', 'Benedito', 123);
Insert into artigos values('ab12');
Insert into artigosR values('ab12', 'Cenas da Vida', 'Cenas', 2014);
Insert into criou values('Ricardo', 'Benedito', 'ab12');
Insert into bibliometria values('ab12', 'SCOPUS', '2014-10-12 13:30');
Insert into tem values('ab12','ab12','SCOPUS');
Insert into instituicao values('Universidade de Evora', 'Rua do Swag, Evora');
Insert into instituicao values('ICAAM', 'Rua do Yolo, Evora');
Insert into vinculo values('Ricardo', 'Benedito', 'Universidade de Evora', 'Rua do Swag, Evora', '2014-01-01', '2014-12-12');
Insert into vinculo values('Ricardo', 'Benedito', 'ICAAM', 'Rua do Yolo, Evora', '2014-01-01', '2014-12-12');
Insert into patente values('1145', 3, 'É uma patente muito zueira', '2014-01-01');
Insert into patenteou values('Ricardo', 'Benedito', '1145');
Insert into artigosRP values('ab12', 5);