Projeto: Marcação de Consultas para o SUS
Data de Criação: 22/08/2026
Autor: Gabriel Boaventura
Revisão: 01

---

Conteúdo

1. Introdução
   1.1 Objetivo
   1.2 Escopo do produto
   1.3 Definições, Acrônimos e Abreviações

2. Descrição geral
   2.1 Modo de Operação
   2.2 Funções do produto
   2.3 Usuários e sistemas externos
   2.4 Restrições
   2.5 Requisitos Adiados

3. Requisitos específicos
   3.1 Requisitos Funcionais
   3.2 Requisitos Não-Funcionais
   3.2.1 Desempenho
   3.2.2 Usabilidade
   3.2.3 Segurança
   3.2.4 Expansibilidade
   3.3 Requisitos de Interface

4. Regras de Negócio

5. Glossário

6. Referências

7. Aprovação

---

1. Introdução

O sistema de "Marcação de Consultas para o SUS" tem como finalidade facilitar o processo de agendamento de consultas em unidades de saúde.

O sistema permitirá que o cidadão consulte as especialidades disponíveis e realize o agendamento de uma consulta de acordo com os horários disponíveis. Os profissionais ou responsáveis pela unidade de saúde poderão visualizar os agendamentos realizados e organizar a disponibilidade das consultas.

O objetivo é tornar o processo de marcação mais organizado e reduzir a necessidade de realizar todo o procedimento presencialmente.

1.1 Objetivo

Este documento tem como objetivo apresentar os requisitos funcionais e não funcionais do sistema de Marcação de Consultas para o SUS.
Ele servirá como base para o desenvolvimento do software nas próximas etapas do projeto, descrevendo as principais funcionalidades, usuários e regras que deverão ser consideradas durante a implementação.

1.2 Escopo do produto

O sistema permitirá que o cidadão:

*Realize seu cadastro no sistema;
*Consulte as especialidades disponíveis;
*Selecione uma unidade de saúde;
*Escolha uma data e horário disponível;
*Agende uma consulta;
*Consulte seus agendamentos;
*Cancele uma consulta, quando permitido.

O responsável pela unidade de saúde poderá cadastrar os horários disponíveis e visualizar os agendamentos realizados.
Inicialmente, o sistema terá apenas as funcionalidades essenciais para o processo de marcação de consultas.

1.3 Definições, Acrônimos e Abreviações

Nº - Sigla - Definição
01 - SUS - Sistema Único de Saúde    
02 - RF - Requisito Funcional       
03 - RNF - Requisito Não Funcional   
04 - CPF - Cadastro de Pessoa Física 
05 - UBS - Unidade Básica de Saúde   

---

2. Descrição Geral

2.1 Modo de Operação

O sistema funcionará como uma plataforma para organização e marcação de consultas.

O cidadão realizará seu acesso ao sistema e poderá consultar as unidades de saúde e especialidades disponíveis. Após escolher a especialidade desejada, o sistema apresentará as datas e horários disponíveis para agendamento.

Depois da confirmação, a consulta ficará registrada no sistema.

O responsável pela unidade de saúde poderá organizar os horários disponíveis e acompanhar os agendamentos realizados.

Os principais atores do sistema são:

*Cidadão;
*Profissional ou responsável pela unidade de saúde;
*Administrador.

2.2 Funções do Produto

Nº - Função - Descrição                                                       
01 - Cadastrar cidadão - Permitir o cadastro do cidadão no sistema.                      
02 - Realizar login - Permitir que os usuários acessem o sistema.                     
03 - Consultar especialidades - Permitir que o cidadão visualize as especialidades disponíveis. 
04 - Consultar horários - Exibir as datas e horários disponíveis para consulta.           
05 - Agendar consulta - Permitir que o cidadão realize o agendamento de uma consulta.   
06 - Consultar agendamentos - Permitir que o cidadão visualize suas consultas agendadas.      
07 - Cancelar consulta - Permitir o cancelamento de uma consulta agendada.               
08 - Gerenciar horários - Permitir que o responsável organize os horários disponíveis.    

2.3 Usuários e Sistemas Externos

Nº - Usuário - Descrição                                                             
01 - Cidadão - Usuário que realiza o agendamento de consultas.                       
02 - Responsável pela unidade - Usuário responsável por visualizar agendamentos e organizar horários. 
03 - Administrador - Usuário responsável pela administração geral do sistema.              

2.4 Restrições

Nº - Tipo - Descrição                                                                
01 - Software - O sistema deverá funcionar em ambiente web ou aplicativo.                
02 - Internet - O usuário deverá possuir acesso à internet para utilizar o sistema.      
03 - Segurança - Os dados dos usuários devem ser protegidos contra acesso não autorizado. 
04 - Processo - Uma consulta só poderá ser agendada em um horário disponível.            
05 - Acesso - Cada usuário deverá acessar o sistema utilizando seu próprio login.      

2.5 Requisitos Adiados

As funcionalidades abaixo não fazem parte da primeira versão do sistema, mas poderão ser implementadas futuramente.

Nº - Referência - Detalhes                                                                        
01 - Notificações - O sistema poderá enviar lembretes sobre consultas agendadas.                    
02 - Histórico médico - O cidadão poderá visualizar informações sobre consultas anteriores.             
03 - Avaliação - O cidadão poderá avaliar o atendimento recebido.                                
04 - Integração externa - O sistema poderá futuramente integrar informações com outros sistemas de saúde. 

---

3. Requisitos Específicos

3.1 Requisitos Funcionais

Código - Nome - Descrição                                                                                                           
RF01 - Cadastro de Cidadão - O sistema deve permitir que o cidadão realize seu cadastro informando seus dados básicos.
RF02 - Autenticação - O sistema deve permitir que os usuários realizem login de acordo com seu perfil.
RF03 - Consulta de Especialidades - O cidadão deve poder visualizar as especialidades disponíveis para atendimento.
RF04 - Seleção de Unidade - O cidadão deve poder selecionar a unidade de saúde onde deseja realizar a consulta.                                 
RF05 - Visualização de Horários  - O sistema deve apresentar os dias e horários disponíveis para agendamento.                                          
RF06 - Agendamento de Consulta - O cidadão deve poder selecionar uma data e horário disponível e confirmar o agendamento. 
RF07 - Consulta de Agendamentos - O cidadão deve poder visualizar suas consultas agendadas.                    RF08 - Cancelamento de Consulta - O cidadão deve poder cancelar uma consulta agendada, desde que esteja dentro das regras estabelecidas pelo sistema. 
RF09 - Gerenciamento de Horários - O responsável pela unidade deve poder cadastrar e organizar os horários disponíveis para consultas.
RF10 - Visualização de Agendamentos - O responsável deve poder visualizar as consultas agendadas na unidade de saúde.

---

3.2 Requisitos Não-Funcionais

3.2.1 Desempenho

Código - Requisito - Aplicação - Descrição                                                                                             
RNF01 - Tempo de resposta - O sistema deve apresentar as informações de horários e agendamentos em tempo adequado para o usuário.
RNF02 - Agendamento - O sistema deve registrar o agendamento de forma rápida após a confirmação do usuário.

3.2.2 Usabilidade

Código - Requisito - Aplicação   - Descrição                                                                                    
RNF03 - Interface intuitiva - O sistema deve possuir uma interface simples e de fácil utilização.                       
RNF04 - Clareza das informações - As informações sobre especialidades, datas e horários devem ser apresentadas de forma clara. 

3.2.3 Segurança

Código - Requisito - Aplicação - Descrição                                                                                          
RNF05 - Autenticação - O sistema deve exigir autenticação para acesso às informações dos usuários.             
RNF06 - Proteção de dados - Os dados pessoais e informações de agendamento devem ser acessíveis apenas a usuários autorizados. 

3.2.4 Expansibilidade

Código - Requisito - Aplicação - Descrição                                                                                              
RNF07 - Estrutura do sistema - O sistema deve ser desenvolvido de forma que novas funcionalidades possam ser adicionadas futuramente.

---

3.3 Requisitos de Interface

3.3.1 Interfaces de Usuário

Nº - Nome - Descrição                                                                  
01 - Tela de Login - Interface para acesso dos usuários ao sistema.                             
02 - Tela de Cadastro - Interface para cadastro do cidadão.                                        
03 - Tela de Especialidades - Interface para visualização e seleção das especialidades disponíveis.      
04 - Tela de Agendamento - Interface para seleção da unidade, data e horário da consulta.             
05 - Tela de Consultas - Interface para visualização das consultas agendadas pelo cidadão.          
06 - Painel da Unidade - Interface para gerenciamento dos horários e visualização dos agendamentos. 

3.3.2 Interfaces de Hardware

O sistema deverá funcionar em computadores e dispositivos móveis com acesso à internet.

3.3.3 Interfaces de Software

Não aplicável no escopo inicial do projeto.

3.3.4 Interfaces de Comunicação

O sistema utilizará conexão com a internet para permitir o acesso dos usuários e o registro das informações.

---

4. Regras de Negócio

RN01 – Disponibilidade de horários
Uma consulta só poderá ser agendada em um horário que esteja disponível no sistema.

RN02 – Exclusividade do horário
Após a confirmação de um agendamento, aquele horário não poderá ser selecionado por outro cidadão.

RN03 – Identificação do usuário
O cidadão deverá estar cadastrado e autenticado no sistema para realizar o agendamento de uma consulta.

RN04 – Cancelamento
O cancelamento de uma consulta somente poderá ser realizado antes da data e horário do atendimento.

RN05 – Organização dos horários
Os horários disponíveis para agendamento deverão ser cadastrados pelo responsável pela unidade de saúde.

---

5. Glossário

Termo - Definição                                                                  
SUS - Sistema Único de Saúde, sistema público de saúde brasileiro.               
Consulta - Atendimento realizado entre o cidadão e um profissional de saúde.          
Agendamento - Processo de reserva de uma data e horário para realização de uma consulta. 
Unidade de Saúde - Local onde o atendimento ao cidadão será realizado.                        
Especialidade - Área de atendimento médico ou profissional disponível para consulta.       
Horário disponível - Horário que ainda pode ser selecionado para um novo agendamento.           

---

6. Referências

Material da Aula 02 – Especificação de Requisitos.

---

7. Aprovação

Este documento foi revisado e aprovado por:

Nome: ______________________________________

Cargo: ______________________________________

Data:  ____/____/_______
