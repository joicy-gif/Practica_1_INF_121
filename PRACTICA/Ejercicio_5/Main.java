package Ejercicio_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArchFarmacia archivo = new ArchFarmacia("farmacias.dat");
        archivo.crearArchivo();

        // Crear farmacias de ejemplo
        Farmacia f1 = new Farmacia();
        System.out.println("Ingresar datos de Farmacia 1:");
        f1.leer();

        Farmacia f2 = new Farmacia();
        System.out.println("\n Ingresar datos de Farmacia 2:");
        f2.leer();

        archivo.adicionar(f1);
        archivo.adicionar(f2);

        // a) Mostrar medicamentos para la tos de la sucursal número X
        System.out.println("\n a) Medicamentos para la tos de sucursal 1:");
        archivo.mostrarTosSucursal(1);

        // b) Mostrar sucursal y dirección que tienen el medicamento “Tapsin”
        System.out.println("\n b) Farmacias que tienen el medicamento 'Tapsin':");
        archivo.mostrarFarmaciaConTapsin();

        // c) Buscar medicamentos por tipo
        System.out.println("\n c) Buscar medicamentos de tipo 'Resfriado':");
        archivo.buscarPorTipo("Resfriado");

        // d) Ordenar farmacias por dirección alfabéticamente
        System.out.println("\n d) Farmacias ordenadas por dirección:");
        archivo.ordenarPorDireccion();

        // e) Mover medicamentos de tipo 'Tos' de sucursal 1 a sucursal 2
        System.out.println("\n e) Mover medicamentos de tipo 'Tos' de sucursal 1 a 2:");
        archivo.moverMedicamentos("Tos", 1, 2);
    }
}
