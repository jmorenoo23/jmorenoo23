#Author: joseantonio.moreno@mtp.es
#Feature: Integracion ws / Distribucion
#Scenario:
Feature: Integracion ws / Distribucion

  #CP_99
  Scenario: Localizador de oficinas - localizadorConsulta
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/Distribucion
    Then Muestrame la respuesta de /services/Distribucion endpoint
    And POST con body localizadorConsultaDistribucion en /services/Distribucion endpoint
    Then Encontrar 2822996 en response