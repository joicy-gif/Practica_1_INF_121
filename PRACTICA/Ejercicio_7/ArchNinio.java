package Ejercicio_7;

import java.io.*;
import java.util.*;

public class ArchNinio {
    private String na;

    public ArchNinio(String na) {
        this.na = na;
    }

    public void guardar(List<Ninio> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na))) {
            oos.writeObject(lista);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Ninio> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(na))) {
            return (List<Ninio>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    // b) Niños con peso adecuado (simulado: peso = "normal")
    public void pesoAdecuado() {
        for (Ninio n : listar()) {
            if (n.getPeso().equalsIgnoreCase("normal")) {
                n.mostrar();
            }
        }
    }

    // c) Niños con edad incompatible con peso/talla (simulado: peso ≠ "normal" o talla ≠ "media")
    public void pesoTallaInadecuada() {
        for (Ninio n : listar()) {
            if (!n.getPeso().equalsIgnoreCase("normal") || !n.getTalla().equalsIgnoreCase("media")) {
                n.mostrar();
            }
        }
    }

    // d) Promedio de edad
    public double promedioEdad() {
        List<Ninio> lista = listar();
        if (lista.isEmpty()) return 0;
        int suma = 0;
        for (Ninio n : lista) {
            suma += n.getEdad();
        }
        return (double) suma / lista.size();
    }

    // e) Buscar niño por carnet
    public Ninio buscarPorCi(int ci) {
        for (Ninio n : listar()) {
            if (n.getCi() == ci) return n;
        }
        return null;
    }

    // f) Mostrar niños con talla más alta
    public void niñosTallaAlta() {
        for (Ninio n : listar()) {
            if (n.getTalla().equalsIgnoreCase("alta")) {
                n.mostrar();
            }
        }
    }
}
