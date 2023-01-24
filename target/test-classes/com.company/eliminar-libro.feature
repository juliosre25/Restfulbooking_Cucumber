Feature: Rest - Eliminar Libro

Scenario: Eliminar detalle de Libro por Id
    Given el sistema esta listo entonces enviamos un request
    When el sistema envia un request al servicio de Eliminar Libro por Id
      |bookingId|276|
    Then el response Status deberia ser 200