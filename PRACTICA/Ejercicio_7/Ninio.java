package Ejercicio_7;

public class Ninio extends Persona {
    private int edad;
    private String peso;
    private String talla;

    public Ninio(String nombre, String apellidoPaterno, String apellidoMaterno, int ci,
                int edad, String peso, String talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() { return edad; }
    public String getPeso() { return peso; }
    public String getTalla() { return talla; }

    public void mostrar() {
        super.mostrar();
        System.out.println("Niño{" +
                "edad=" + edad +
                ", peso='" + peso + '\'' +
                ", talla='" + talla + '\'' +
                '}');
    }
}
