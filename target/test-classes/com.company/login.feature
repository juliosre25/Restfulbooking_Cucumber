Feature: REST - Logueo
  As a user...
  I want to...
@ApiRest
  Scenario Outline: Logueo Correcto
    Given el sistema esta listo entonces enviamos un request de logeo con "<username>" y "<password>"
    And utilizar el header
    When el sistema envia un request al servicio de login
    Then el response Status tiene que ser 200
    Then capturo el TOKEN
    Examples:
      |username|password|
      |admin|password123|