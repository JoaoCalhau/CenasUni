CREATE TABLE Questionario(
	numQuest INT,
	nomeQuest VARCHAR(180),
	PRIMARY KEY (NumQuest)
);

CREATE TABLE Pergunta(
	numQuest INT,
	numPergunta INT,
	perg VARCHAR(180),
	resposta INT,
	cont INT,
	PRIMARY KEY (numQuest,numPergunta),
	FOREIGN KEY (numQuest) REFERENCES Questionario (numQuest) ON DELETE CASCADE
);

CREATE TABLE Contador(
	contador INT,
	PRIMARY KEY (contador)
);

INSERT INTO Contador VALUES(0);