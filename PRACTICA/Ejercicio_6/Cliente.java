package Ejercicio_6;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int codCliente;
    private String ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, String ci, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() { return codCliente; }

    public void mostrar() {
        System.out.println("Cliente{" +
                "codCliente=" + codCliente +
                ", ci='" + ci + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}');
    }
}
