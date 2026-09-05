package com.umg.casofacturacion;

import java.sql.Timestamp;

public class Factura {
    private int id;
    private int idCliente;
    private int idEmpleado;
    private Timestamp fecha;
    private double total;

    public Factura(int id, int idCliente, int idEmpleado, Timestamp fecha, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{id=" + id + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado
                + ", fecha=" + fecha + ", total=" + total + "}";
    }
}
