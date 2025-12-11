package Ejercicio_6;

import java.io.*;
import java.util.*;

public class ArchLibro {
    private String nomArch;

    public ArchLibro(String nomArch) {
        this.nomArch = nomArch;
    }

    public void guardar(List<Libro> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomArch))) {
            oos.writeObject(lista);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Libro> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomArch))) {
            return (List<Libro>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    public Libro buscarPorCodigo(int cod) {
        for (Libro l : listar()) {
            if (l.getCodLibro() == cod) return l;
        }
        return null;
    }
}
