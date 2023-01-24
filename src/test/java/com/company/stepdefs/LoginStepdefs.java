package com.company.stepdefs;

import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import com.company.entities.Credenciales;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import com.company.entities.datosCompartidos;
import org.junit.Before;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class LoginStepdefs {
    Credenciales credenciales = new Credenciales();
    protected RequestSpecification request;
    protected Response response;


    @Given("el sistema esta listo entonces enviamos un request de logeo con {string} y {string}")
    public void elSistemaEstaListoEntoncesEnviamosUnRequestDeLogeoConY(String username, String password) {

        credenciales.setUsername(username);
        credenciales.setPassword(password);
    }

    @And("utilizar el header")
    public void utilizarElHeader() {
        request = given()
                .header("Content-Type","application/json");
    }

    @When("el sistema envia un request al servicio de login")
    public void elSistemaEnviaUnRequestAlServicioDeLogin() {
        response = request.
                when()
                .body(credenciales)
                .post(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Login);
    }


    @Then("el response Status tiene que ser {int}")
    public void elResponseStatusTieneQueSer(int statusCode) {
        response.then()
                .log()
                .all()
                .statusCode(statusCode);
    }


    @Then("capturo el TOKEN")
    public void capturo_el_token() {
        String responseJson = response.then().extract().body().asString();
        String token = from(responseJson).get("token");
        System.out.println("--------------CreateToken-----------------");
        System.out.println("El token es: "+token);
        Assert.assertNotNull(token);
        Assert.assertEquals(200,response.statusCode());
        datosCompartidos.setAPIToken(token);
    }



}
