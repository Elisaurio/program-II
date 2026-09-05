package com.umg.casofacturacion;

public class Cliente extends Persona {
    private String nit;
    private String email;

    public Cliente(int id, String nombre, String apellidos, String nit, String email) {
        super(id, nombre, apellidos);
        this.nit = nit;
        this.email = email;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String describir() {
        return "Cliente #" + id + ": " + getNombreCompleto()
                + " | NIT: " + nit + " | Email: " + email;
    }
}
