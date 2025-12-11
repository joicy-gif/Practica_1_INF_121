package Ejercicio_5;

import java.io.Serializable;
import java.util.Scanner;

public class Medicamento implements Serializable {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento() {}

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); nombre = sc.nextLine();
        System.out.print("Código: "); codMedicamento = sc.nextInt(); sc.nextLine();
        System.out.print("Tipo: "); tipo = sc.nextLine();
        System.out.print("Precio: "); precio = sc.nextDouble();
    }

    public void mostrar() {
        System.out.println("Medicamento{" +
                "nombre='" + nombre + '\'' +
                ", cod=" + codMedicamento +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}');
    }

    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public String getNombre() { return nombre; }
}
