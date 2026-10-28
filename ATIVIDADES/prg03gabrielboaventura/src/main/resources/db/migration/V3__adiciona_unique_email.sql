-- V3: impede o cadastro de e-mails duplicados
ALTER TABLE usuarios
ADD CONSTRAINT uk_usuarios_email UNIQUE (email);