package Ejercicio_9;

import java.io.Serializable;

public class Animal implements Serializable {
    private String especie;
    private String nombre;
    private int cantidad;

    public Animal(String especie, String nombre, int cantidad) {
        this.especie = especie;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getEspecie() { return especie; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }

    public void mostrar() {
        System.out.println("Animal{" +
                "especie='" + especie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}');
    }
}
