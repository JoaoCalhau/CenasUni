drop owned by john;

create table hora (
	"Hora Completa" text not null,
	"Hora" 			text,
	"Minuto"		text,
	"Segundo"		text,
	"Altura do Dia"	text,
	primary key("Hora Completa")
);

create table data (
	"Data Completa"					text not null,
	"Número do Dia da Semana"		text,
	"Número do Dia do Mês"			text,
	"Número do Dia do Trimestre"	text,
	"Número do Dia do Semestre"		text,
	"Número do Dia do Ano"			text,
	"Número do Dia Absoluto"		text,
	"Nome do Dia da Semana"			text,
	"É Dia de Semana"				text,
	"É Feriado"						text,
	"Número da Semana"				text,
	"Nome do Mês"					text,
	"Data de Inicio da Semana"		text,
	"Data de Final da Semana"		text,
	"Data de Inicio do Mês"			text,
	"Data de Final do Mês"			text,
	"Data de Inicio do Trimestre"	text,
	"Data de Final do Trimestre"	text,
	"Data de Inicio do Semestre"	text,
	"Data de Fim do Semestre"		text,
	"Número do Ano"					text,
	"É Ano Bissexto"				text,
	"Estação do Ano"				text,
	primary key("Data Completa")
);

create table cc (
	"Nome"								text,
	"Apelido" 							text,
	"Número de Identificação Civil" 	text not null,
	"Número do Documento"				text,
	"Nacionalidade"						text,
	"Data de Nascimento"				text,
	"Data de Validade" 					text,
	"Filiação"							text,
	"Número de Telefone"				text,
	"Número de Telemovel"				text,
	"Número de Identificação Fiscal"	text,
	"Número de Segurança Social"		text,
	"Número de Utente de Saúde"			text,
	"Morada"							text,
	primary key("Número de Identificação Civil"),
	foreign key("Data de Nascimento") references data("Data Completa"),
	foreign key("Data de Validade") references data("Data Completa"),
	foreign key("Morada") references localizacao("Coordenadas Geográficas")
);

create table localizacao (
	"Coordenadas Geográficas"	text not null,
	"Latitude"					text,
	"Longitude"					text,
	"País"						text,
	"Região"					text,
	"Distrito"					text,
	"Concelho"					text,
	"Freguesia"					text,
	"Rua"						text,
	"Número da Porta"			text,
	"Código Postal"				text,
	primary key("Coordenadas Geográficas")
);

create table farmacia (
	"Localização"			text not null,
	"Nome da Farmácia"		text not null,
	"Número de Telefone"	text,
	"Hora de Abertura"		text,
	"Hora de Fecho"			text,
	"E-mail"				text,
	"Website"				text,
	primary key("Localização", "Nome da Farmácia"),
	foreign key("Localização") references localizacao("Coordenadas Geográficas"),
	foreign key("Hora de Abertura") references hora("Hora Completa"),
	foreign key("Hora de Fecho") references hora("Hora Completa")
);

create table laboratorio (
	"Localização"			text not null,
	"Nome do Laboratório"	text not null,
	"Telefone"				text,
	"Fax"					text,
	"E-mail"				text,
	primary key("Localização", "Nome do Laboratório"),
	foreign key("Localização") references localizacao("Coordenadas Geográficas")
);

create table medico (
	"Cartão de Cidadão"	text,
	"Número da Cédula"	text not null,
	"Especialidade"		text,
	"Morada"			text,
	primary key("Número da Cédula"),
	foreign key("Cartão de Cidadão") references cc("Número de Identificação Civil"),
	foreign key("Morada") references localizacao("Coordenadas Geográficas")
);

create table paciente (
	"Cartão de Cidadão"		text not null,
	"Morada"				text not null,
	"E-mail"				text,
	"Subsistema"			text,
	primary key("Cartão de Cidadão", "Morada"),
	foreign key("Cartão de Cidadão") references cc("Número de Identificação Civil"),
	foreign key("Morada") references localizacao("Coordenadas Geográficas")
);

create table medicamento(
	"Composição"			text,
	"Nome do Medicamento"	text,
	"Dosagem"				text,
	"Unidades"				text,
	"Forma Farmaceutica"	text,
	"Genérico"				text,
	"Laboratório"			text,
	"Nome do Laboratório"	text,
	"Data de Autorização"	text,
	"Estado da Autorização"	text,
	"Tamanho da Embalagem"	text,
	"Número de Registo"		text not null,
	"CNPEM"					text,
	"CHNM"					text,
	"Comercializado"		text,
	"Grupo"					text,
	"Indicações"			text,
	"Contra-Indicações"		text,
	"Interações"			text,
	"Efeitos Secundários"	text,
	"Via de Administração"	text,
	"Inicio de Efeito"		text,
	"Eliminação"			text,
	"Descrição"				text,
	"Prazo de Validdade"	text,
	"Comparticipação SNS"	text,
	"Comparticipação ADSE"	text,
	"Comparticipação ADME"	text,
	"Comparticipação SS"	text,
	"Preço"					text,
	primary key("Número de Registo"),
	foreign key("Laboratório", "Nome do Laboratório") references laboratorio("Localização", "Nome do Laboratório"),
	foreign key("Data de Autorização") references data("Data Completa"),
	foreign key("Prazo de Validdade") references data("Data Completa")
);