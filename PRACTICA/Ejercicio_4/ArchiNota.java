package Ejercicio_4;

import java.io.*;
import java.util.*;

public class ArchiNota {
    private String nombreArchi;

    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
    }

    // b) Agregar varios estudiantes con sus notas
    public void agregarNotas(List<Nota> nuevasNotas) {
        List<Nota> lista = leerNotas();
        lista.addAll(nuevasNotas);
        guardarLista(lista);
        System.out.println("+ Notas agregadas.");
    }

    // c) Promedio de notas
    public double promedioNotas() {
        List<Nota> lista = leerNotas();
        if (lista.isEmpty()) return 0;
        double suma = 0;
        for (Nota n : lista) {
            suma += n.getNotaFinal();
        }
        return suma / lista.size();
    }

    // d) Buscar estudiante(s) con mejor nota
    public List<Nota> mejoresNotas() {
        List<Nota> lista = leerNotas();
        List<Nota> mejores = new ArrayList<>();
        double max = -1;
        for (Nota n : lista) {
            if (n.getNotaFinal() > max) {
                max = n.getNotaFinal();
                mejores.clear();
                mejores.add(n);
            } else if (n.getNotaFinal() == max) {
                mejores.add(n);
            }
        }
        return mejores;
    }

    // e) Eliminar estudiantes de una materia
    public void eliminarPorMateria(String materia) {
        List<Nota> lista = leerNotas();
        lista.removeIf(n -> n.getMateria().equalsIgnoreCase(materia));
        guardarLista(lista);
        System.out.println("Estudiantes eliminados de la materia: " + materia);
    }

    // Métodos auxiliares
    private List<Nota> leerNotas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchi))) {
            return (List<Nota>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void guardarLista(List<Nota> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchi))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
