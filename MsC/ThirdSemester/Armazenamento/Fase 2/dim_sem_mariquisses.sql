drop owned by john;

create table hora (
	hora_completa	text not null,
	descricao_hora 	text,
	hora 			text,
	minuto			text,
	segundo			text,
	altura_do_dia 	text,
	primary key(hora_completa)
);

create table data (
	data_completa			text not null,
	descricao_data			text,
	num_dia_semana			text,
	num_dia_mes				text,
	num_dia_trimestre		text,
	num_dia_semestre		text,
	num_dia_ano				text,
	num_dia_absoluto		text,
	num_semana				text,
	num_mes 				text,
	num_trimeste 			text,
	num_semestre 			text,
	num_ano					text,
	nome_dia_semana			text,
	nome_mes				text,
	e_dia_semana			text,
	e_feriado				text,
	e_ano_bissexto			text,
	estacao_ano				text,
	data_inicio_semana		text,
	data_final_semana		text,
	data_inicio_mes			text,
	data_final_mes			text,
	data_inicio_trimestre	text,
	data_final_trimestre	text,
	data_inicio_semestre	text,
	data_final_semestre		text,
	primary key(data_completa)
);

create table localizacao (
	coord_geo	text not null,
	latitude	text,
	longitude	text,
	num_porta	text,
	rua			text,
	cod_postal	text,
	freguesia	text,
	concelho	text,
	distrito	text,
	regiao		text,
	pais		text,
	primary key(coord_geo)
);

create table indentidade (
	cartao_cidadao		text not null,
	num_doc				text,
	nif					text,
	num_ss				text,
	nome				text,
	apelido 			text,
	nacionalidade		text,
	data_nasc			text,
	data_val			text,
	sexo				text,
	altura 				text,
	filiacao			text,
	num_telefone		text,
	num_telemovel		text,
	morada				text,
	primary key(cartao_cidadao),
	foreign key(data_nasc) references data(data_completa),
	foreign key(data_val) references data(data_completa),
	foreign key(morada) references localizacao(coord_geo)
);

create table farmacia (
	localizacao		text,
	nome_farm		text,
	num_telefone	text,
	hora_abertura	text,
	hora_fecho		text,
	email			text not null,
	website			text,
	primary key(email),
	foreign key(localizacao) references localizacao(coord_geo),
	foreign key(hora_abertura) references hora(hora_completa),
	foreign key(hora_fecho) references hora(hora_completa)
);

create table laboratorio (
	localizacao		text not null,
	nome_lab		text not null,
	num_telefone	text,
	num_fax			text,
	email			text,
	primary key(localizacao, nome_lab),
	foreign key(localizacao) references localizacao(coord_geo)
);

create table medico (
	cc				text,
	num_cedula		text not null,
	especialidade	text,
	email			text,
	primary key(num_cedula),
	foreign key(cc) references indentidade(cartao_cidadao)
);

create table paciente (
	cc				text not null,
	num_utente_saude	text,
	email			text,
	nome_subsistema	text,
	primary key(cc),
	foreign key(cc) references indentidade(cartao_cidadao)
);

create table medicamento (
	composicao				text,
	nome_med				text,
	dosagem					text,
	unidades				text,
	forma_farm				text,
	generico				text,
	localizacao_lab			text,
	nome_lab				text,
	data_autorizacao		text,
	estado_autorizacao		text,
	tamanho_embalagem		text,
	num_reg					text not null,
	cnpem					text,
	chnm					text,
	comercializado			text,
	grupo					text,
	indicacoes				text,
	contra_indicacoes		text,
	interacoes				text,
	efeitos_secundarios		text,
	via_administracao		text,
	inicio_efeito			text,
	eliminacao				text,
	descricao				text,
	prazo_validade			text,
	comparticipacao_sns		text,
	comparticipacao_adse	text,
	comparticipacao_adme	text,
	comparticipacao_ss		text,
	preco					text,
	primary key(num_reg),
	foreign key(localizacao_lab, nome_lab) references laboratorio(localizacao, nome_lab),
	foreign key(data_autorizacao) references data(data_completa),
	foreign key(prazo_validade) references data(data_completa)
);

create table venda (
	hora_completa	text not null,
	data_completa	text not null,
	email			text not null,
	num_cedula		text not null,
	cc				text not null,
	num_reg			text not null,
	preço_total 	text,
	primary key(hora_completa, data_completa, email, num_cedula, cc, num_reg),
	foreign key(hora_completa) references hora(hora_completa),
	foreign key(data_completa) references data(data_completa),
	foreign key(email) references farmacia(email),
	foreign key(num_cedula) references medico(num_cedula),
	foreign key(cc) references paciente(cc),
	foreign key(num_reg) references medicamento(num_reg)
);