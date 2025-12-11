package Ejercicio_3;

public class Main {
    public static void main(String[] args) {
        ArchivoProducto archivo = new ArchivoProducto("productos.dat");
        archivo.crearArchivo();

        Producto p1 = new Producto(101, "Teclado", 120.5f);
        Producto p2 = new Producto(102, "Mouse", 80.0f);
        Producto p3 = new Producto(103, "Monitor", 950.0f);

        archivo.guardarProducto(p1);
        archivo.guardarProducto(p2);
        archivo.guardarProducto(p3);

        System.out.println("\n Producto con código 102:");
        Producto buscado = archivo.buscaProducto(102);
        System.out.println(buscado != null ? buscado : "No encontrado");

        System.out.println("\n Promedio de precios:");
        System.out.println(archivo.promedioPrecios());

        System.out.println("\n Producto más caro:");
        System.out.println(archivo.productoMasCaro());
    }
}
