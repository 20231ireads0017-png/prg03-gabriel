-- Criação da tabela de pacientes
CREATE TABLE pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cartao_sus VARCHAR(255) UNIQUE
);

-- Criação da tabela de consultas
CREATE TABLE consultas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    especialidade VARCHAR(255),
    data VARCHAR(255),
    status VARCHAR(255),
    paciente_id BIGINT,

    CONSTRAINT fk_consultas_pacientes
        FOREIGN KEY (paciente_id)
        REFERENCES pacientes(id)
);

-- Criação da tabela de exames
CREATE TABLE exames (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    especialidade VARCHAR(255),
    data VARCHAR(255)
);