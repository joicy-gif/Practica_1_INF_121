package Ejercicio_6;

import java.io.*;
import java.util.*;

public class ArchCliente {
    private String nomArch;

    public ArchCliente(String nomArch) {
        this.nomArch = nomArch;
    }

    public void guardar(List<Cliente> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomArch))) {
            oos.writeObject(lista);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Cliente> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomArch))) {
            return (List<Cliente>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
