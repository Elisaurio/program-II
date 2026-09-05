package com.umg.casofacturacion;

import java.sql.Date;

public class Empleado extends Persona {
    private int idPuesto;
    private Date fechaContratacion;

    public Empleado(int id, String nombre, String apellidos, int idPuesto, Date fechaContratacion) {
        super(id, nombre, apellidos);
        this.idPuesto = idPuesto;
        this.fechaContratacion = fechaContratacion;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String describir() {
        return "Empleado #" + id + ": " + getNombreCompleto()
                + " | Puesto ID: " + idPuesto
                + " | Contratado: " + fechaContratacion;
    }
}
