drop owned by john;

create table hora (
	'Chave da Hora'	text not null,
	'hora'			text,
	'minuto'		text,
	'segundo'		text,
	'altura do dia'	text,
	primary key('Chave da Hora')
);

create table data (
	'Chave da Data'					text not null,
	'Data Completa'					text,
	'Número do Dia da Semana'		text,
	'Número do Dia do Mês'			text,
	'Número do Dia do Trimestre'	text,
	'Número do Dia do Semestre'		text,
	'Número do Dia do Ano'			text,
	'Número do Dia Absoluto'		text,
	'Nome do Dia da Semana'			text,
	'É Dia de Semana'				text,
	'É Feriado'						text,
	'Número da Semana'				text,
	'Nome do Mês'					text,
	'Data de Inicio da Semana'		text,
	'Data de Final da Semana'		text,
	'Data de Inicio do Mês'			text,
	'Data de Final do Mês'			text,
	'Data de Inicio do Trimestre'	text,
	'Data de Final do Trimestre'	text,
	'Data de Inicio do Semestre'	text,
	'Data de Fim do Semestre'		text,
	'Número do Ano'					text,
	'É Ano Bissexto'				text,
	'Estação do Ano'				text,
	primary key('Chave da Data')
);

create view data_rp as select * from data; -- Role Playing

create view hora_rp as select * from farmacia; -- Role Playing

create table identidade (
	'Chave da Identidade'				text not null,
	'Nome'								text,
	'Apelido' 							text,
	'Número de Identificação Civil' 	text,
	'Número do Documento'				text,
	'Nacionalidade'						text,
	'Data de Nascimento'				text,
	'Data de Validade' 					text,
	'Filiação'							text,
	'Número de Identificação Fiscal'	text,
	'Número de Segurança Social'		text,
	'Número de Utente de Saúde'			text,
	primary key('Chave da Identidade'),
	foreign key('Data de Nascimento') references data('Chave da Data'),
	foreign key('Data de Validade') references data_rp('Chave da Data')
);

create table localizacao (
	'Chave da Localização'	text not null,
	'Latitude'				text,
	'Longitude'				text,
	'País'					text,
	'Região'				text,
	'Distrito'				text,
	'Concelho'				text,
	'Freguesia'				text,
	'Rua'					text,
	'Número da Porta'		text,
	'Código Postal'			text,
	primary key('Chave da Localização')
);

create table farmacia (
	'Chave da Farmácia'		text not null,
	'Localização'			text,
	'Nome da Farmácia'		text,
	'Número de Telefone'	text,
	'Hora de Abertura'		text,
	'Hora de Fecho'			text,
	'E-mail'				text,
	'Website'				text,
	primary key('Chave da Farmácia'),
	foreign key('Localização') references localizacao('Chave da Localização'),
	foreign key('Hora de Abertura') references hora('Chave da Hora'),
	foreign key('Hora de Fecho') references hora_rp('Chave da Hora')
);

create table laboratorio (
	'Chave do Laboratório'	text,
	'Localização'			text,
	'Nome do Laboratório'	text,
	'Telefone'				text,
	'Fax'					text,
	'E-mail'				text,
	primary key('Chave do Laboratório'),
	foreign key('Localização') references localizacao('Chave da Localização');
);

create table medico (
	'Chave do Médico'	text,
	'Identidade'		text,
	'Número da Cédula'	text,
	'Especialidade'		text,
	'Morada'			text,
	primary key('Chave do Médico'),
	foreign key('Identidade') references identidade('Chave da Identidade'),
	foreign key('Morada') references localizacao('Chave da Localização')
);

create table paciente (
	'Chave do Paciente' 	text,
	'Identidade'			text,
	'Número de Telefone'	text,
	'Número de Telemovel'	text,
	'Morada'				text,
	'E-mail'				text,
	'Data de Nascimento'	text,
	'Subsistema'			text,
	primary key('Chave do Paciente'),
	foreign key('Identidade') references identidade('Chave da Identidade'),
	foreign key('Morada') references localizacao('Chave da Localização'),
	foreign key('Data de Nascimento') data('Chave da Data')
);

create table medicamento(
	'Chave do Medicamento'	text,
	'Composição'			text,
	'Nome do Medicamento'	text,
	'Dosagem'				text,
	'Unidades'				text,
	'Forma Farmaceutica'	text,
	'Genérico'				text,
	'Laboratório'			text,
	'Data de Autorização'	text,
	'Estado da Autorização'	text,
	'Tamanho da Embalagem'	text,
	'Número de Registo'		text,
	'CNPEM'					text,
	'CHNM'					text,
	'Comercializado'		text,
	'Grupo'					text,
	'Indicações'			text,
	'Contra-Indicações'		text,
	'Interações'			text,
	'Efeitos Secundários'	text,
	'Via de Administração'	text,
	'Inicio de Efeito'		text,
	'Eliminação'			text,
	'Descrição'				text,
	'Prazo de Validdade'	text,
	'Comparticipação SNS'	text,
	'Comparticipação ADSE'	text,
	'Comparticipação ADME'	text,
	'Comparticipação SS'	text,
	'Preço'					text,
	primary key('Chave do Medicamento'),
	foreign key('Laboratório') references laboratorio('Chave do Laboratório'),
	foreign key('Data de Autorização') references data('Chave da Data'),
	foreign key('Prazo de Validdade') references data_rp('Chave da Data')
);