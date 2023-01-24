package com.company.stepdefs;

import com.company.config.restfulBookingEndpoints;
import com.company.config.restfulBookingEnvironments;
import com.company.entities.Libro;
import com.company.entities.BookingDates;
import io.cucumber.java.en.When;


import java.util.Map;

public class createLibroStepdefs {
    private CommonStepdefs commonStepdefs;
    public createLibroStepdefs(CommonStepdefs commonStepdefs){
        this.commonStepdefs =commonStepdefs;
    }

    @When("el sistema envia un request al servicio de crear Libro")
    public void elSistemaEnviaUnRequestAlServicioDeCrearLibro(Map<String,String>libroData) {
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
                post(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+restfulBookingEndpoints.Crear_Libro);
    }

    @When("el sistema envia un request al servicio de crear Libro sin adjuntar el booking Dates")
    public void el_sistema_envia_un_request_al_servicio_de_crear_libro_sin_adjuntar_el_booking_dates(Map<String,String>libroData) {
        Libro libro = new Libro();
        libro.setFirstname(libroData.get("firstname"));
        libro.setLastname(libroData.get("lastname"));
        libro.setTotalprice(Integer.parseInt(libroData.get("totalprice")));
        libro.setDepositpaid(Boolean.parseBoolean(libroData.get("depositpaid")));
        libro.setAdditionalneeds(libroData.get("additionalneeds"));

        commonStepdefs.response = commonStepdefs.request.
                body(libro).
                when().
                post(restfulBookingEnvironments.RESTFULBOOKING_URI+ "/"+restfulBookingEndpoints.Crear_Libro);
    }
}
