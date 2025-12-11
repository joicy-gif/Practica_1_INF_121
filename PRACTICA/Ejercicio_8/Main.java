package Ejercicio_8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArchRefri archivo = new ArchRefri("refri.dat");

        // a) Crear alimentos
        List<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento("Leche", "2025-12-01", 2));
        alimentos.add(new Alimento("Yogurt", "2025-11-30", 0));
        alimentos.add(new Alimento("Queso", "2025-12-10", 5));
        alimentos.add(new Alimento("Pan", "2025-12-03", 1));

        archivo.guardar(alimentos);

        System.out.println("\n a) Listar alimentos:");
        for (Alimento a : archivo.listar()) {
            a.mostrar();
        }

        archivo.modificarCantidad("Pan", 3);
        archivo.eliminarPorNombre("Yogurt");

        System.out.println("\n b) Alimentos caducados antes del 2025-12-02:");
        archivo.mostrarCaducadosAntes("2025-12-02");

        System.out.println("\n c) Eliminar alimentos con cantidad 0:");
        archivo.eliminarCantidadCero();
        for (Alimento a : archivo.listar()) {
            a.mostrar();
        }

        System.out.println("\n d) Alimentos ya vencidos:");
        archivo.mostrarVencidos();

        System.out.println("\n e) Alimento con mayor cantidad:");
        archivo.alimentoMayorCantidad();
    }
}
