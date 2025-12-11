package Ejercicio_9;

import java.io.Serializable;

public class Zoologico implements Serializable {
    private int id;
    private String nombre;
    private int nroAnimales;
    private Animal[] animales = new Animal[30];

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNroAnimales() { return nroAnimales; }
    public Animal[] getAnimales() { return animales; }

    public void agregarAnimal(Animal a) {
        if (nroAnimales < animales.length) {
            animales[nroAnimales] = a;
            nroAnimales++;
        }
    }

    public void eliminarAnimalEnPos(int pos) {
        for (int i = pos; i < nroAnimales - 1; i++) {
            animales[i] = animales[i + 1];
        }
        animales[nroAnimales - 1] = null;
        nroAnimales--;
    }

    public void mostrar() {
        System.out.println("Zoologico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nroAnimales=" + nroAnimales +
                '}');
        for (int i = 0; i < nroAnimales; i++) {
            animales[i].mostrar();
        }
    }
}
