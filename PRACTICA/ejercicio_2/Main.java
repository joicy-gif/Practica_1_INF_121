package ejercicio_2;

public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador archivo = new ArchivoTrabajador("trabajadores.dat");
        archivo.crearArchivo();

        Trabajador t1 = new Trabajador("Ana", 123, 3000);
        Trabajador t2 = new Trabajador("Luis", 456, 4500);
        Trabajador t3 = new Trabajador("Carlos", 789, 2800);

        archivo.guardarTrabajador(t1);
        archivo.guardarTrabajador(t2);
        archivo.guardarTrabajador(t3);

        archivo.aumentaSalario(500, t1);

        System.out.println("\n Trabajador con mayor salario:");
        System.out.println(archivo.mayorSalario());

        archivo.ordenarPorSalario();
    }
}
