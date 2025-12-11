package Ejercicio_8;

import java.io.Serializable;

public class Alimento implements Serializable {
    private String nombre;
    private String fechaVencimiento; // formato: "YYYY-MM-DD"
    private int cantidad;

    public Alimento(String nombre, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void mostrar() {
        System.out.println("Alimento{" +
                "nombre='" + nombre + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cantidad=" + cantidad +
                '}');
    }
}
