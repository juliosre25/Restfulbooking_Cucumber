package com.company.stepdefs;

import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import com.company.entities.BookingDates;
import com.company.entities.Libro;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ActualizarLibroStepdefs {
    protected RequestSpecification request;
    protected Response response;
    private CommonStepdefs commonStepdefs;
    public ActualizarLibroStepdefs(CommonStepdefs commonStepdefs){
        this.commonStepdefs =commonStepdefs;
    }
        @When("el sistema envia un request al servicio de Actualizar Libro")
        public void elSistemaEnviaUnRequestAlServicioDeActualizarLibro(Map<String,String> libroData){
            Libro libro = new Libro();
            BookingDates bookingDates = new BookingDates();

            bookingDates.setCheckin(libroData.get("checkin"));
            bookingDates.setCheckout(libroData.get("checkout"));
            libro.setFirstname(libroData.get("firstname"));
            libro.setLastname(libroData.get("lastname"));
            libro.setTotalprice(Integer.parseInt(libroData.get("totalprice")));
            libro.setDepositpaid(Boolean.parseBoolean(libroData.get("depositpaid")));
            libro.setBookingdates(bookingDates);
            libro.setAdditionalneeds(libroData.get("additionalneeds"));

            commonStepdefs.response = commonStepdefs.request.
                    body(libro).
                    when().
                    put(restfulBookingEnvironments.RESTFULBOOKING_URI+"/"+ restfulBookingEndpoints.Actualizar_Libro+"596");
        }

    @When("el sistema envia un request al servicio de Actualizar Libro Parcial")
    public void elSistemaEnviaUnRequestAlServicioDeActualizarLibroParcial(Map<String,String> libroData) {
        Libro libro = new Libro();

        libro.setFirstname(libroData.get("firstname"));
        libro.setLastname(libroData.get("lastname"));
        commonStepdefs.response = commonStepdefs.request.
                body(libro).
                when().
                patch(restfulBookingEnvironments.RESTFULBOOKING_URI+"/"+ restfulBookingEndpoints.Actualizar_Libro+"596");
    }
}
