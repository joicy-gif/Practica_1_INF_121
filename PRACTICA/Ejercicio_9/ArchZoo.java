package Ejercicio_9;

import java.io.*;
import java.util.*;

public class ArchZoo {
    private String nombre;

    public ArchZoo(String nombre) {
        this.nombre = nombre;
    }

    public void guardar(List<Zoologico> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(lista);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Zoologico> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre))) {
            return (List<Zoologico>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    // a) Crear, modificar nombre, eliminar por id
    public void modificarNombre(int id, String nuevoNombre) {
        List<Zoologico> lista = listar();
        for (Zoologico z : lista) {
            if (z.getId() == id) {
                lista.set(lista.indexOf(z), new Zoologico(id, nuevoNombre));
                break;
            }
        }
        guardar(lista);
    }

    public void eliminarPorId(int id) {
        List<Zoologico> lista = listar();
        lista.removeIf(z -> z.getId() == id);
        guardar(lista);
    }

    // b) Zoológicos con mayor variedad de animales
    public void zoologicosConMasVariedad() {
        List<Zoologico> lista = listar();
        int max = -1;
        for (Zoologico z : lista) {
            if (z.getNroAnimales() > max) max = z.getNroAnimales();
        }
        for (Zoologico z : lista) {
            if (z.getNroAnimales() == max) {
                z.mostrar();
            }
        }
    }

    // c) Zoológicos vacíos y eliminarlos
    public void eliminarZoologicosVacios() {
        List<Zoologico> lista = listar();
        lista.removeIf(z -> z.getNroAnimales() == 0);
        guardar(lista);
    }

    // d) Mostrar animales de especie x
    public void mostrarAnimalesEspecie(String especie) {
        for (Zoologico z : listar()) {
            for (int i = 0; i < z.getNroAnimales(); i++) {
                Animal a = z.getAnimales()[i];
                if (a.getEspecie().equalsIgnoreCase(especie)) {
                    a.mostrar();
                }
            }
        }
    }

    // e) Mover animales de zoológico x a zoológico y
    public void moverAnimales(int idOrigen, int idDestino) {
        List<Zoologico> lista = listar();
        Zoologico origen = null, destino = null;

        for (Zoologico z : lista) {
            if (z.getId() == idOrigen) origen = z;
            if (z.getId() == idDestino) destino = z;
        }

        if (origen != null && destino != null) {
            for (int i = 0; i < origen.getNroAnimales(); i++) {
                destino.agregarAnimal(origen.getAnimales()[i]);
            }
            origen = new Zoologico(origen.getId(), origen.getNombre()); // vaciar
            lista.set(lista.indexOf(destino), destino);
            lista.set(lista.indexOf(origen), origen);
            guardar(lista);
            System.out.println(" Animales movidos de zoológico " + idOrigen + " a " + idDestino);
        }
    }
}
