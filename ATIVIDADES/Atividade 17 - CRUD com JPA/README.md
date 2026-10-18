# Atividade 17 — CRUD Completo com Tratamento de Erros

## Objetivo

Implementar um CRUD completo de usuários utilizando Java, JPA e Hibernate, com persistência no MySQL, tratamento de exceções e testes automatizados.

## Funcionalidades implementadas

- **Cadastrar:** inclusão de usuários no banco de dados com `persist()`.
- **Listar:** consulta dos usuários cadastrados utilizando JPQL.
- **Pesquisar:** busca de usuários por nome ou e-mail utilizando `WHERE` e `LIKE`.
- **Editar:** atualização de usuários utilizando `merge()`.
- **Excluir:** remoção de usuários utilizando `remove()`.

## Persistência e transações

A classe `JPAUtil` centraliza a criação do `EntityManagerFactory` e disponibiliza instâncias de `EntityManager`.

As operações de escrita utilizam `begin()`, `commit()` e `rollback()` em caso de erro. O fechamento do `EntityManager` é realizado com `finally`.

A senha do banco de dados é obtida pela variável de ambiente `DB_PASSWORD`, sem ser incluída no repositório.

## Tratamento de exceções

Foi criada a exceção personalizada `UsuarioNaoEncontradoException`, que herda de `RuntimeException`.

O método `buscarPorId()` foi alterado para lançar essa exceção em vez de retornar `null` quando o usuário não existe.

Essa alteração evita que o código que chama o método ignore um retorno nulo e continue a execução como se a busca tivesse sido bem-sucedida, podendo provocar erros posteriores.

Os métodos `excluir()` e `atualizar()` também verificam a existência do usuário.

Na interface gráfica, as exceções são tratadas com `try/catch`, e as mensagens são apresentadas utilizando `JOptionPane`.

## Interface gráfica

A classe `TelaCRUDUsuario` permite cadastrar, listar, pesquisar, editar e excluir usuários diretamente no MySQL.

## Testes

Foram executados testes automatizados com JUnit 5, incluindo `assertThrows()` para verificar a exceção personalizada e `assertDoesNotThrow()` para verificar uma operação bem-sucedida.

**Resultado:** 33 testes executados, 0 falhas e 0 erros — `BUILD SUCCESS`.