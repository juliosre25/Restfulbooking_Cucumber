Feature: REST - Ping Api
  As a user...
  I want to...

  @ApiRest
  Scenario: Ping API
    Given el sistema esta listo entonces enviamos un request ping
    When el sistema envia un request al servicio de ping
    Then el response Status Code tiene que ser 201