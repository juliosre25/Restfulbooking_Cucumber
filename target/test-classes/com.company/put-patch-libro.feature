Feature: REST - Actualizar un Libro-PUT y PATCH
@ApiRest
Scenario: Actualizar un Libro Satisfactoriamente
Given el sistema esta listo entonces enviamos un request
When el sistema envia un request al servicio de Actualizar Libro
|firstname|Miguel|
|lastname|Reyes|
|totalprice|125|
|depositpaid|true|
|checkin|2018-01-01|
|checkout|2019-01-01|
|additionalneeds|Prueba Cucumber Actualizacion|
Then el response Status deberia ser 200

  @ApiRest
Scenario: Actualizar un Libro Parcial
    Given el sistema esta listo entonces enviamos un request
    When el sistema envia un request al servicio de Actualizar Libro Parcial
      |firstname|Hernando|
      |lastname|De Moura|

    Then el response Status deberia ser 200