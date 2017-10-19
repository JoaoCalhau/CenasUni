drop table autor cascade;
drop table autorOrcid cascade;
drop table autorEmail cascade;
drop table autorDeGois cascade;
drop table instituicao cascade;
drop table vinculo cascade;
drop table artigos cascade;
drop table artigosC cascade;
drop table artigosCP cascade;
drop table artigosCE cascade;
drop table artigosR cascade;
drop table artigosRP cascade;
drop table artigosRM cascade;
drop table artigosRN cascade;
drop table artigosA cascade;
drop table artigosAL cascade;
drop table artigosAP cascade;
drop table artigosAE cascade;
drop table criou cascade;
drop table patente cascade;
drop table patenteou cascade;
drop table bibliometria cascade;

Create Table autor (
Proprio Char(10),
Apelido Char(10),
Primary Key (Proprio, Apelido)
);

Create Table autorOrcid (
Proprio Char(10),
Apelido Char(10),
ORCID Varchar(5),
Primary Key (Proprio, Apelido),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade
);

Create Table autorEmail (
Proprio Char(10),
Apelido Char(10),
Email Varchar(20),
Primary Key (Proprio, Apelido),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade
);

Create Table autorDeGois (
Proprio Char(10),
Apelido Char(10),
DeGois Varchar(5),
Primary Key (Proprio, Apelido),
Foreign Key (Proprio, Apelido) References autor On Delete Cascade
);

Create Table instituicao (
nomeI Char(10),
localI Varchar(20),
Primary Key (nomeI, localI)
);

Create Table vinculo ( --R1
Proprio Char(10),
Apelido Char(10),
nomeI Char(10),
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
TituloA Char(10),
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
NomeI Char(10),
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
Indice Integer Not Null,
DataB Timestamp,
Primary Key (IDArtigosB, Indice),
Foreign Key (IDArtigosB) References artigos(IDArtigos) On Delete Cascade
);

Create Table tem ( --R5
IDArtigos Varchar(5),
IDArtigosB Varchar(5),
Indice Integer Not Null,
Primary Key (IDArtigos, IDArtigosB, Indice),
Foreign Key (IDArtigos) References artigos On Delete Cascade,
Foreign Key (IDArtigosB, Indice) References bibliometria On Delete Cascade
);