- ALUNOS: João Miguel Salvalagio, Pedro Ivo, Gabriel Trabuco e João Lucas Sabadini
- PROJETO AEP: Vamos Reciclar Maringá
- SCRIPT COMPLETO DO BANCO DE DADOS (DDL + DML)
- BANCO DE DADOS RELACIONAL: PostgreSQL

```sql
-- -----------------------------------------------------------------
-- DDL (Data Definition Language) - Criação das Tabelas
-- -----------------------------------------------------------------

-- A ordem de criação é importante para as Chaves Estrangeiras (Foreign Keys).
-- Tabelas sem dependências são criadas primeiro.

-- Tabela 1: usuario
-- Armazena os dados dos usuários que se cadastram na plataforma.
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE, -- 'UNIQUE' cria a constraint 'usuario_email_key'
    senha TEXT NOT NULL,                 -- 'TEXT' para armazenar a senha criptografada (hash)
    bairro VARCHAR(100)
);

-- Tabela 2: cooperativa
-- Armazena as cooperativas parceiras que podem receber agendamentos.
CREATE TABLE cooperativa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    telefone VARCHAR(20),
    tipos_coletados TEXT -- Ex: "Móveis, Eletrodomésticos grandes"
);

-- Tabela 3: pontodeentrega
-- Armazena os Pontos de Entrega Voluntária (PEVs) para o mapa.
CREATE TABLE pontodeentrega (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    endereco VARCHAR(255),
    latitude DECIMAL(10, 8),   -- Precisão para coordenadas de GPS
    longitude DECIMAL(11, 8),  -- Precisão para coordenadas de GPS
    horario_func VARCHAR(100), -- Ex: "Seg-Sex, 08h-18h"
    tipos_aceitos TEXT       -- Ex: "Pilhas, Baterias, Óleo"
);

-- Tabela 4: calendario_coleta
-- Armazena os dias e horários da coleta seletiva por bairro.
CREATE TABLE calendario_coleta (
    id SERIAL PRIMARY KEY,
    bairro VARCHAR(150) NOT NULL,
    tipo_coleta VARCHAR(100) NOT NULL, -- Ex: 'Reciclável', 'Lixo Comum'
    dias_semana VARCHAR(255) NOT NULL, -- Ex: 'Segunda, Quarta, Sexta'
    horario VARCHAR(100)               -- Ex: 'A partir das 08h'
);

-- Tabela 5: agendamentocoleta
-- Tabela principal que armazena os agendamentos feitos pelos usuários.
-- Criada por último pois depende de 'usuario' e 'cooperativa'.
CREATE TABLE agendamentocoleta (
    id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL,
    cooperativa_id INT, -- Pode ser nulo se o admin atribuir depois
    descricao_item TEXT NOT NULL,
    data_solicitacao TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    data_agendamento DATE,
    status VARCHAR(50) DEFAULT 'PENDENTE',

    -- Definição das Chaves Estrangeiras (Constraints)
    CONSTRAINT agendamentocoleta_usuario_id_fkey 
        FOREIGN KEY (usuario_id) 
        REFERENCES usuario(id),
    
    CONSTRAINT agendamentocoleta_cooperativa_id_fkey 
        FOREIGN KEY (cooperativa_id) 
        REFERENCES cooperativa(id)
);

-- -----------------------------------------------------------------
-- DML (Data Manipulation Language) - Inserção de Dados de Amostra
-- -----------------------------------------------------------------

-- 1. Inserir Usuários de Teste
-- Nota: As senhas estão criptografadas (BCrypt)
-- 'senha123' -> $2a$10$D0K.L8aG5f.kf.bA.pG.aO/.H.Q/8.D.gH.gJ.zP.eT.d7.h8
-- 'senha456' -> $2a$10$f.gB.9T6.gV.z8.J3.eT.d7.h8.gH.gG.z8.J3.eT.d/T.gB
INSERT INTO usuario (nome, email, senha, bairro)
VALUES
('Joao Miguel', 'joao@email.com', '$2a$10$D0K.L8aG5f.kf.bA.pG.aO/.H.Q/8.D.gH.gJ.zP.eT.d7.h8', 'Zona 07'),
('Pedro Ivo', 'pedro@email.com', '$2a$10$f.gB.9T6.gV.z8.J3.eT.d7.h8.gH.gG.z8.J3.eT.d/T.gB', 'Jardim Alvorada');

-- 2. Inserir Cooperativas
INSERT INTO cooperativa (nome, telefone, tipos_coletados)
VALUES 
('CooperMaringá Recicla', '(44) 3030-4040', 'Móveis, Eletrodomésticos grandes'),
('Recicla-Já SJP', '(44) 3030-5050', 'Móveis, Entulhos');

-- 3. Inserir Pontos de Entrega (PEVs)
INSERT INTO pontodeentrega (nome, endereco, tipos_aceitos, latitude, longitude)
VALUES
('Supermercado Cidade Canção', 'Av. Mandacaru, 1180', 'Pilhas, Baterias, Óleo de Cozinha', -23.408480, -51.933860),
('Parque do Ingá (Portaria)', 'Av. São Paulo, s/n', 'Pilhas, Baterias', -23.429780, -51.939880),
('Posto de Coleta Prefeitura', 'Av. XV de Novembro, 701', 'Lixo Eletrônico, Lâmpadas', -23.424360, -51.936730);

-- 4. Inserir Calendários de Coleta
INSERT INTO calendario_coleta (bairro, tipo_coleta, dias_semana, horario)
VALUES
('Zona 07', 'Reciclável', 'Segunda, Quarta, Sexta', 'A partir das 19h'),
('Zona 07', 'Lixo Comum', 'Terça, Quinta, Sábado', 'A partir das 19h'),
('Jardim Alvorada', 'Reciclável', 'Terça, Quinta, Sábado', 'A partir das 08h'),
('Jardim Alvorada', 'Lixo Comum', 'Segunda, Quarta, Sexta', 'A partir das 08h'),
('Centro', 'Reciclável', 'Segunda a Sábado', 'A partir das 20h'),
('Centro', 'Lixo Comum', 'Diariamente', 'A partir das 20h');

-- 5. Inserir Agendamentos de Teste (Depende dos IDs de usuário e cooperativa)
INSERT INTO agendamentocoleta (usuario_id, cooperativa_id, descricao_item, data_agendamento, status)
VALUES
(1, 1, 'Sofá antigo de 2 lugares', '2025-11-10', 'PENDENTE'),
(2, 2, 'Geladeira quebrada', '2025-11-12', 'PENDENTE');
```
