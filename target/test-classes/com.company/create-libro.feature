Feature: REST - Crear un libro
  As a user...
  I want to...

@ApiRest
  Scenario: Crear un Libro Satisfactoriamente
    Given el sistema esta listo entonces enviamos un request
    When el sistema envia un request al servicio de crear Libro
      |firstname|Julio|
      |lastname|Sanchez|
      |totalprice|111|
      |depositpaid|true|
      |checkin|2018-01-01|
      |checkout|2019-01-01|
      |additionalneeds|Prueba Cucumber|
  Then el response Status deberia ser 200


  @ApiRest
  Scenario: Crear un Libro caso con error
    Given el sistema esta listo entonces enviamos un request
    When el sistema envia un request al servicio de crear Libro sin adjuntar el booking Dates
      |firstname|Julio|
      |lastname|Sanchez|
      |totalprice|111|
      |depositpaid|true|
      |additionalneeds|Prueba Cucumber|
    Then el response Status deberia ser 500