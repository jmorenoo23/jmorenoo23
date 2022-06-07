#Author: joseantonio.moreno@mtp.es
#Feature: Integracion ws / Festivos y Cierres
#Scenario:
Feature: Integracion ws / Festivos y Cierres

  #CP_100
  Scenario: Localizador de oficinas - localizadorConsulta
    Given Mandar un GET request a http://maestroupre.correos.es/MaestroAdaptadorRouter URI
    When Tengo un status code de 200 en el /services/festivosycierres
    Then Muestrame la respuesta de /services/festivosycierres endpoint
    And POST con body localizadorConsultaFestivosyCierres en /services/festivosycierres endpoint
    Then Encontrar Festivo Nacional en response