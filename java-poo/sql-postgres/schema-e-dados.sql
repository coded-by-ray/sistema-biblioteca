CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id),
    usuario_id INT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL DEFAULT CURRENT_DATE,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE, -- Sem NOT NULL: fica NULL enquanto não for devolvido
    valor_multa NUMERIC(10, 2) DEFAULT 0.00
);

-- ==========================================
-- DADOS DE TESTE
-- ==========================================

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L01', 'Clean Code', 'livro', 'Robert C. Martin', '1ª Edição', FALSE),
('L02', 'Java Efetivo', 'livro', 'Joshua Bloch', '3ª Edição', TRUE),
('R01', 'Superinteressante', 'revista', 'Editora Abril', 'Ed. 450', TRUE),
('R02', 'National Geographic', 'revista', 'Vários Autores', 'Ed. 280', TRUE);


INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Rayssa', 'aluno', 3),
('Prof. Marcos', 'professor', 5);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(1, 1, '2026-11-10', '2026-11-24', NULL, 0.00),
(3, 2, '2026-10-01', '2026-10-08', '2026-10-11', 3.00);