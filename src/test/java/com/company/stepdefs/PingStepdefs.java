package com.company.stepdefs;

import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PingStepdefs {
    protected RequestSpecification request1;
    protected Response response1;
    @Given("el sistema esta listo entonces enviamos un request ping")
    public void elSistemaEstaListoEntoncesEnviamosUnRequestPing() {
        request1 =  given();
    }

    @When("el sistema envia un request al servicio de ping")
    public void elSistemaEnviaUnRequestAlServicioDePing() {
        response1 = request1.when()
         .get(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Ping_Api);
    }


    @Then("el response Status Code tiene que ser {int}")
    public void elResponseStatusCodeTieneQueSer(int statusCode) {
        response1.then()
                .log()
                .all()
                .statusCode(statusCode);
    }
}
