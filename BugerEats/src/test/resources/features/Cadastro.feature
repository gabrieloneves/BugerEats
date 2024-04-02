#Author: gabrieldeoliveiraneves@gmail.com


Feature: Cadastro para fazer entregas
  Como uma pessoa interessada em fazer entregas
  Eu quero me cadastrar no sistema
  Para que eu possa começar a entregar pedidos
  
  Background:
  	Given que estou na página do Buger Eats
  	When clicar em “Cadastre-se para fazer entregas”
@cadastro
  Scenario: Cadastro completo com veículo motorizado
    And o usuário é direcionado para página de cadastro
    And o usuário completa o cadastro com todos os dados obrigatórios, incluindo a CNH
    Then o usuário é cadastrado com sucesso no sistema

  Scenario: Cadastro completo com bicicleta elétrica
    And o usuário deseja se cadastrar para fazer entregas com uma bicicleta elétrica
    And o usuário completa o cadastro com todos os dados obrigatórios
    Then o usuário é cadastrado com sucesso no sistema sem a necessidade de enviar CNH

  Scenario: Cadastro incompleto por falta de dados obrigatórios
    And o usuário deseja se cadastrar para fazer entregas
    And o usuário tenta se cadastrar sem preencher todos os campos obrigatórios
    Then o sistema apresenta mensagens indicando quais campos são obrigatórios

  Scenario: Cadastro com CPF inválido
    And o usuário deseja se cadastrar para fazer entregas
    And o usuário tenta se cadastrar com um número de CPF inválido
    Then o sistema apresenta uma mensagem de erro indicando “CPF inválido”

  Scenario: Cadastro com método de entrega “Bike Elétrica” e upload de CNH opcional
    And o usuário escolhe “Bike Elétrica” como método de entrega durante o cadastro
    And o usuário completa o cadastro, optando por fazer ou não o upload da CNH
    Then o usuário é cadastrado com sucesso no sistema

  Scenario: Falha ao buscar CEP inexistente
    And o usuário está preenchendo o formulário de cadastro
    And o usuário insere um CEP que não existe e solicita a busca
    Then o sistema apresenta uma mensagem de erro “CEP não encontrado”

