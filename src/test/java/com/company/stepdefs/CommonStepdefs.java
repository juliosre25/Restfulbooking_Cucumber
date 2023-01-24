package com.company.stepdefs;

import com.company.entities.datosCompartidos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CommonStepdefs {
    protected RequestSpecification request;
    protected Response response;


    @Given("el sistema esta listo entonces enviamos un request")
    public void elSistemaEstaListoEntoncesEnviamosUnRequest() {
        request =  given()
                .header("Authorization", datosCompartidos.getAPIToken())
                .header("Content-Type","application/json");
    }

    @Then("el response Status deberia ser {int}")
    public void elResponseStatusDeberiaSer(int statusCode) {
        response.then()
                .log()
                .all()
                .statusCode(statusCode);
}

}