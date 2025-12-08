import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathMedicos = "data/doctores";
        String pathConsultas = "data/citas";

        new File(pathMedicos).mkdirs();
        new File(pathConsultas).mkdirs();

        Consultorio consultorio = new Consultorio(pathConsultas, pathMedicos);

        System.out.println("=== A) ALTA DE 3 MEDICOS Y 9 CONSULTAS (GSON) ===");
        
        consultorio.agregarMedico(new Medico(50, "Carlos", "Vega", 100));
        consultorio.agregarMedico(new Medico(60, "Laura", "Meza", 200));
        consultorio.agregarMedico(new Medico(70, "Roberto", "Solis", 150));

        consultorio.agregarConsulta(new Consulta(1001, "Aldo", "Raine", 50, 15, "abril", 2023));
        consultorio.agregarConsulta(new Consulta(1002, "Elena", "Torres", 50, 25, "diciembre", 2023)); 
        consultorio.agregarConsulta(new Consulta(1003, "Hugo", "Landa", 50, 20, "agosto", 2023));

        consultorio.agregarConsulta(new Consulta(2001, "Martin", "Fly", 60, 14, "febrero", 2023));
        consultorio.agregarConsulta(new Consulta(2002, "Emilio", "Brown", 60, 1, "enero", 2024)); 
        consultorio.agregarConsulta(new Consulta(2003, "Ben", "Tanner", 60, 10, "noviembre", 2023));

        consultorio.agregarConsulta(new Consulta(3001, "Walter", "Blanco", 70, 25, "diciembre", 2023)); 
        consultorio.agregarConsulta(new Consulta(3002, "Jessy", "Pink", 70, 5, "mayo", 2023));
        consultorio.agregarConsulta(new Consulta(3003, "Saul", "Goodman", 70, 1, "enero", 2024)); 

        consultorio.mostrarMedicos();
        consultorio.mostrarConsultas();

        System.out.println("\n=== B) BAJA DE DRA. LAURA MEZA Y SUS CONSULTAS ===");
        consultorio.bajaMedicoYConsultas("Laura", "Meza");
        
        System.out.println("--- verificamos ---");
        consultorio.mostrarMedicos(); 
        consultorio.mostrarConsultas(); 

        System.out.println("C) CAMBIAR FECHAS FESTIVAS (Navidad/Año Nuevo) ");
        consultorio.cambiarFechasFestivas();
        
        System.out.println("--- Verificamos---");
        consultorio.mostrarConsultas(); 
    }
}