package Ejercicio_9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArchZoo archivo = new ArchZoo("zoo.dat");

        // a) Crear zoológicos
        Zoologico z1 = new Zoologico(1, "Zoo Central");
        z1.agregarAnimal(new Animal("León", "Simba", 2));
        z1.agregarAnimal(new Animal("Elefante", "Dumbo", 1));

        Zoologico z2 = new Zoologico(2, "Zoo Norte");
        z2.agregarAnimal(new Animal("Tigre", "Rajah", 3));

        Zoologico z3 = new Zoologico(3, "Zoo Vacío");

        List<Zoologico> lista = new ArrayList<>();
        lista.add(z1);
        lista.add(z2);
        lista.add(z3);
        archivo.guardar(lista);

        System.out.println("\na) Zoológicos creados:");
        for (Zoologico z : archivo.listar()) z.mostrar();

        archivo.modificarNombre(2, "Zoo Renombrado");
        archivo.eliminarPorId(3);

        System.out.println("\n b) Zoológicos con más variedad:");
        archivo.zoologicosConMasVariedad();

        System.out.println("\n c) Eliminar zoológicos vacíos:");
        archivo.eliminarZoologicosVacios();

        System.out.println("\n d) Animales de especie 'Tigre':");
        archivo.mostrarAnimalesEspecie("Tigre");

        System.out.println("\n e) Mover animales de zoológico 1 a 2:");
        archivo.moverAnimales(1, 2);
    }
}
