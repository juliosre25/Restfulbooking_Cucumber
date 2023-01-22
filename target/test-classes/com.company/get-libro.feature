Feature: REST - Obtener los id Libro y  detalle de libro por ID
  As a user...
  I want to...

  @ApiRest
  Scenario: Obtener id de libros
    Given el sistema esta listo entonces enviamos un request
    When el sistema envia un request al servicio de Listar  id
    Then el response Status deberia ser 200

    @ApiRest
  Scenario: Obtener detalle de Libro por Id
      Given el sistema esta listo entonces enviamos un request
      When el sistema envia un request al servicio de Listar  detalle por Id
      |bookingId|276|
      Then el response Status deberia ser 200
      And Sistema deberia responder con response data
      |additionalneeds|Breakfast|