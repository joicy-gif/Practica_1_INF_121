package Ejercicio_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArchLibro archL = new ArchLibro("libros.dat");
        ArchPrestamo archP = new ArchPrestamo("prestamos.dat");
        ArchCliente archC = new ArchCliente("clientes.dat");

        // Datos de ejemplo
        List<Libro> libros = Arrays.asList(
            new Libro(1, "Java Básico", 50),
            new Libro(2, "POO Avanzado", 80),
            new Libro(3, "Estructuras", 60)
        );
        archL.guardar(libros);

        List<Cliente> clientes = Arrays.asList(
            new Cliente(101, "123456", "Ana", "Lopez"),
            new Cliente(102, "654321", "Luis", "Gomez")
        );
        archC.guardar(clientes);

        List<Prestamo> prestamos = Arrays.asList(
            new Prestamo(101, 1, "2025-10-01", 2),
            new Prestamo(102, 2, "2025-10-02", 1)
        );
        archP.guardar(prestamos);

        // a) Libros cuyo precio esté entre 40 y 70
        System.out.println("\n1) Libros entre 40 y 70:");
        for (Libro l : archL.listar()) {
            if (l.getPrecio() >= 40 && l.getPrecio() <= 70) {
                l.mostrar();
            }
        }

        // b) Ingreso total por libro 1
        double ingreso = 0;
        Libro libro = archL.buscarPorCodigo(1);
        if (libro != null) {
            for (Prestamo p : archP.listar()) {
                if (p.getCodLibro() == 1) {
                    ingreso += p.getCantidad() * libro.getPrecio();
                }
            }
        }
        System.out.println("\n2) Ingreso total por libro 1: " + ingreso);

        // c) Libros nunca prestados
        System.out.println("\n3) Libros nunca prestados:");
        Set<Integer> prestados = new HashSet<>();
        for (Prestamo p : archP.listar()) {
            prestados.add(p.getCodLibro());
        }
        for (Libro l : archL.listar()) {
            if (!prestados.contains(l.getCodLibro())) {
                l.mostrar();
            }
        }

        // d) Clientes que prestaron libro 2
        System.out.println("\n4) Clientes que prestaron libro 2:");
        Set<Integer> codClientes = new HashSet<>();
        for (Prestamo p : archP.listar()) {
            if (p.getCodLibro() == 2) {
                codClientes.add(p.getCodCliente());
            }
        }
        for (Cliente c : archC.listar()) {
            if (codClientes.contains(c.getCodCliente())) {
                c.mostrar();
            }
        }

        // e) Libro más prestado
        Map<Integer, Integer> contador = new HashMap<>();
        for (Prestamo p : archP.listar()) {
            contador.put(p.getCodLibro(), contador.getOrDefault(p.getCodLibro(), 0) + p.getCantidad());
        }
        int maxCod = -1, maxCant = -1;
        for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > maxCant) {
                maxCant = entry.getValue();
                maxCod = entry.getKey();
            }
        }
        Libro masPrestado = archL.buscarPorCodigo(maxCod);
        if (masPrestado != null) {
            System.out.println("\n5) Libro más prestado:");
            masPrestado.mostrar();
            System.out.println("Cantidad total prestada: " + maxCant);
        }
    }
}
