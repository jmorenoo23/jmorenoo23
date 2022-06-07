#Author: joseantonio.moreno@mtp.es
#Feature: Integracion ws – Localizador de oficinas
#Scenario:
Feature: Integracion ws / Localizador de oficinas

  #CP_91
  Scenario: Localizador de oficinas - homePaqOficinaConsultaCP
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body homePaqOficinaConsultaCP en /services/Localizador endpoint
    Then Encontrar S0001019D en response

  #CP_92
  Scenario: Localizador de oficinas - homePaqConsultaCP
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body homePaqConsultaCP en /services/Localizador endpoint
    Then Encontrar B0000013P en response

  #CP_93
  Scenario: Localizador de oficinas - homePaqConsultaCP1
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body homePaqConsultaCP1 en /services/Localizador endpoint
    Then Encontrar B0000013P en response

  #CP_94
  Scenario: Localizador de oficinas - homePaqConsultaTAP
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body homePaqConsultaTAP en /services/Localizador endpoint
    Then Encontrar B0000008P en response

  #CP_95
  Scenario: Localizador de oficinas - homePaqConsultaTAP1
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body homePaqConsultaTAP1 en /services/Localizador endpoint
    Then Encontrar B0000008P en response

  #CP_96
  Scenario: Localizador de oficinas - ConsultaProvincia
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body ConsultaProvincia en /services/Localizador endpoint
    Then Encontrar MADRID en response

  #CP_97
  Scenario: Localizador de oficinas - localizadorCoordenadasConsulta
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body localizadorCoordenadasConsulta en /services/Localizador endpoint
    Then Encontrar 0781915 en response

  #CP_98
  Scenario: Localizador de oficinas - localizadorConsulta
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Localizador
    Then Muestrame la respuesta de /services/Localizador endpoint
    And POST con body localizadorConsulta en /services/Localizador endpoint
    Then Encontrar 2834494 en response
