# RETROSPECTIVA — ATIVIDADE 16: JPA E HIBERNATE

## Quais atributos da entidade Usuario não devem aparecer na tela de listagem?

Os atributos `senha` e `paciente` não devem aparecer na listagem de usuários.

A senha é uma informação confidencial e deve permanecer protegida. O atributo paciente representa um relacionamento que não é necessário para a listagem básica.

Por isso, a tabela de usuários apresenta apenas os campos ID, Nome e E-mail.