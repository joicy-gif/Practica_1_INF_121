package ejercicio_2;

import java.io.*;
import java.util.*;

public class ArchivoTrabajador {
    private String nombreArch;

    public ArchivoTrabajador(String nombreArch) {
        this.nombreArch = nombreArch;
    }

    // a) Crear y guardar archivo con lista vacía
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArch))) {
            oos.writeObject(new ArrayList<Trabajador>());
            System.out.println("Archivo creado: " + nombreArch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Guardar trabajador en archivo
    public void guardarTrabajador(Trabajador t) {
        List<Trabajador> lista = leerTrabajadores();
        lista.add(t);
        guardarLista(lista);
        System.out.println("Trabajador guardado: " + t.getNombre());
    }

    // c) Aumentar salario de un trabajador
    public void aumentaSalario(int aumento, Trabajador t) {
        List<Trabajador> lista = leerTrabajadores();
        for (Trabajador tr : lista) {
            if (tr.getCarnet() == t.getCarnet()) {
                tr.setSalario(tr.getSalario() + aumento);
                System.out.println("Salario aumentado a: " + tr.getNombre());
                break;
            }
        }
        guardarLista(lista);
    }

    // d) Buscar trabajador con mayor salario
    public Trabajador mayorSalario() {
        List<Trabajador> lista = leerTrabajadores();
        Trabajador mayor = null;
        for (Trabajador t : lista) {
            if (mayor == null || t.getSalario() > mayor.getSalario()) {
                mayor = t;
            }
        }
        return mayor;
    }

    // e) Ordenar trabajadores por salario
    public void ordenarPorSalario() {
        List<Trabajador> lista = leerTrabajadores();
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getSalario() > lista.get(j).getSalario()) {
                    Trabajador temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        System.out.println("Trabajadores ordenados por salario:");
        for (Trabajador t : lista) {
            System.out.println(t);
        }
    }

    // Métodos auxiliares
    private List<Trabajador> leerTrabajadores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArch))) {
            return (List<Trabajador>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void guardarLista(List<Trabajador> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArch))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
