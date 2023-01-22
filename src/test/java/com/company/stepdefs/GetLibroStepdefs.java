package com.company.stepdefs;

import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
public class GetLibroStepdefs {
     private RequestSpecification request;
     private Response response;

    @Given("el sistema esta listo entonces enviamos un request")
    public void elSistemaEstaListoEntoncesEnviamosUnRequest() {
     request =  given()
                .header("Authorization","1d280ae184861cb");
    }

    @When("el sistema envia un request al servicio de Listar  id")
    public void elSistemaEnviaUnRequestAlServicioDeListarId() {
        response = request.when()
                .get(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Consultar_Libros);
    }
    
    @Then("el response Status deberia ser {int}")
    public void elResponseStatusDeberiaSer(int statusCode) {
        response.then()
                .log()
                .all()
                .statusCode(statusCode);

    }

    @When("el sistema envia un request al servicio de Listar  detalle por Id")
    public void elSistemaEnviaUnRequestAlServicioDeListarDetallePorId(Map<String,String> booking) {

        response = request.
                pathParam("bookingId",booking.get("bookingId")).
        when()
                .get(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Obtener_Detalle_Libro);

    }

    @And("Sistema deberia responder con response data")
    public void sistemaDeberiaResponderConResponseData(Map<String,String> expectData) {
        JsonPath actualData = new JsonPath(response.getBody().asString());
        Assert.assertEquals(expectData.get("additionalneeds:"),actualData.get("booking.additionalneeds"));


    }
}
