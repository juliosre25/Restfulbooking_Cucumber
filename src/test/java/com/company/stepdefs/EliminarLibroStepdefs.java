package com.company.stepdefs;

import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import io.cucumber.java.en.When;

import java.util.Map;

public class EliminarLibroStepdefs {

    private CommonStepdefs commonStepdefs;
    public EliminarLibroStepdefs (CommonStepdefs commonStepdefs){
        this.commonStepdefs =commonStepdefs;
    }
    @When("el sistema envia un request al servicio de Eliminar Libro por Id")
    public void elSistemaEnviaUnRequestAlServicioDeEliminarLibroPorId(Map<String,String> booking) {

        commonStepdefs.response = commonStepdefs.request.
                pathParam("bookingId",booking.get("bookingId")).
                when()
                .delete(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+ restfulBookingEndpoints.Eliminar_Libro);
    }
}
