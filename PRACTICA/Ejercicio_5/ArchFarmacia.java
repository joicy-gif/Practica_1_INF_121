package Ejercicio_5;


import java.io.*;
import java.util.*;

public class ArchFarmacia {
    private String na;

    public ArchFarmacia(String na) {
        this.na = na;
    }

    public void crearArchivo() {
        guardarLista(new ArrayList<>());
    }

    public void adicionar(Farmacia f) {
        List<Farmacia> lista = listar();
        lista.add(f);
        guardarLista(lista);
    }

    public List<Farmacia> listar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(na))) {
            return (List<Farmacia>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void mostrarMedicamentosResfrios() {
        for (Farmacia f : listar()) {
            f.mostrarMedicamentos("Resfriado");
        }
    }

    public double precioMedicamentoTos() {
        double total = 0;
        for (Farmacia f : listar()) {
            Medicamento[] meds = f.getMedicamentos();
            for (int i = 0; i < f.getNroMedicamentos(); i++) {
                if (meds[i].getTipo().equalsIgnoreCase("Tos")) {
                    total += meds[i].getPrecio();
                }
            }
        }
        return total;
    }

    public void mostrarMedicamentosMenorTos() {
        for (Farmacia f : listar()) {
            Medicamento[] meds = f.getMedicamentos();
            for (int i = 0; i < f.getNroMedicamentos(); i++) {
                if (meds[i].getTipo().equalsIgnoreCase("Tos") && meds[i].getPrecio() < 50) {
                    meds[i].mostrar();
                }
            }
        }
    }

    // a) Mostrar medicamentos para la tos de sucursal X
    public void mostrarTosSucursal(int sucursalX) {
        for (Farmacia f : listar()) {
            if (f.getSucursal() == sucursalX) {
                f.mostrarMedicamentos("Tos");
            }
        }
    }

    // b) Mostrar sucursal y dirección que tienen el medicamento “Tapsin”
    public void mostrarFarmaciaConTapsin() {
        for (Farmacia f : listar()) {
            if (f.buscaMedicamento("Tapsin")) {
                System.out.println("Sucursal: " + f.getSucursal() + ", Dirección: " + f.getDireccion());
            }
        }
    }

    // c) Buscar medicamentos por tipo
    public void buscarPorTipo(String tipo) {
        for (Farmacia f : listar()) {
            f.mostrarMedicamentos(tipo);
        }
    }

    // d) Ordenar farmacias por dirección
    public void ordenarPorDireccion() {
        List<Farmacia> lista = listar();
        lista.sort(Comparator.comparing(Farmacia::getDireccion));
        for (Farmacia f : lista) {
            f.mostrar();
        }
    }

    // ✅ e) Mover medicamentos de tipo x de farmacia y a farmacia z
    public void moverMedicamentos(String tipo, int sucY, int sucZ) {
        List<Farmacia> lista = listar();
        Farmacia origen = null, destino = null;

        for (Farmacia f : lista) {
            if (f.getSucursal() == sucY) origen = f;
            if (f.getSucursal() == sucZ) destino = f;
        }

        if (origen == null || destino == null) {
            System.out.println("No se encontró la sucursal origen o destino.");
            return;
        }

        int i = 0;
        while (i < origen.getNroMedicamentos()) {
            Medicamento med = origen.getMedicamentos()[i];
            if (med != null && med.getTipo().equalsIgnoreCase(tipo)) {
                destino.agregarMedicamento(med);
                origen.eliminarMedicamentoEnPosicion(i);
            } else {
                i++;
            }
        }

        guardarLista(lista);
        System.out.println(" Medicamentos tipo '" + tipo + "' movidos de sucursal " + sucY + " a " + sucZ);
    }

    private void guardarLista(List<Farmacia> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
