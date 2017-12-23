drop owned by john;

create table data (
	"Chave da Data" 				integer not null,
	"Data Completa"					text,
	"Descrição da Data"				text,
	"Número do Dia da Semana"		integer,
	"Número do Dia do Mês"			integer,
	"Número do Dia do Trimestre"	integer,
	"Número do Dia do Semestre"		integer,
	"Número do Dia do Ano"			integer,
	"Número do Dia Absoluto"		integer,
	"Número da Semana"				integer,
	"Número do Mês"					integer,
	"Número do Trimestre"			integer,
	"Número do Semestre"			integer,
	"Número do Ano"					integer,
	"Nome do Dia da Semana"			text,
	"Nome do Mês"					text,
	"É Dia de Semana"				text,
	"É Feriado"						text,
	"É Ano Bissexto"				text,
	"Estação do Ano"				text,
	"Data de Inicio da Semana"		date,
	"Data de Final da Semana"		date,
	"Dada de Inicio do Mês"			date,
	"Data de Final do Mês"			date,
	"Data de Inicio do Trimestre"	date,
	"Data de Final do Trimestre"	date,
	"Data de Inicio do Semestre"	date,
	"Data de Final do Semestre"		date,
	primary key("Chave da Data")		
);

create table hora (
	"Chave da Hora"		integer not null,
	"Hora Completa"		text,
	"Descrição da Hora"	text,
	"Hora" 				text,
	"Minuto" 			text,
	"Segundo" 			text,
	primary key("Chave da Hora")
);

create table localizacao (
	"Chave da Localização" 		integer not null,
	"Coordenadas Geográficas"	text,
	"Latitude"					text,
	"Longitude"					text,
	"Número da Porta"			text,
	"Rua"						text,
	"Código Postal"				text,
	"Freguesia"					text,
	"Concelho"					text,
	"Distrito"					text,
	"Região"					text,
	"País"						text,
	primary key("Chave da Localização")
);

create table farmacia (
	"Chave da Farmácia"			integer not null,
	"Nome da Farmácia"			text,
	"Número de Telefone"		text,
	"Hora de Abertura"			time,
	"Hora de Fecho"				time,
	"E-mail"					text,
	"Website"					text,
	"Coordenadas Geográficas"	text,
	"Número da Porta"			text,
	"Rua"						text,
	"Código Postal"				text,
	"Freguesia"					text,
	"Concelho"					text,
	"Distrito"					text,
	"Região"					text,
	primary key("Chave da Farmácia")
);

create table laboratorio (
	"Chave do Laboratório"		integer not null,
	"Nome do Laboratório"		text,
	"Número de Telefone"		text,
	"Número de Fax"				text,
	"E-mail"					text,
	"Coordenadas Geográficas"	text,
	"Número da Porta"			text,
	"Rua"						text,
	"Código Postal"				text,
	"Freguesia"					text,
	"Concelho"					text,
	"Distrito"					text,
	"Região"					text,
	"País"						text,
	primary key("Chave do Laboratório")
);

create table medico (
	"Chave do Médico"				integer not null,
	"Nome do Médico"				text,
	"Cartão de Cidadão do Médico"	text,
	"Número da Cédula"				text,
	"Nacionalidade"					text,
	"Data de Nascimento"			date,
	"Sexo"							text,
	"Número de Telefone"			text,
	"Número de Telemóvel"			text,
	"Especialidade Médica"			text,
	"E-mail"						text,
	primary key("Chave do Médico")
);

create table paciente (
	"Chave do Paciente"					integer not null,
	"Nome do Paciente"					text,
	"Cartão de Cidadão"					text,
	"Número de Documento"				text,
	"Número de Identificação Fiscal"	text,
	"Número de Segurança Social"		text,
	"Número de Utente de Saúde"			text,
	"Nome do Subsistema de Saúde"		text,
	"Nacionalidade"						text,
	"Data de Nascimento"				date,
	"Sexo"								text,
	"Altura"							text,
	"Filiação"							text,
	"Número de Telefone"				text,
	"Número de Telemóvel"				text,
	"E-mail"							text,
	"Número da Porta"					text,
	"Rua"								text,
	"Código Postal"						text,
	"Freguesia"							text,
	"Concelho"							text,
	"Distrito"							text,
	"Região"							text,
	primary key("Chave do Paciente")
);

create table medicamento (
	"Chave do Medicamento"							integer not null,
	"Nome do Medicamento"							text,
	"Número de Registo"								text,
	"Composição"									text,
	"Unidades"										text,
	"Forma Farmaceútica"							text,
	"É Genérico"									text,
	"Nome do Laboratório"							text,
	"Estado da Autorização"							text,
	"Data da Autorização"							date,
	"Tamanho da Embalagem"							text,
	"CNPEM"											text,
	"CHNM"											text,
	"É Comercializado"								text,
	"Classificação Farmacoterapêutica - Grupo"		text,
	"Classificação Farmacoterapêutica - Subgrupo"	text,
	"Classificação Farmacoterapêutica - Tipo"		text,
	"Indicações"									text,
	"Contra-Indicações"								text,
	"Interações"									text,
	"Efeitos Secundários"							text,
	"Vias de Administração"							text,
	"Início do Efeíto"								text,
	"Eliminação"									text,
	"Descrição"										text,
	"Data de Validade do Medicamento"				date,
	"Comparticipação do SNS"						text,
	"Comparticipação da ADSE"						text,
	"Comparticipação da ADME"						text,
	"Comparticipação da Segurança Social"			text,
	"Preço do Medicamento"							text,
	"Chave do Laboratório"							integer,
	primary key("Chave do Medicamento"),
	foreign key("Chave do Laboratório") references laboratorio("Chave do Laboratório")
);

create table vendas (
	"Chave da Data" 						integer not null,
	"Chave da Hora"							integer not null,
	"Chave da Localização" 					integer not null,
	"Chave da Farmácia"						integer not null,
	"Chave do Médico"						integer not null,
	"Chave do Paciente"						integer not null,
	"Chave do Medicamento"					integer not null,
	"Número de Referencia da Factura"		text,
	"Número de Referencia da Receita (DD)"	text,
	primary key("Chave da Data", "Chave da Hora", "Chave da Localização", "Chave da Farmácia", "Chave do Médico", "Chave do Paciente", "Chave do Medicamento"),
	foreign key("Chave da Hora") references data("Chave da Data"),
	foreign key("Chave da Localização") references localizacao("Chave da Localização"),
	foreign key("Chave da Farmácia") references farmacia("Chave da Farmácia"),
	foreign key("Chave do Médico") references medico("Chave do Médico"),
	foreign key("Chave do Paciente") references paciente("Chave do Paciente"),
	foreign key("Chave do Medicamento") references medicamento("Chave do Medicamento")
);

create table semestre (
	"Chave do Semestre"				integer not null,
	"Número do Ano"					text,
	"Número do Semestre"			text,
	"Descrição do Semestre"			text,
	"Data de Inicio do Semestre"	date,
	"Data de Final do Semestre"		date,
	primary key("Chave do Semestre")
);

create table venda_por_semestre (
	"Chave do Semestre"	integer not null,
	"Chave da Localização" 					integer not null,
	"Chave da Farmácia"						integer not null,
	"Chave do Médico"						integer not null,
	"Chave do Paciente"						integer not null,
	"Chave do Medicamento"					integer not null,
	"Número de Referencia da Factura"		text,
	"Número de Referencia da Receita (DD)"	text,
	primary key("Chave do Semestre", "Chave da Localização", "Chave da Farmácia", "Chave do Médico", "Chave do Paciente", "Chave do Medicamento"),
	foreign key("Chave do Semestre") references semestre("Chave do Semestre"),
	foreign key("Chave da Localização") references localizacao("Chave da Localização"),
	foreign key("Chave da Farmácia") references farmacia("Chave da Farmácia"),
	foreign key("Chave do Médico") references medico("Chave do Médico"),
	foreign key("Chave do Paciente") references paciente("Chave do Paciente"),
	foreign key("Chave do Medicamento") references medicamento("Chave do Medicamento")
);
