package Ejercicio_3;

import java.io.*;
import java.util.*;

public class ArchivoProducto {
    private String nomA;

    public ArchivoProducto(String nomA) {
        this.nomA = nomA;
    }

    // a) Crear archivo vacío
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(new ArrayList<Producto>());
            System.out.println("Archivo creado: " + nomA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Guardar producto
    public void guardarProducto(Producto p) {
        List<Producto> lista = leerProductos();
        lista.add(p);
        guardarLista(lista);
        System.out.println("Producto guardado: " + p.getNombre());
    }

    // c) Buscar producto por código
    public Producto buscaProducto(int c) {
        List<Producto> lista = leerProductos();
        for (Producto p : lista) {
            if (p.getCodigo() == c) {
                return p;
            }
        }
        return null;
    }

    // d) Calcular promedio de precios
    public float promedioPrecios() {
        List<Producto> lista = leerProductos();
        if (lista.isEmpty()) return 0;
        float suma = 0;
        for (Producto p : lista) {
            suma += p.getPrecio();
        }
        return suma / lista.size();
    }

    // e) Mostrar producto más caro
    public Producto productoMasCaro() {
        List<Producto> lista = leerProductos();
        Producto caro = null;
        for (Producto p : lista) {
            if (caro == null || p.getPrecio() > caro.getPrecio()) {
                caro = p;
            }
        }
        return caro;
    }

    // Métodos auxiliares
    private List<Producto> leerProductos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            return (List<Producto>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void guardarLista(List<Producto> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
	