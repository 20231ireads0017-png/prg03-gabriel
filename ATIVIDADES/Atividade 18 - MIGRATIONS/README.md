# Atividade 18 — Versionando o Banco com Flyway

## Objetivo
Implementar o versionamento do banco de dados MySQL utilizando Flyway, garantindo que a estrutura seja criada e atualizada por migrations SQL.

## Configuração
Foram adicionadas ao `pom.xml` as dependências `flyway-core` e `flyway-mysql`.

A classe `FlywayUtil` executa as migrations no início da aplicação, utilizando a variável de ambiente `DB_PASSWORD` para obter a senha do banco.

## Migrations implementadas
Os arquivos estão em `src/main/resources/db/migration`:

- **V1 — cria_tabela_usuarios:** cria a tabela `usuarios` com as colunas `id`, `nome`, `email` e `senha`.
- **V2 — adiciona_coluna_telefone:** acrescenta a coluna opcional `telefone`.
- **V3 — adiciona_unique_email:** adiciona uma restrição `UNIQUE` ao campo `email`.

## Hibernate
A propriedade `hibernate.hbm2ddl.auto` foi alterada de `update` para `validate`.

Assim, o Hibernate verifica a compatibilidade entre a entidade `Usuario` e a estrutura do banco, sem criar ou modificar tabelas automaticamente.

## Teste com banco vazio
O banco `sistema_sus` foi recriado vazio para verificar a execução das migrations desde o início.

O Flyway aplicou as versões V1, V2 e V3 em sequência, registrando todas na tabela `flyway_schema_history`, com `success = 1`.

A aplicação executou normalmente após as migrations, sem divergências entre a entidade e o banco.

## Testes automatizados
Após a migração, a bateria de testes das atividades anteriores foi executada novamente.

**Resultado:** 33 testes executados, 0 falhas, 0 erros — `BUILD SUCCESS`.