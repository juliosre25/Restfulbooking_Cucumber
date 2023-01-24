package com.company.entities;

public class Entities {
    private Credenciales credenciales;

    public Entities(){

    }

    public Entities(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    public Credenciales getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }
}
