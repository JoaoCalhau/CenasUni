CREATE TABLE docente (
nome CHAR(15),
email CHAR(25) PRIMARY KEY,
nomeDepartamento CHAR(15)
);
CREATE TABLE aluno (
numero INTEGER CHECK(numero>0),
nome CHAR(15) UNIQUE NOT NULL,
matricula INTEGER NOT NULL CHECK(matricula>2010),
PRIMARY KEY (numero)
)
CREATE TABLE disciplina (
/* num_disc INTEGER CHECK(num_disc>0),
*/
num_disc SERIAL,
nome_disc CHAR(15) UNIQUE NOT NULL,
ano INTEGER CHECK(ano>0 AND ano<6),
semestre CHAR(1) CHECK(semestre='P' OR semestre='I'),
creditos INTEGER CHECK(creditos>0),
ht INTEGER CHECK(hp>=0),
hp INTEGER CHECK(ht>=0),
PRIMARY KEY (num_disc),
UNIQUE (nome_disc)
);
CREATE TABLE disc_ano (
num_disc INTEGER CHECK(num_disc>0),
ano_lectivo INTEGER CHECK(ano_lectivo>2010),
email CHAR(60),
PRIMARY KEY (num_disc,ano_lectivo),
FOREIGN KEY (num_disc ) REFERENCES disciplina ON DELETE RESTRICT
);
CREATE TABLE inscricao(
numero INTEGER CHECK(numero>0),
num_disc INTEGER CHECK(num_disc>0),
ano_lectivo INTEGER CHECK(ano_lectivo>2010),
preco INTEGER NOT NULL CHECK(preco>0),
PRIMARY KEY (numero, num_disc, ano_lectivo),
FOREIGN KEY (numero) REFERENCES aluno ON DELETE CASCADE,
FOREIGN KEY (num_disc,ano_lectivo) REFERENCES disc_ano ON DELETE RESTRICT
);
CREATE TABLE aprovacao(
numero INTEGER CHECK(numero>0),
num_disc INTEGER CHECK(num_disc>0),
ano_lectivo INTEGER CHECK(ano_lectivo>2010),
epoca CHAR(1) CHECK(epoca='N' OR epoca='R' OR epoca='E'),
nota INTEGER NOT NULL CHECK(nota>=10),
PRIMARY KEY (numero, num_disc, ano_lectivo),
FOREIGN KEY (numero) REFERENCES aluno ON DELETE CASCADE,
FOREIGN KEY (num_disc,ano_lectivo) REFERENCES disc_ano ON DELETE RESTRICT
);


INSERT INTO docente VALUES('Maria','mr@uevora.pt','informatica');
INSERT INTO docente VALUES('Manuel''mnl@uevora.p','matematica');
INSERT INTO docente VALUES('Joaquim','jqm@uevora.pt','informatica');
INSERT INTO aluno VALUES(1,'Maria S', 2011);
INSERT INTO aluno VALUES(2,'Manuel A', 2012);
INSERT INTO aluno VALUES(3,'Joaquim R', 2011);
INSERT INTO aluno VALUES(4,'Mariana P', 2012);
INSERT INTO aluno VALUES(5,'Joana E', 2011);
INSERT INTO aluno VALUES(6,'Edmundo C', 2012);
INSERT INTO disciplina VALUES(1,'BD',3,'P',3,2,2);
INSERT INTO disciplina VALUES(2,'ADA',3,'P',3,2,3);
INSERT INTO disciplina VALUES(3,'ED',2,'I',3,2,3);
INSERT INTO disciplina VALUES(4,'P1',1,'I',3,2,3);
INSERT INTO disciplina VALUES(5,'P',1,'I',3,2,3);
INSERT INTO disciplina VALUES(6,'CC',5,'I',3,2,2);
INSERT INTO disciplina VALUES(7,'TI',4,'P',3,2,2);
INSERT INTO disc_ano VALUES(1,2013,'BD03-list');
INSERT INTO disc_ano VALUES(1,2012,'BD02-list');
INSERT INTO disc_ano VALUES(2,2013,'ADA03-list');
2INSERT INTO disc_ano VALUES(2,2012,'ADA02-list');
INSERT INTO disc_ano VALUES(3,2013,'ED03-list');
INSERT INTO disc_ano VALUES(3,2012,'ED02-list');
INSERT INTO disc_ano VALUES(4,2013,'P103-list');
INSERT INTO disc_ano VALUES(4,2012,'P102-list');
INSERT INTO disc_ano VALUES(5,2013,'P203-list');
INSERT INTO disc_ano VALUES(5,2012,'P202-list');
INSERT INTO disc_ano VALUES(6,2013,'CC03-list');
INSERT INTO inscricao VALUES(1,1,2012,20);
INSERT INTO inscricao VALUES(1,1,2013,30);
INSERT INTO inscricao VALUES(2,1,2012,20);
INSERT INTO inscricao VALUES(2,1,2013,30);
INSERT INTO inscricao VALUES(3,1,2013,20);
INSERT INTO inscricao VALUES(5,1,2012,20);
INSERT INTO inscricao VALUES(6,1,2013,20);
INSERT INTO aprovacao VALUES(1,1,2013,'R',12);
INSERT INTO aprovacao VALUES(2,1,2013,'N',15);
INSERT INTO aprovacao VALUES(3,1,2013,'N',14);
INSERT INTO aprovacao VALUES(5,1,2012,'N',13);
INSERT INTO inscricao VALUES(3,2,2012,20);
INSERT INTO inscricao VALUES(3,2,2013,30);
INSERT INTO inscricao VALUES(1,2,2012,20);
INSERT INTO inscricao VALUES(1,2,2013,20);
INSERT INTO inscricao VALUES(6,2,2013,20);
INSERT INTO inscricao VALUES(4,2,2012,20);
INSERT INTO inscricao VALUES(5,2,2013,20);
INSERT INTO aprovacao VALUES(1,2,2012,'N',10);
INSERT INTO aprovacao VALUES(6,2,2013,'N',13);
INSERT INTO aprovacao VALUES(3,2,2013,'N',14);
INSERT INTO aprovacao VALUES(5,2,2012,'N',13);
INSERT INTO inscricao VALUES(3,5,2013,20);
INSERT INTO inscricao VALUES(6,5,2013,20);
INSERT INTO inscricao VALUES(1,5,2013,20);
INSERT INTO aprovacao VALUES(1,5,2013,'N',12);
INSERT INTO aprovacao VALUES(6,5,2013,'N',13);