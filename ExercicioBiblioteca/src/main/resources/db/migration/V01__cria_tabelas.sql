CREATE TABLE categoria (
	id serial PRIMARY KEY,
	nome varchar(30) NOT NULL,
	descricao varchar(200)
);

CREATE TABLE livros (
	id_livro serial PRIMARY KEY,
	titulo varchar(40) NOT NULL,
	categoria_id int NOT NULL,
	isbn varchar(20) NOT NULL UNIQUE,
	data_publicacao date,
	FOREIGN KEY (categoria_id) references categoria(id)
);

CREATE TABLE associado (
	id_associado serial PRIMARY KEY,
	nome varchar(50) NOT NULL,
	telefone varchar(15) NOT NULL,
	cpf varchar(11) NOT NULL,
	logradouro varchar(80) NOT NULL,
	numero varchar(10) NOT NULL,
	complemento varchar(30) NOT NULL,
	bairro varchar(50) NOT NULL,
	cidade varchar(50) NOT NULL,
	estado varchar(2) NOT NULL
);

CREATE TABLE autor (
	id_autor serial PRIMARY KEY,
	nome varchar(50) NOT NULL
);

CREATE TABLE livro_autor (
    id_livro int REFERENCES livros(id_livro),
    id_autor int REFERENCES autor(id_autor),
    CONSTRAINT pk_livro_autor PRIMARY KEY (id_livro, id_autor)
);

CREATE TABLE emprestimo (
	id_emprestimo serial PRIMARY KEY,
	associado_id int NOT NULL,
	data_emprestimo date NOT NULL,
	FOREIGN KEY (associado_id) REFERENCES associado(id_associado)
);

CREATE TABLE emprestimo_livro (
	id serial PRIMARY KEY,
	id_emprestimo int REFERENCES emprestimo(id_emprestimo),
	id_livro int REFERENCES livros(id_livro),
	observacoes_ato_emprestimo varchar(200)
);