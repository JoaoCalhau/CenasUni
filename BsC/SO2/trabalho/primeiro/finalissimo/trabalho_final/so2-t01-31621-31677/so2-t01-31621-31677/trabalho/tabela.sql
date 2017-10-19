DROP owned BY l31621;

CREATE TABLE questionarios(
	idQuest int,
	NomeQuest varchar(255),
	tamanhoQuest int,
	PRIMARY KEY(idQuest)
);

CREATE TABLE Perguntas(
	idQuest int,
	idPergunta int,
	NomePergunta varchar(255),
	total int,
	quantP int,
	PRIMARY KEY(idQuest, idPergunta),
	FOREIGN KEY(idQuest) REFERENCES questionarios(idQuest) ON DELETE CASCADE
);

CREATE TABLE QuantQuest(
	curr int,
	PRIMARY KEY(curr)
);

INSERT INTO QuantQuest VALUES (0);