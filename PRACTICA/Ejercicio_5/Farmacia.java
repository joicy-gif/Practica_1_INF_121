package Ejercicio_5;

import java.io.Serializable;
import java.util.Scanner;

public class Farmacia implements Serializable {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento[] m = new Medicamento[100];

    public Farmacia() {}

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre farmacia: "); nombreFarmacia = sc.nextLine();
        System.out.print("Sucursal: "); sucursal = sc.nextInt(); sc.nextLine();
        System.out.print("Dirección: "); direccion = sc.nextLine();
        System.out.print("Cantidad de medicamentos: "); nroMedicamentos = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < nroMedicamentos; i++) {
            m[i] = new Medicamento();
            System.out.println("Medicamento #" + (i + 1));
            m[i].leer();
        }
    }

    public void mostrar() {
        System.out.println("Farmacia{" +
                "nombre='" + nombreFarmacia + '\'' +
                ", sucursal=" + sucursal +
                ", direccion='" + direccion + '\'' +
                ", medicamentos=" + nroMedicamentos +
                '}');
        for (int i = 0; i < nroMedicamentos; i++) {
            m[i].mostrar();
        }
    }

    public String getDireccion() { return direccion; }
    public int getSucursal() { return sucursal; }

    public void mostrarMedicamentos(String tipo) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase(tipo)) {
                m[i].mostrar();
            }
        }
    }

    public boolean buscaMedicamento(String nombre) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Medicamento[] getMedicamentos() { return m; }
    public int getNroMedicamentos() { return nroMedicamentos; }

    // ✅ Corrección: método para adicionar medicamentos al arreglo
    public void agregarMedicamento(Medicamento med) {
        if (nroMedicamentos < m.length) {
            m[nroMedicamentos] = med;
            nroMedicamentos++;
        } else {
            System.out.println("No se puede agregar: arreglo lleno.");
        }
    }

    // ✅ Corrección: método para eliminar un medicamento en posición y compactar
    public void eliminarMedicamentoEnPosicion(int pos) {
        if (pos < 0 || pos >= nroMedicamentos) return;
        for (int i = pos; i < nroMedicamentos - 1; i++) {
            m[i] = m[i + 1];
        }
        m[nroMedicamentos - 1] = null;
        nroMedicamentos--;
    }
}
