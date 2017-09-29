drop owned by john;

CREATE TABLE laboratorio(
	nome_laboratorio text,
	telefone text,
	fax text,
	email text,
	morada text,
	localidade text,
	concelho text,
	distrito text,
	pais text,
	latitude_laboratorio text,
	longitude_laboratorio text,
	primary key(nome_laboratorio)
);

CREATE TABLE medicamento(
	composicao text,
	nome_medicamento text,
	dosagem text,
	unidades text,
	forma_farmaceutica text,
	generico boolean,
	nome_laboratorio text,
	data_autorizacao date,
	estado_autorizacao boolean,
	tamanho_embalagem text,
	numero_registo varchar(7),
	cnpem varchar(8),
	chnm varchar(8),
	comercializado boolean,
	grupo text,
	indicacoes text,
	contra_indicacoes text,
	interacao text,
	efeitos_secundarios text,
	via_administracao text,
	inicio_efeito text,
	eliminacao text,
	descricao text,
	outras_informacoes text,
	conservacao text,
	prazo_validade date,
	comparticipacao_sns double precision,
	comparticipacao_adse double precision,
	comparticipacao_adme double precision,
	comparticipacao_ss double precision,
	preco double precision,
	primary key(numero_registo),
	foreign key(nome_laboratorio) references laboratorio(nome_laboratorio)
		on delete cascade
		on update cascade
);


CREATE TABLE farmacia(
	nome_farmacia text,
	telefone text,
	morada text,
	localidade text,
	concelho text,
	distrito text,
	latitude_farmacia text,
	longitude_farmacia text,
	hora_abertura text,
	hora_fecho text,
	email text,
	website text,
	primary key(latitude_farmacia, longitude_farmacia)
);

CREATE TABLE medico(
	nome_medico text,
	numero_cedula text,
	especialidade text,
	cartao_cidadao text,
	telefone text,
	telemovel text,
	morada text,
	localidade text,
	concelho text,
	distrito text,
	email text,
	data_nascimento date,
	numero_idenficacao_fiscal text,
	primary key(numero_cedula)
);

CREATE TABLE paciente(
	cartao_cidadao text,
	nome_paciente text,
	telefone text,
	telemovel text,
	morada text,
	localidade text,
	concelho text,
	distrito text,
	email text,
	data_nascimento date,
	numero_idenficacao_fiscal text,
	numero_seguranca_social text,
	numero_utente_saude text,
	nome_subsistema text,
	numero_subsistema text,
	primary key(numero_utente_saude)
);

CREATE TABLE receita(
	numero_cedula text,
	numero_utente_saude text,
	numero_registo varchar(7),
	data_receita date,
	primary key(numero_cedula, numero_utente_saude, numero_registo, data_receita),
	foreign key(numero_cedula) references medico(numero_cedula)
		on delete cascade
		on update cascade,
	foreign key(numero_utente_saude) references paciente(numero_utente_saude)
		on delete cascade
		on update cascade,
	foreign key(numero_registo) references medicamento(numero_registo)
		on delete cascade
		on update cascade
);

CREATE TABLE venda(
	numero_utente_saude text,
	numero_registo text,
	latitude_farmacia text,
	longitude_farmacia text,
	data_venda date,
	primary key(numero_utente_saude, numero_registo, latitude_farmacia, longitude_farmacia, data_venda),
	foreign key(numero_utente_saude) references paciente(numero_utente_saude)
		on delete cascade
		on update cascade,
	foreign key(numero_registo) references medicamento(numero_registo)
		on delete cascade
		on update cascade,
	foreign key(latitude_farmacia, longitude_farmacia) references farmacia(latitude_farmacia, longitude_farmacia)
		on delete cascade
		on update cascade
);