drop schema public cascade;
create schema public;


CREATE TABLE clienteViaVerde (
NIB INTEGER NOT NULL,
NiF INTEGER NOT NULL,
IdViaVerde INTEGER NOT NULL,
Matricula VARCHAR(15),
Nome CHAR(15),
Morada VARCHAR(30),
Cidade CHAR(10),
PRIMARY KEY (IdViaVerde)
);

CREATE TABLE clienteViaVerdePass (
IdViaVerde INTEGER NOT NULL,
NPassp INTEGER NOT NULL,
PRIMARY KEY (IdViaVerde),
FOREIGN KEY (IdViaVerde) REFERENCES clienteViaVerde ON DELETE RESTRICT
);

CREATE TABLE clienteViaVerdeBi (
IdViaVerde INTEGER NOT NULL,
NPBi INTEGER NOT NULL,
PRIMARY KEY (IdViaVerde),
FOREIGN KEY (idViaverde) REFERENCES clienteViaVerde ON DELETE RESTRICT
);

CREATE TABLE clienteServico (
NIF INTEGER NOT NULL,
NIB INTEGER NOT NULL,
Nome CHAR(16),
Morada VARCHAR(30),
Cidade CHAR(10),
PRIMARY KEY (NIF)
);

CREATE TABLE servico (
NIF INTEGER NOT NULL,
IdLocal CHAR(15),
NomeLocal CHAR(17),
PRIMARY KEY (IdLocal),
FOREIGN KEY (NIF) REFERENCES clienteServico ON DELETE RESTRICT
);

CREATE TABLE bomba (
IdLocal CHAR(15),
Cidade CHAR(10),
Morada VARCHAR(30),
PRIMARY KEY (IdLocal),
FOREIGN KEY (IdLocal) REFERENCES servico ON DELETE RESTRICT
);

CREATE TABLE ponte (
IdLocal CHAR(15),
Valor INTEGER NOT NULL,
PRIMARY KEY(IdLocal),
FOREIGN KEY (IdLocal) REFERENCES servico ON DELETE RESTRICT
);

CREATE TABLE parque (
IdLocal CHAR(15),
ValorMinuto FLOAT NOT NULL,
PRIMARY KEY (IdLocal),
FOREIGN KEY (IdLocal) REFERENCES servico ON DELETE RESTRICT
);

CREATE TABLE portagemAutoEstrada (
IdLocal CHAR(15),
Km INTEGER NOT NULL CHECK(Km>0),
Saida VARCHAR(10),
Valor INTEGER NOT NULL CHECK(Valor>0),
PRIMARY KEY (IdLocal, Saida),
FOREIGN KEY (IdLocal) REFERENCES servico ON DELETE RESTRICT
);

CREATE TABLE tem (
IdLocal CHAR(15),
IdLocalP VARCHAR(20),
PRIMARY KEY (IdLocalP),
FOREIGN KEY (IdLocal) REFERENCES servico ON DELETE RESTRICT
);

CREATE TABLE cancelaParq (
idViaVerde INTEGER NOT NULL,
idLocalP VARCHAR(20),
EntradaSaida VARCHAR(20),
DataD TIMESTAMP,
PRIMARY KEY (idViaverde, idLocalP, DataD),
FOREIGN KEY (idViaVerde) REFERENCES clienteViaVerde,
FOREIGN KEY (idLocalP) REFERENCES tem
);

CREATE TABLE passagemAE (
idViaVerde INTEGER NOT NULL,
idLocalP VARCHAR(20),
DataD TIMESTAMP, /*YYYY-MM-DD HH:MI:SS*/
PRIMARY KEY (idViaVerde, DataD),
FOREIGN KEY (idViaVerde) REFERENCES clienteViaVerde ON DELETE RESTRICT,
FOREIGN KEY (idLocalP) REFERENCES tem ON DELETE RESTRICT
);

CREATE TABLE abastecimento (
idViaVerde INTEGER NOT NULL,
idLocalP VARCHAR(20),
DataD TIMESTAMP,
Valor INTEGER NOT NULL CHECK(Valor>0),
PRIMARY KEY (idViaVerde,DataD),
FOREIGN KEY (idViaVerde) REFERENCES clienteViaVerde ON DELETE RESTRICT,
FOREIGN KEY (idLocalP) REFERENCES tem ON DELETE RESTRICT
);

--3 --
INSERT INTO clienteServico VALUES(123456789, 88888888 , 'Brisa', 'Rua da Seguradora 17', 'Lisboa');

INSERT INTO servico VALUES(123456789, 'AE-A2', 'A2');
INSERT INTO servico VALUES(123456789, 'AE-A1', 'A1');
INSERT INTO servico VALUES(123456789, 'AE-A6', 'A6');

INSERT INTO portagemAutoEstrada VALUES('AE-A2', 10, 'Evora', 3);
INSERT INTO portagemAutoEstrada VALUES('AE-A2', 20, 'Beja', 3);
INSERT INTO portagemAutoEstrada VALUES('AE-A2', 30, 'Faro', 3);

INSERT INTO tem VALUES('AE-A2', 'A2-Saida1');
INSERT INTO tem VALUES('AE-A2', 'A2-Saida2');
INSERT INTO tem VALUES('AE-A2', 'A2-Saida3');

INSERT INTO portagemAutoEstrada VALUES('AE-A1', 17, 'Porto', 3);
INSERT INTO portagemAutoEstrada VALUES('AE-A1', 27, 'Braga', 3);
INSERT INTO portagemAutoEstrada VALUES('AE-A1', 37, 'Guimaraes', 3);

INSERT INTO tem VALUES('AE-A1', 'A1-Saida1');
INSERT INTO tem VALUES('AE-A1', 'A1-Saida2');
INSERT INTO tem VALUES('AE-A1', 'A1-Saida3');

INSERT INTO portagemAutoEstrada VALUES('AE-A6', 11, 'Lisboa', 3);
INSERT INTO portagemAutoEstrada VALUES('AE-A6', 21, 'Setubisal', 3);
INSERT INTO portagemAutoEstrada VALUES('AE-A6', 31, 'Odemira', 3);

INSERT INTO tem VALUES('AE-A6', 'A6-Saida1');
INSERT INTO tem VALUES('AE-A6', 'A6-Saida2');
INSERT INTO tem VALUES('AE-A6', 'A6-Saida3');

INSERT INTO clienteServico VALUES(000641900, 71717171 , 'Galp', 'Rua da Gasolina 2', 'Sines');

INSERT INTO servico VALUES(000641900, 'B. Evora', 'Bomba Evora');
INSERT INTO servico VALUES(000641900, 'B. Grandola', 'Bomba Grandola');

INSERT INTO bomba VALUES('B. Evora', 'Evora', 'Rua com Gasolina 99');
INSERT INTO bomba VALUES('B. Grandola', 'Grandola', 'Rua sem Gasoleo 12');

INSERT INTO tem VALUES('B. Evora', 'Evr-Gasolina');
INSERT INTO tem VALUES('B. Evora', 'Evr-Gasoleo');

INSERT INTO tem VALUES('B. Grandola', 'Gr-Gasolina');
INSERT INTO tem VALUES('B. Grandola', 'Gr-Gasoleo');


INSERT INTO clienteServico VALUES(119087311, 62626262, 'LusoPonte', 'Travessa Sim 33', 'Lisboa');

INSERT INTO servico VALUES(119087311, 'Pt vG', 'Ponte V. Gama');
INSERT INTO servico VALUES(119087311, 'Pt 25', 'Ponte 25 Abril');

INSERT INTO ponte VALUES('Pt vG', 2);
INSERT INTO ponte VALUES('Pt 25', 1);

INSERT INTO tem VALUES('Pt vG', 'PtVG-EntradaSul');
INSERT INTO tem VALUES('Pt vG', 'PtVG-SaidaSul');
INSERT INTO tem VALUES('Pt vG', 'PtVG-EntradaNorte');
INSERT INTO tem VALUES('Pt vG', 'PtVG-SaidaNorte');

INSERT INTO tem VALUES('Pt 25', 'Pt25-EntradaSul');
INSERT INTO tem VALUES('Pt 25', 'Pt25-SaidaSul');
INSERT INTO tem VALUES('Pt 25', 'Pt25-EntradaNorte');
INSERT INTO tem VALUES('Pt 25', 'Pt25-SaidaNorte');


INSERT INTO clienteServico VALUES(223344319, 53535353, 'BragaParques', 'Beco da beca', 'Braga');

INSERT INTO servico VALUES(223344319, 'Pq Evr', 'Parque de Évora');
INSERT INTO servico VALUES(223344319, 'Pq Lx', 'Parque de Lisboa');

INSERT INTO parque VALUES('Pq Evr', 0.03);
INSERT INTO parque VALUES('Pq Lx', 0.04);

INSERT INTO tem VALUES('Pq Evr', 'PE-Ent1');
INSERT INTO tem VALUES('Pq Evr', 'PE-Ent2');
INSERT INTO tem VALUES('Pq Evr', 'PE-Ent3');
INSERT INTO tem VALUES('Pq Evr', 'PE-Said1');
INSERT INTO tem VALUES('Pq Evr', 'PE-Said2');
INSERT INTO tem VALUES('Pq Evr', 'PE-Said3');

INSERT INTO tem VALUES('Pq Lx', 'PL-Ent1');
INSERT INTO tem VALUES('Pq Lx', 'PL-Ent2');
INSERT INTO tem VALUES('Pq Lx', 'PL-Ent3');
INSERT INTO tem VALUES('Pq Lx', 'PL-Said1');
INSERT INTO tem VALUES('Pq Lx', 'PL-Said2');
INSERT INTO tem VALUES('Pq Lx', 'PL-Said3');


INSERT INTO clienteViaVerde VALUES(776537221, 49494949, 123, '23-45-AA', 'Sr Silva', 'Rua do Revo 10', 'Évora');


INSERT INTO clienteViaVerde VALUES(766418241, 18171615, 124, '22-45-AA', 'Sra Santos', 'Rua do ZéCarlos 23', 'Évora');


INSERT INTO clienteViaVerde VALUES(760103103, 12332112, 125, '21-45-AA', 'Sr Gomes', 'Rua do Shimno 4', 'Évora');


INSERT INTO cancelaParq VALUES(123, 'PL-Ent1', 'Entrada', '2014-10-12 18:33' );

INSERT INTO cancelaParq VALUES(123, 'PL-Said1', 'Saida', '2014-10-13 08:12' );

INSERT INTO cancelaParq VALUES(124, 'PL-Ent2', 'Entrada', '2014-10-10 11:22' );

INSERT INTO cancelaParq VALUES(124, 'PL-Said2', 'Saida', '2014-10-12 13:30' );

INSERT INTO passagemAE VALUES(125, 'A2-Saida1', '2009-11-12 14:05' );

INSERT INTO passagemAE VALUES(125, 'A2-Saida2', '2009-11-12 15:00' );

INSERT INTO passagemAE VALUES(125, 'PtVG-EntradaSul', '2009-11-01 18:05');
INSERT INTO passagemAE VALUES(125, 'PtVG-SaidaNorte', '2009-11-01 18:15');

INSERT INTO abastecimento VALUES(125, 'Evr-Gasoleo', '2009-10-11 21:00', 50 );


--4--

INSERT INTO clienteViaVerde VALUES(967781235, 244424442, 6969, 'GA-15-40', 'Miguel Xalupa', 'Av. cheia de ping 500ms', 'Évora');

INSERT INTO clienteViaVerdePass VALUES(6969, 999966669);

INSERT INTO abastecimento VALUES(123, 'Evr-Gasolina', '13-02-11 21:00', 35 );
INSERT INTO abastecimento VALUES(123, 'Evr-Gasoleo', '13-02-11 21:01', 65 );
INSERT INTO abastecimento VALUES(123, 'Evr-Gasoleo', '13-11-14 21:01', 65 );

INSERT INTO abastecimento VALUES(123, 'Gr-Gasoleo', '15-01-14 21:01', 65 );

INSERT INTO abastecimento VALUES(123, 'Gr-Gasoleo', '15-09-14 21:01', 65 );

INSERT INTO passagemAE VALUES(125, 'A2-Saida1', '2014-11-01 18:15');
/*
-- 5---
--a
SELECT nome FROM clienteViaVerde, clienteViaVerdePass WHERE clienteViaVerde.idViaVerde = clienteViaVerdePass.idViaVerde;

--b
SELECT * FROM clienteServico NATURAL INNER JOIN servico NATURAL INNER JOIN abastecimento NATURAL INNER JOIN tem INNER JOIN clienteViaVerde ON clienteViaVerde.idViaVerde = abastecimento.idViaVerde WHERE tem.idLocal='B. Evora' ;

--c
SELECT matricula FROM clienteViaVerde NATURAL INNER JOIN passagemAE NATURAL INNER JOIN tem NATURAL INNER JOIN portagemAutoEstrada WHERE idLocalP='A2-Saida2';

--d
SELECT idLocalP,DataD FROM clienteViaVerde NATURAL INNER JOIN abastecimento WHERE idViaVerde=123
UNION
SELECT idLocalP,DataD FROM clienteViaVerde NATURAL INNER JOIN cancelaParq WHERE idViaVerde=123
UNION
SELECT idLocalP,DataD FROM clienteViaVerde NATURAL INNER JOIN passagemAE WHERE idViaVerde=123;

--e
select sum(ponte.valor) from clienteViaVerde natural inner join ponte inner join tem on tem.idlocal=ponte.idlocal inner join passagemAE on tem.idLocalP=passagemAE.idLocalP where date_part('month',datad)=10 and date_part('year',datad)=2014 and clienteViaVerde.idViaVerde='123'
UNION
select sum(portagemautoestrada.valor) from clienteViaVerde natural inner join portagemAutoEstrada inner join tem on portagemAutoEstrada.idlocal=tem.idLocal inner join passagemAE on tem.idlocalP=passagemAE.idLocalP where date_part('month',datad)=10 and date_part('year',datad)=2014 and clienteViaVerde.idViaVerde='123'
UNION
select sum(abastecimento.valor) from clienteViaVerde natural inner join abastecimento where clienteviaverde.idViaVerde='123' and date_part('month',datad)=10 and date_part('year',datad)=2014
UNION
select sum((extract(epoch from(B.datad-A.datad))/60)*parque.valorminuto) valor_final from clienteViaVerde natural inner join cancelaParq as A inner join cancelaParq as B on A.idViaVerde=B.idViaVerde inner join tem on tem.idlocalP=A.idlocalP inner join parque on tem.idlocal=parque.idlocal where date_part('month',A.datad)=10 and date_part('year',A.datad)=2014 and date_part('month',B.datad)=10 and date_part('year',B.datad)=2014 and A.entradasaida='Entrada' and B.entradasaida='Saida' and clienteViaVerde.idViaVerde='123';

--f
select sum(ponte.valor) from clienteViaVerde natural inner join ponte inner join tem on tem.idlocal=ponte.idlocal inner join passagemAE on tem.idLocalP=passagemAE.idLocalP where date_part('month',datad)=10 and clienteViaVerde.nome='Sr Silva'
UNION
select sum(portagemautoestrada.valor) from clienteViaVerde natural inner join portagemAutoEstrada inner join tem on portagemAutoEstrada.idlocal=tem.idLocal inner join passagemAE on tem.idlocalP=passagemAE.idLocalP where date_part('month',datad)=10 and clienteViaVerde.nome='Sr Silva'
UNION
select sum(abastecimento.valor) from clienteViaVerde natural inner join abastecimento where clienteviaverde.nome='Sr Silva' and date_part('month',datad)=10
UNION
select sum((extract(epoch from(B.datad-A.datad))/60)*parque.valorminuto) valor_final from clienteViaVerde natural inner join cancelaParq as A inner join cancelaParq as B on A.idViaVerde=B.idViaVerde inner join tem on tem.idlocalP=A.idlocalP inner join parque on tem.idlocal=parque.idlocal where date_part('month',A.datad)=10 and date_part('month',B.datad)=10 and A.entradasaida='Entrada' and B.entradasaida='Saida' and clienteViaVerde.nome='Sr Silva';

--g
select nome,abastecimento.idViaVerde from clienteViaVerde inner join abastecimento on clienteViaVerde.idviaverde=abastecimento.idviaverde;

-h
select distinct nome, abastecimento.idviaverde from cancelaParq inner join clienteViaVerde on clienteViaVerde.idViaVerde=cancelaParq.idViaVerde;

--i
select A.idviaverde, nome, max (B.datad-A.datad) as tempo from clienteviaverde natural inner join cancelaparq as A inner join cancelaparq as B on A.idviaverde=B.idviaverde where A.entradasaida='Entrada' and B.entradasaida='Saida' group by A.idviaverde, nome order by tempo desc limit 1;

--j
select nomelocal, count(clienteviaverde.idViaVerde) as ocurrencias from clienteViaVerde natural inner join passagemAE natural inner join tem natural inner join ponte natural inner join servico where date_part('year',datad)=2014 GROUP BY nomelocal order by ocurrencias desc limit 1;

--k
select nomelocal, count(bomba.idlocal) as ocurrencias from servico inner join bomba on bomba.idlocal=servico.idlocal group by nomelocal order by ocurrencias desc limit 1;

--l
select distinct nomelocal, idViaVerde, saida, datad, valor from servico natural inner join portagemAutoEstrada natural inner join passagemAE inner join tem on passagemAE.idLocalP=tem.idLocalP where date_part('year',datad)=2014 and tem.idLocal=servico.idlocal;

--m


--n
select distinct passagemAE.idviaverde, nome from passagemAE natural inner join clienteViaVerde natural inner join tem natural inner join portagemAutoEstrada as A inner join portagemAutoEstrada as B on A.idlocal=B.idlocal inner join portagemAutoEstrada as C on B.idlocal=C.idlocal where A.saida='Evora' and B.saida='Beja' and C.saida='Faro';

--o
select clienteViaVerde.idViaVerde, nome from clienteviaverde
EXCEPT
select clienteViaVerde.idViaVerde, nome from clienteviaverde natural inner join passagemAE inner join tem on passagemAE.idlocalP=tem.idLocalP inner join ponte on tem.idLocal=ponte.idLocal; 

--p
select nome from clienteServico
EXCEPT
(select nome from clienteServico natural inner join servico natural inner join tem natural inner join cancelaParq where date_part('month',datad)=09
UNION 
select nome from clienteServico natural inner join servico natural inner join tem natural inner join passagemAE where date_part('month',datad)=09
UNION
select nome from clienteServico natural inner join servico natural inner join tem natural inner join abastecimento where date_part('month',datad)=09);
*/