-- Inserir 15 clientes ativos
INSERT INTO tb_clients (id, name, contact_number, address, gender, department, skills, is_active)
VALUES
    (5, 'Cliente Ativo 1', '123456789', 'Rua ABC, 123', 'Masculino', 'Back-end', 'Java, Spring, React', TRUE),
    (6, 'Cliente Ativo 2', '123456789', 'Rua ABC, 123', 'Feminino', 'Front-end', 'Java, Spring, React', TRUE),
    (7, 'Cliente Ativo 3', '123456789', 'Rua ABC, 123', 'Masculino', 'Infraestrutura', 'Java, Spring, React', TRUE),
    (8, 'Cliente Ativo 4', '123456789', 'Rua ABC, 123', 'Feminino', 'IoT', 'Java, Spring, React', TRUE),
    (9, 'Cliente Ativo 5', '123456789', 'Rua ABC, 123', 'Masculino', 'Back-end', 'Java, Spring, React', TRUE),
    (10, 'Cliente Ativo 6', '123456789', 'Rua ABC, 123', 'Feminino', 'Front-end', 'Java, Spring, React', TRUE),
    (11, 'Cliente Ativo 7', '123456789', 'Rua ABC, 123', 'Masculino', 'Infraestrutura', 'Java, Spring, React', TRUE),
    (12, 'Cliente Ativo 8', '123456789', 'Rua ABC, 123', 'Feminino', 'IoT', 'Java, Spring, React', TRUE),
    (13, 'Cliente Ativo 9', '123456789', 'Rua ABC, 123', 'Masculino', 'Back-end', 'Java, Spring, React', TRUE),
    (14, 'Cliente Ativo 10', '123456789', 'Rua ABC, 123', 'Feminino', 'Front-end', 'Java, Spring, React', TRUE),
    (15, 'Cliente Ativo 11', '123456789', 'Rua ABC, 123', 'Masculino', 'Infraestrutura', 'Java, Spring, React', TRUE),
    (16, 'Cliente Ativo 12', '123456789', 'Rua ABC, 123', 'Feminino', 'IoT', 'Java, Spring, React', TRUE),
    (17, 'Cliente Ativo 13', '123456789', 'Rua ABC, 123', 'Masculino', 'Back-end', 'Java, Spring, React', TRUE),
    (18, 'Cliente Ativo 14', '123456789', 'Rua ABC, 123', 'Feminino', 'Front-end', 'Java, Spring, React', TRUE),
    (19, 'Cliente Ativo 15', '123456789', 'Rua ABC, 123', 'Masculino', 'Infraestrutura', 'Java, Spring, React', TRUE);

-- Inserir 5 clientes inativos
INSERT INTO tb_clients (id, name, contact_number, address, gender, department, skills, is_active)
VALUES
    (20, 'Cliente Inativo 1', '123456789', 'Rua ABC, 123', 'Masculino', 'Back-end', 'Java, Spring, React', FALSE),
    (21, 'Cliente Inativo 2', '123456789', 'Rua ABC, 123', 'Feminino', 'Front-end', 'Java, Spring, React', FALSE),
    (22, 'Cliente Inativo 3', '123456789', 'Rua ABC, 123', 'Masculino', 'Infraestrutura', 'Java, Spring, React', FALSE),
    (23, 'Cliente Inativo 4', '123456789', 'Rua ABC, 123', 'Feminino', 'IoT', 'Java, Spring, React', FALSE),
    (24, 'Cliente Inativo 5', '123456789', 'Rua ABC, 123', 'Masculino', 'Back-end', 'Java, Spring, React', FALSE);
