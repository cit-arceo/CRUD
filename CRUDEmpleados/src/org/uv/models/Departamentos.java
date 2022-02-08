package org.uv.models;

/**
 *
 * @author citla
 */
public class Departamentos {
    private long clave;
    private String nombre;

    public Departamentos() {
    }

    public Departamentos(long clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
