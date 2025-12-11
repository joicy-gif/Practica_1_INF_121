package Ejercicio_7;

import java.io.Serializable;

public class Persona implements Serializable {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected int ci;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int ci) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ci = ci;
    }

    public int getCi() { return ci; }

    public void mostrar() {
        System.out.println("Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", ci=" + ci +
                '}');
    }
}
