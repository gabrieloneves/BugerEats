#Author: gabrieldeoliveiraneves@gmail.com

@cadastro @regressivos
Feature: Cadastro para fazer entregas
  Como uma pessoa interessada em fazer entregas
  Eu quero me cadastrar no sistema
  Para que eu possa começar a entregar pedidos
  
  Background:
  	Given que estou na página do Buger Eats
  	When clicar em “Cadastre-se para fazer entregas”
  	And o usuário é direcionado para página de cadastro
  	
	
 @moto @positivo
  Scenario: Cadastro completo com moto
    And o usuário completa o cadastro com todos os dados obrigatórios
    And o usuário escolhe o método de entrega moto
    And o usuário faz upload da CNH
    Then o usuário é cadastrado com sucesso no sistema
	
	@bikeEletrica @positivo
  Scenario: Cadastro completo com bike elétrica
    And o usuário completa o cadastro com todos os dados obrigatórios
    And o usuário escolhe o método de entrega bike elétrica
    And o usuário faz upload da CNH
    Then o usuário é cadastrado com sucesso no sistema
    
  @vanCarro @positivo
  Scenario: Cadastro completo com van/carro
    And o usuário completa o cadastro com todos os dados obrigatórios
    And o usuário escolhe o método de entrega van/carro
    And o usuário faz upload da CNH
    Then o usuário é cadastrado com sucesso no sistema
  
  @semCNH @negativo
  Scenario: Cadastro completo com bike elétrica sem CNH
    And o usuário completa o cadastro com todos os dados obrigatórios
    And o usuário escolhe o método de entrega bike elétrica
    But o usuário não faz upload da CNH
    Then o usuário é informado sobre a necessidade de fazer upload de CNH
    
  @cadastroIncompleto @negativo  
  Scenario: Cadastro incompleto por falta de dados obrigatórios
    And o usuário tenta se cadastrar sem preencher todos os campos obrigatórios
    Then o sistema apresenta mensagens indicando quais campos são obrigatórios

	@CPFInvalido @negativo
  Scenario: Cadastro com CPF inválido
    And o usuário tenta se cadastrar com um número de CPF inválido
    Then o sistema apresenta uma mensagem de erro indicando “CPF inválido”

	@emailInvalido @negativo
  Scenario: Cadastro com e-mail inválido
    And o usuário tenta se cadastrar com um email inválido
    Then o sistema apresenta uma mensagem de erro “e-mail inválido”

	@CEPInvalido @negativo
	Scenario: Cadastro com CEP inválido
    And o usuário tenta se cadastrar com um número de CEP inválido
    Then o sistema apresenta uma mensagem de erro “CEP não encontrado”
  
  @maisDeUmMetodosDeEntrega @negativo
  Scenario: Selecionar mais de um metodo de entrega
  	And o usuário completa o cadastro com todos os dados obrigatórios
    And o usuário tenta se cadastrar selecionando mais de um método de entrega
    Then o sistema apresenta uma mensagem de erro “Selecionar apenas um método de entrega”
    