package com.company;


import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import com.company.entities.Credenciales;
import com.company.entities.datosCompartidos;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class HookTest {

    @Before
    public void beforeScenario(){

    }
    @Before
    public void beforeScenarioStart(){
        Credenciales credenciales = new Credenciales();
        credenciales.setUsername("admin");
        credenciales.setPassword("password123");
        RequestSpecification request;
        Response response;
        request = given()
                .header("Content-Type","application/json");
        response = request.
                when()
                .body(credenciales)
                .post(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Login);
        response.then()
                .log()
                .all()
                .statusCode(200);
        String responseJson = response.then().extract().body().asString();
        String token = from(responseJson).get("token");
        datosCompartidos.setAPIToken(token);
    }
    @After
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }
    @After
    public void afterScenario(){
        System.out.println("This will run after the every Scenario");
    }

}
