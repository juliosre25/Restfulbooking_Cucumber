package com.company.entities;

public class datosCompartidos {

    private static String APIToken;


    public static String getAPIToken() {
        return APIToken;
    }

    public static void setAPIToken(String APIToken) {
        datosCompartidos.APIToken = APIToken;
    }
}
