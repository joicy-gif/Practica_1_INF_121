package Ejercicio_4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArchiNota archivo = new ArchiNota("notas.dat");

        Estudiante e1 = new Estudiante("RU001", "Ana", "Lopez", "Perez", 20);
        Estudiante e2 = new Estudiante("RU002", "Luis", "Gomez", "Perez", 22);
        Estudiante e3 = new Estudiante("RU003", "Maria", "Torrez", "Vargas", 19);

        Nota n1 = new Nota("Matemática", 85.5, e1);
        Nota n2 = new Nota("Matemática", 92.0, e2);
        Nota n3 = new Nota("Física", 92.0, e3);

        archivo.agregarNotas(Arrays.asList(n1, n2, n3));

        System.out.println("\n Promedio de notas:");
        System.out.println(archivo.promedioNotas());

        System.out.println("\n Estudiantes con mejor nota:");
        for (Nota n : archivo.mejoresNotas()) {
            System.out.println(n);
        }
        System.out.println("\nEliminados:");
        archivo.eliminarPorMateria("Física");
    }
}
