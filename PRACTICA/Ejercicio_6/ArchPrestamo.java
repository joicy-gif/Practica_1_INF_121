package Ejercicio_6;

import java.io.*;
import java.util.*;

public class ArchPrestamo {
    private String nomArch;

    public ArchPrestamo(String nomArch) {
        this.nomArch = nomArch;
    }

    public void guardar(List<Prestamo> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomArch))) {
            oos.writeObject(lista);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Prestamo> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomArch))) {
            return (List<Prestamo>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
