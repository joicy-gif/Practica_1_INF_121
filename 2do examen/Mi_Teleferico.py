class Persona:
    def __init__(self, nombre, edad, peso):
        self.nombre = nombre
        self.edad = edad
        self.peso = peso

class Cabina:
    def __init__(self, nro_cabina):
        self.nro_cabina = nro_cabina
        # Se inicializa con 10 espacios vacios
        self.personas_abordo = [None] * 10 

    def get_cantidad_actual(self):
        cant = 0
        for p in self.personas_abordo:
            if p is not None:
                cant += 1
        return cant

    def get_peso_actual(self):
        total = 0
        for p in self.personas_abordo:
            if p is not None:
                total += p.peso
        return total

    def agregar_persona(self, p):
        # Regla 1: Maximo 10 personas
        if self.get_cantidad_actual() >= 10:
            print("Cabina llena")
            return
        
        # Regla 2: Maximo 850 kg
        if self.get_peso_actual() + p.peso > 850:
            print("Excede peso maximo")
            return
        
        # Buscar espacio vacio (None) para agregar
        for i in range(len(self.personas_abordo)):
            if self.personas_abordo[i] is None:
                self.personas_abordo[i] = p
                return

class Linea:
    def __init__(self, color, cantidad_cabinas):
        self.color = color
        self.cabinas = []
        for i in range(cantidad_cabinas):
            self.cabinas.append(Cabina(i + 1))

    def subir_persona_especifica(self, p, nro_cabina):
        for c in self.cabinas:
            if c.nro_cabina == nro_cabina:
                c.agregar_persona(p)
                return

class MiTeleferico:
    def __init__(self):
        self.lineas = []
        self.lineas.append(Linea("Amarilla", 10))
        self.lineas.append(Linea("Roja", 10))
        self.lineas.append(Linea("Verde", 10))

    def agregar_persona_fila(self, p, nombre_linea, nro_cabina):
        for l in self.lineas:
            if l.color == nombre_linea:
                l.subir_persona_especifica(p, nro_cabina)
                return

    def verificar_reglas(self):
        for l in self.lineas:
            for c in l.cabinas:
                # Verificacion de seguridad redundante (ya controlada al agregar, pero util para reportes)
                if c.get_cantidad_actual() > 10:
                    print(f"Error cantidad: Linea {l.color} Cabina {c.nro_cabina}")
                if c.get_peso_actual() > 850:
                    print(f"Error peso: Linea {l.color} Cabina {c.nro_cabina}")

    def calcular_ingreso_total(self):
        total = 0.0
        for l in self.lineas:
            for c in l.cabinas:
                for p in c.personas_abordo:
                    if p is not None:
                        # Menores de 25 o mayores de 60 pagan 1.5
                        if p.edad < 25 or p.edad > 60:
                            total += 1.5
                        else:
                            total += 3.0
        return total

    def mostrar_linea_mas_ingreso_regular(self):
        mejor_linea = ""
        mayor_ingreso = -1.0
        
        for l in self.lineas:
            ingreso_linea = 0.0
            for c in l.cabinas:
                for p in c.personas_abordo:
                    if p is not None:
                        # Ingreso regular: personas entre 25 y 60 anios
                        if 25 <= p.edad <= 60:
                            ingreso_linea += 3.0
            
            if ingreso_linea > mayor_ingreso:
                mayor_ingreso = ingreso_linea
                mejor_linea = l.color
                
        print(f"Linea mas ingreso regular: {mejor_linea}")

if __name__ == "__main__":
    sis = MiTeleferico()
    
    # Creacion de personas de prueba
    p1 = Persona("A", 30, 70)
    p2 = Persona("B", 20, 60)
    
    # Subir personas
    sis.agregar_persona_fila(p1, "Amarilla", 1)
    sis.agregar_persona_fila(p2, "Amarilla", 1)
    
    # Resultados
    sis.verificar_reglas()
    print(f"Total: {sis.calcular_ingreso_total()}")
    sis.mostrar_linea_mas_ingreso_regular()