-- DADOS PRA TESTE

INSERT INTO USUARIO (EMAIL, NAME, PASSWORD) VALUES
('usuario1@example.com', 'Usuário Um', 'hashed_password1'),
('usuario2@example.com', 'Usuário Dois', 'hashed_password2'),
('usuario3@example.com', 'Usuário Três', 'hashed_password3'),
('usuario4@example.com', 'Usuário Quatro', 'hashed_password4');

INSERT INTO RECURSO_EDUCACIONAL_ABERTO (ID, CATEGORIA, DESCRICAO, LICENCA, TITULO, URL, AUTOR) VALUES
(1, 'BACKEND', 'Curso sobre Java', 'Creative Commons', 'Java para Iniciantes', 'http://exemplo.com/java', 'pedro'),
(2, 'BACKEND', 'Curso sobre Python', 'MIT', 'Aprenda Python', 'http://exemplo.com/python', 2),
(3, 'BACKEND', 'Curso sobre Node.js', 'Apache', 'Introdução ao Node.js', 'http://exemplo.com/nodejs', 'pedro');

INSERT INTO CURSO (ID, CATEGORIA, DESCRICAO, IMAGEM_URL, TITULO) VALUES
(1, 'BACKEND', 'Curso completo de Java com projetos práticos', 'http://exemplo.com/imagem_java.jpg', 'Curso de Java Completo'),
(2, 'BACKEND', 'Aprenda Python de forma prática com projetos', 'http://exemplo.com/imagem_python.jpg', 'Curso de Python Prático'),
(3, 'BACKEND', 'Aprenda Node.js com exemplos práticos', 'http://exemplo.com/imagem_nodejs.jpg', 'Curso de Node.js Prático');

INSERT INTO AVALIACAO (COMENTARIO, NOTA, USUARIO_ID, REA_ID) VALUES
('Excelente material!', 9.5, 1, 1),
('Muito bom, mas poderia ter mais exercícios.', 8.0, 2, 1),
('Gostei bastante do curso.', 10.0, 3, 1);

INSERT INTO COMENTARIO (PERGUNTA, USUARIO_ID, REA_ID) VALUES
('Alguém pode ajudar com essa dúvida?', 1, 1),
('A aula 3 não está abrindo pra mim.', 2, 1),
('Ótimo curso! Como faço para acessar o material adicional?', 3, 1);


INSERT INTO USUARIO_INSCRICOES (USUARIO_ID, CURSO_ID) VALUES
(1, 1),
(1, 2),
(1, 3),

INSERT INTO CURSO_RECURSOS (CURSO_ID, REA_ID) VALUES
(1, 1),
(1, 2),
(1, 3);

INSERT INTO USUARIO_CONCLUIDOS (USUARIO_ID, REA_ID) VALUES
(1, 1),
(1, 2),
(1, 3);


INSERT INTO USUARIO_FAVORITOS (USUARIO_ID, REA_ID) VALUES
(1, 2),
(1, 3),
(1, 1);
