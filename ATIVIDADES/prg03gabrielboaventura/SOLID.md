# Atividade 21 — Auditoria SOLID e Clean Code

**Projeto:** Agenda SUS  
**Disciplina:** Programação III  
**Branch:** `feature/atividade-21-solid`

## 1. Objetivo

Analisar o código do Agenda SUS, identificar problemas relacionados aos princípios SOLID e aplicar melhorias 
de Clean Code sem comprometer o funcionamento do sistema.

## 2. Análise dos princípios SOLID

**SRP — Responsabilidade Única**

Em `Prg03gabrielboaventura.java`, o método `main()` concentrava a preparação do banco e a demonstração 
de atendimentos. Foram criados os métodos `prepararBancoDeDados()` e `demonstrarProcessamentoAtendimentos()`, 
melhorando a organização. A separação completa das responsabilidades da classe permanece como melhoria futura.

**OCP — Aberto/Fechado**

Em `ValidadorUsuario.java`, as palavras proibidas estavam definidas diretamente no método de validação. 
A lista foi extraída para `PALAVRAS_PROIBIDAS_PADRAO` e foi criada uma sobrecarga de `contemPalavraProibida()` 
que aceita outras listas, permitindo ampliar a validação sem modificar o algoritmo.

**LSP — Substituição de Liskov**

As classes `UsuarioDao` e `FakeUsuarioDao` implementam `UsuarioIDao`, permitindo utilizar 
diferentes implementações no serviço. Essa estrutura favorece a substituição, 
desde que ambas respeitem o contrato esperado.

**ISP — Segregação de Interfaces**

A interface `UsuarioIController` possui oito métodos, mas `TelaLogin` utiliza diretamente apenas 
`autenticar()` e `TelaCadastroUsuario` utiliza `save()`. Uma melhoria futura seria separar os contratos 
de autenticação e cadastro.

**DIP — Inversão de Dependência**

`UsuarioService` depende da interface `UsuarioIDao`, e `UsuarioController` depende de `UsuarioIService`. 
Isso reduz o acoplamento e facilita os testes com implementações em memória.

## 3. Problemas identificados

| Princípio | Problema | Situação |
|---|---|---|
| SRP | Diferentes etapas concentradas no `main()` | Organização melhorada |
| OCP | Lista fixa de palavras proibidas | Corrigido |
| ISP | Interface com operações além das utilizadas pelas telas | Melhoria futura |

## 4. Melhorias de Clean Code

**Código duplicado:** em `TelaCRUDUsuario.java`, foi criado o método `preencherTabelaUsuarios()` 
para reutilizar a lógica de preenchimento da tabela nas operações de carregamento e pesquisa.

**Renomeações:** realizadas pelo recurso *Refactor → Rename* do NetBeans:

| Antes | Depois |
|---|---|
| `senhaForte()` | `senhaPossuiTamanhoMinimo()` |
| `camposPreenchidos()` | `todosOsCamposPreenchidos()` |

**Comentários:** foram removidos comentários redundantes que apenas repetiam o funcionamento do código, 
preservando os comentários necessários ao NetBeans.

## 5. Validação

Após as refatorações, o projeto foi compilado e testado no NetBeans.

| Resultado | Quantidade |
|---|---:|
| Testes executados | 57 |
| Falhas | 0 |
| Erros | 0 |
| Ignorados | 0 |

**Compilação:** `BUILD SUCCESS`.

A tela de login e a navegação para o cadastro também foram verificadas.

## 6. Conclusão

A auditoria identificou oportunidades de melhoria nos princípios SRP, OCP e ISP. 
Foram realizadas refatorações para melhorar a extensibilidade, a organização, 
a nomenclatura e a reutilização do código.

Os 57 testes continuaram aprovados, indicando que o comportamento verificado foi preservado. 
A segregação das interfaces e a separação completa das responsabilidades da classe.