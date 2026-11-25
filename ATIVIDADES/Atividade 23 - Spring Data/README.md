# ATIVIDADE 23 - SPRING DATA

## Objetivo

Migrar a camada de persistência do projeto Agenda SUS para o Spring Data JPA, eliminando implementações manuais de acesso ao banco de dados e preservando a arquitetura em camadas.

## Task 01 — Dependência e configuração

- Inclusão da dependência `spring-boot-starter-data-jpa` no `pom.xml`.
- Utilização do `application.properties` para configuração da persistência.
- Utilização de `spring.jpa.hibernate.ddl-auto=validate`.
- Manutenção do Flyway como responsável pelas migrations.
- Configuração da identificação automática das entidades e dos repositórios pelo Spring.

Foram implementados quatro repositórios que estendem `JpaRepository`:

- UsuarioRepository;
- PacienteRepository;
- ConsultaRepository;
- ExameRepository.

Também foi criada a migration V4, responsável pelas tabelas de pacientes, consultas e exames, incluindo o relacionamento entre pacientes e consultas.

## Task 02 — Remoção das implementações obsoletas

Foram removidos os DAOs concretos, as implementações antigas dos repositórios, o DAO genérico, a interface genérica, a classe JPAUtil, a classe DaoException e o arquivo persistence.xml.

As interfaces DAO específicas foram preservadas para manter o desacoplamento entre a camada de negócio e a implementação da persistência.

### Estatísticas das alterações

Commit: `fa5660d`

Comando: `git --no-pager diff --stat HEAD~1 HEAD`

| Indicador | Resultado |
|---|---:|
| Arquivos alterados | 40 |
| Linhas adicionadas | 764 |
| Linhas removidas | 996 |
| Redução líquida | 232 |

Foram removidas 996 linhas no total, resultando em uma redução líquida de 232 linhas, mesmo com a inclusão dos novos repositórios, migrations e testes de integração.

## Task 03 — Suíte de testes

A suíte completa foi executada com sucesso.

| Indicador | Resultado |
|---|---:|
| Testes executados | 57 |
| Falhas | 0 |
| Erros | 0 |
| Testes ignorados | 0 |


### Adaptação realizada

Embora o enunciado proponha a manutenção integral da suíte original sem alterações, foi necessário adaptar os FakeDaos aos contratos utilizados pelo Spring Data JPA.

Também foram removidos sete testes diretamente vinculados às implementações antigas de persistência, distribuídos em quatro classes de teste obsoletas.

Foram preservados 50 testes unitários e acrescentados sete testes de integração, mantendo o total de 57 testes.

Os novos testes verificam a persistência das entidades, operações de CRUD, relacionamento entre pacientes e consultas, autenticação, existência de e-mail e consultas JPQL.

## Task 04 — Consulta derivada

Foi implementado o seguinte método no UsuarioRepository:

```java
boolean existsByEmail(String email);
```

O método é utilizado pelo UsuarioService para verificar a existência de um e-mail antes de cadastrar um novo usuário, evitando duplicidades sem recuperar desnecessariamente a entidade completa.

```java
if (dao.existsByEmail(usuario.getEmail())) {
    throw new IllegalArgumentException(
            "Já existe um usuário com este e-mail.");
}
```

A regra foi validada por meio de um teste JUnit na classe UsuarioRepositoryTest.

### Adaptação realizada

A consulta derivada foi aplicada à validação de duplicidade no cadastro, em vez de substituir a recuperação do usuário durante a autenticação.

Essa decisão preserva a comparação exata das credenciais realizada em Java, evitando possíveis diferenças de comportamento relacionadas à collation do MySQL.

Também foram utilizadas consultas de existência nos repositórios de pacientes, consultas e exames.

## Task 05 — Consulta com @Query

Foi implementada uma consulta JPQL para pesquisar usuários pelo nome ou e-mail, com ordenação alfabética pelo nome.

```java
@Query("SELECT u FROM Usuario u "
        + "WHERE LOWER(u.nome) LIKE CONCAT('%', LOWER(:texto), '%') "
        + "OR LOWER(u.email) LIKE CONCAT('%', LOWER(:texto), '%') "
        + "ORDER BY u.nome ASC")
List<Usuario> pesquisar(@Param("texto") String texto);
```

A consulta foi validada por um teste de integração na classe UsuarioRepositoryTest, verificando as duas condições de pesquisa e a ordenação dos resultados.

## Arquitetura

A arquitetura em camadas foi preservada:

```
View
  |
Controller
  |
Service
  |
Interface DAO
  |
Repository (Spring Data JPA)
  |
MySQL
```

Os Services continuam dependendo das interfaces DAO, permitindo a utilização dos FakeDaos nos testes unitários sem dependência direta do Spring Data.


## Conclusão

A migração para o Spring Data JPA permitiu reduzir a quantidade de código manual de persistência, preservar a separação de responsabilidades e manter a suíte de testes aprovada.

O projeto utiliza repositórios gerenciados pelo Spring, consultas derivadas, consultas JPQL e migrations controladas pelo Flyway.