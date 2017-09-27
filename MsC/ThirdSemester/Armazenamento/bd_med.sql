CREATE TABLE venda_farmacia();

CREATE TABLE medicamento(
	dci text primary key,
	nome text,
	forma_farmaceutica text,
	dosagem text,
	tamanho_embalagem text,
	numero_registo varchar(7),
	cnpem varchar(8),
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
	conservacao text
);

CREATE TABLE farmacia(
	nome text,
	telefone text,
	morada text,
	localidade text,
	concelho text,
	distrito text,
	latitude text,
	longitude text,
	hora_abertura text,
	hora_fecho text,
	email text,
	website text
);

CREATE TABLE laboratorio(
	nome text,
	telefone text,
	fax text,
	email text,
	morada text,
	localidade text,
	concelho text,
	distrito text,
	pais text,
	latitude text,
	longitude text
);

CREATE TABLE medico();

CREATE TABLE paciente();

CREATE TABLE data();

CREATE TABLE compra_laboratorio();

CREATE TABLE preescricao();
