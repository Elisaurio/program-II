package com.umg.casofacturacion;

/**
 * Clase abstracta que agrupa los atributos comunes
 * entre Cliente y Empleado (Herencia).
 */
public abstract class Persona {
    protected int id;
    protected String nombre;
    protected String apellidos;

    public Persona(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    // Método abstracto: cada subclase decide cómo describirse (Polimorfismo)
    public abstract String describir();

    @Override
    public String toString() {
        return describir();
    }
}
