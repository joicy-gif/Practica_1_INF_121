package Ejercicio_8;

import java.io.*;
import java.util.*;

public class ArchRefri {
    private String nombre;

    public ArchRefri(String nombre) {
        this.nombre = nombre;
    }

    public void guardar(List<Alimento> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(lista);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Alimento> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre))) {
            return (List<Alimento>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    // a) Crear, modificar por nombre, eliminar por nombre
    public void modificarCantidad(String nombreAlimento, int nuevaCantidad) {
        List<Alimento> lista = listar();
        for (Alimento a : lista) {
            if (a.getNombre().equalsIgnoreCase(nombreAlimento)) {
                a.setCantidad(nuevaCantidad);
                break;
            }
        }
        guardar(lista);
    }

    public void eliminarPorNombre(String nombreAlimento) {
        List<Alimento> lista = listar();
        lista.removeIf(a -> a.getNombre().equalsIgnoreCase(nombreAlimento));
        guardar(lista);
    }

    // b) Mostrar alimentos que caducaron antes de fecha X
    public void mostrarCaducadosAntes(String fechaX) {
        for (Alimento a : listar()) {
            if (a.getFechaVencimiento().compareTo(fechaX) < 0) {
                a.mostrar();
            }
        }
    }

    // c) Eliminar alimentos con cantidad 0
    public void eliminarCantidadCero() {
        List<Alimento> lista = listar();
        lista.removeIf(a -> a.getCantidad() == 0);
        guardar(lista);
    }

    // d) Buscar alimentos ya vencidos (fecha < hoy)
    public void mostrarVencidos() {
        String hoy = java.time.LocalDate.now().toString();
        for (Alimento a : listar()) {
            if (a.getFechaVencimiento().compareTo(hoy) < 0) {
                a.mostrar();
            }
        }
    }

    // e) Mostrar alimento con más cantidad
    public void alimentoMayorCantidad() {
        List<Alimento> lista = listar();
        Alimento mayor = null;
        for (Alimento a : lista) {
            if (mayor == null || a.getCantidad() > mayor.getCantidad()) {
                mayor = a;
            }
        }
        if (mayor != null) {
            System.out.println(" Alimento con mayor cantidad:");
            mayor.mostrar();
        }
    }
}
