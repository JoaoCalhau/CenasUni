CREATE TABLE clienteViaVerde (
NIB INTEGER CHECK(NIB>0),
NIF INTEGER CHECK(NIF>0) PRIMARY KEY,
IdViaVerde INTEGER CHECK(IdViaVerde>0),
Matricula INTEGER CHECK(Matricua>0),
Nome CHAR(15),
Morada CHAR(30),
Cidade CHAR(10)
);

CREATE TABLE clienteViaVerdePass (
IdViaVerde INTEGER CHECK(IdViaVerde>0) PRIMARY KEY,
NPassp INTEGER CHECK(NPassp>0)
);

CREATE TABLE clienteViaVerdeBi (
IdViaVerde INTEGER CHECK(IdViaVerde>0) 	PRIMARY KEY,
NPBi INTEGER CHECK(NPBi>0)
);

CREATE TABLE clienteServico (
NIF INTEGER CHECK(NiF>0) PRIMARY KEY,
NIB INTEGER CHECK(NIB>0),
Nome CHAR(15),
Morada CHAR(30),
Cidade CHAR(10)
);

CREATE TABLE servico (
NIF INTEGER CHECK(NIF>0) PRIMARY KEY,
IdLocal INTEGER CHECK(IdLocal>0),
NomeLocal CHAR(15)
);

CREATE TABLE bomba (
IdLocal INTEGER CHECK(IdLocal>0) PRIMARY KEY,
Morada CHAR(30),
Cidade CHAR(10)
);

CREATE TABLE ponte (
IdLocal INTEGER CHECK(IdLocal>0) PRIMARY KEY,
Valor INTEGER CHECK(Valor>0)
);

CREATE TABLE parque (
IdLocal INTEGER CHECK(IdLocal>0) PRIMARY KEY,
ValorMinuto INTEGER CHECK(ValorMinuto >0)
);

CREATE TABLE portagemAutoEstrada (
IdLocal INTEGER CHECK(IdLocal>0) PRIMARY KEY,
Km INTEGER CHECK(Km>0),
Saida INTEGER CHECK(Saida>0),
Valor INTEGER CHECK(Valor>0)
);

CREATE TABLE tem (
Idlocal INTEGER CHECK(IdLocal>0) PRIMARY KEY,
IdLocalP INTEGER CHECK(IdLocalIP>0)
);

CREATE TABLE cancelaParq (
IdViaVerde INTEGER CHECK(IdViaVerde>0),
IdLocalP INTEGER CHECK(IdLocalP>0),
