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

import static com.company.config.restfulBookingEnvironments.RESTFULBOOKING_URI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
public class GetLibroStepdefs {
     private CommonStepdefs commonStepdefs;
     public GetLibroStepdefs (CommonStepdefs commonStepdefs){
         this.commonStepdefs =commonStepdefs;
     }


    @When("el sistema envia un request al servicio de Listar  id")
    public void elSistemaEnviaUnRequestAlServicioDeListarId() {
        commonStepdefs.response = commonStepdefs.request.when()
                .get(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Consultar_Libros);
    }



    @When("el sistema envia un request al servicio de Listar  detalle por Id")
    public void elSistemaEnviaUnRequestAlServicioDeListarDetallePorId(Map<String,String> booking) {

        commonStepdefs.response = commonStepdefs.request.
                pathParam("bookingId",booking.get("bookingId")).
        when()
                .get(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Obtener_Detalle_Libro);

    }

    @And("Sistema deberia responder con response data")
    public void sistemaDeberiaResponderConResponseData(Map<String,String> expectData) {
        JsonPath actualData = new JsonPath(commonStepdefs.response.getBody().asString());
        Assert.assertEquals(expectData.get("additionalneeds:"),actualData.get("booking.additionalneeds"));


    }
}
