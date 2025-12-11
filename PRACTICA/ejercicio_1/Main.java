package ejercicio_1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear algunos charangos de ejemplo
        Charango c1 = new Charango("Madera", 10, new boolean[]{true,true,true,true,true,true,true,true,true,true});
        Charango c2 = new Charango("Metal", 8, new boolean[]{false,false,false,false,false,false,true,true});
        Charango c3 = new Charango("Plástico", 10, new boolean[]{true,true,true,true,true,false,false,false,false,false});

        List<Charango> lista = new ArrayList<>(Arrays.asList(c1, c2, c3));

        // Guardar en archivo
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("charangos.dat"))) {
            oos.writeObject(lista);
            System.out.println("✅ Charangos guardados en archivo.");
        } catch(Exception e){ e.printStackTrace(); }

        // Leer desde archivo
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("charangos.dat"))) {
            List<Charango> cargados = (List<Charango>) ois.readObject();

            System.out.println("\n📂 Lista inicial:");
            cargados.forEach(System.out::println);

         // b) Eliminar charangos con más de 6 cuerdas rotas
            for (int i = 0; i < cargados.size(); i++) {
                Charango c = cargados.get(i);
                if (c.cuerdasRotas() > 6) {
                    cargados.remove(i);
                    i--; 
                }
            }
            System.out.println("\nDespués de eliminar con >6 cuerdas rotas:");
            for (Charango c : cargados) {
                System.out.println(c);
            }

            // c) Listar charangos de material "Madera"
            System.out.println("\nCharangos de material Madera:");
            for (Charango c : cargados) {
                if (c.getMaterial().equalsIgnoreCase("Madera")) {
                    System.out.println(c);
                }
            }

            // d) Buscar charangos con 10 cuerdas
            System.out.println("\nCharangos con 10 cuerdas:");
            for (Charango c : cargados) {
                if (c.getNroCuerdas() == 10) {
                    System.out.println(c);
                }
            }

            // e) Ordenar por material alfabéticamente (ordenamiento clásico tipo burbuja)
            for (int i = 0; i < cargados.size() - 1; i++) {
                for (int j = i + 1; j < cargados.size(); j++) {
                    Charango ci = cargados.get(i);
                    Charango cj = cargados.get(j);
                    if (ci.getMaterial().compareToIgnoreCase(cj.getMaterial()) > 0) {
                        cargados.set(i, cj);
                        cargados.set(j, ci);
                    }
                }
            }
            System.out.println("\nCharangos ordenados por material:");
            for (Charango c : cargados) {
                System.out.println(c);
            }


        } catch(Exception e){ e.printStackTrace(); }
    }
}
