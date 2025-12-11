package Ejercicio_7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArchNinio archivo = new ArchNinio("niños.dat");

        // a) Crear y guardar niños
        List<Ninio> niños = Arrays.asList(
            new Ninio("Ana", "Lopez", "Perez", 101, 5, "normal", "media"),
            new Ninio("Luis", "Gomez", "Torrez", 102, 6, "bajo", "baja"),
            new Ninio("Maria", "Vargas", "Soto", 103, 7, "normal", "alta")
        );
        archivo.guardar(niños);

        System.out.println("\n a) Listar niños:");
        for (Ninio n : archivo.listar()) {
            n.mostrar();
        }

        System.out.println("\n b) Niños con peso adecuado:");
        archivo.pesoAdecuado();

        System.out.println("\n c) Niños con peso o talla inadecuada:");
        archivo.pesoTallaInadecuada();

        System.out.println("\n d) Promedio de edad:");
        System.out.println("Promedio: " + archivo.promedioEdad());

        System.out.println("\n e) Buscar niño con CI = 102:");
        Ninio buscado = archivo.buscarPorCi(102);
        if (buscado != null) buscado.mostrar();
        else System.out.println("No encontrado.");

        System.out.println("\n f) Niños con talla más alta:");
        archivo.niñosTallaAlta();
    }
}
