import java.util.Arrays;
import java.util.Scanner;

interface Contenedora {
    boolean contiene(Object objeto);
}

class Procedencia {
    private String departamento;
    private String provincia;

    public Procedencia(String departamento, String provincia) {
        this.departamento = departamento;
        this.provincia = provincia;
    }
}

class Persona implements Contenedora {
    private String nombre;
    private String direccion;
    private String telefono;

    public Persona(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean contiene(Object objeto) {
        if (objeto instanceof String) {
            String nombreObjeto = (String) objeto;
            return this.nombre.equals(nombreObjeto);
        }
        return false;
    }
}

class Goodies implements Contenedora {
    private int id;
    private String descripcion;
    private float precio;

    public Goodies(int id, String descripcion, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public boolean contiene(Object objeto) {
        if (objeto instanceof Integer) {
            int idObjeto = (int) objeto;
            return this.id == idObjeto;
        }
        return false;
    }
}

class Estudiante extends Persona {
    private String especialidad;
    private Procedencia procedencia;

    public Estudiante(String nombre, String direccion, String telefono,
                      String especialidad, Procedencia procedencia) {
        super(nombre, direccion, telefono);
        this.especialidad = especialidad;
        this.procedencia = procedencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    @Override
    public boolean contiene(Object objeto) {
        if (objeto instanceof Estudiante) {
            Estudiante estudianteObjeto = (Estudiante) objeto;
            return this.getNombre().equals(estudianteObjeto.getNombre()) &&
                   this.procedencia.equals(estudianteObjeto.getProcedencia());
        }
        return false;
    }
}

public class VerificadorExistencia {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean verificarExistencia(Contenedora[] objetos, Object objeto) {
        return Arrays.stream(objetos)
                .anyMatch(contenedora -> contenedora.contiene(objeto));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Persona persona1 = new Persona("John", "Av. SARTE", "12345");
            Persona persona2 = new Persona("George", "Av. EJERCITO", "67890");

            Goodies goodies1 = new Goodies(1, "Descripcion1", 10.5f);
            Goodies goodies2 = new Goodies(2, "Descripcion2", 20.0f);

            Procedencia procedencia1 = new Procedencia("Arequipa", "Caylloma");
            Procedencia procedencia2 = new Procedencia("Arequipa", "Camana");

            Estudiante estudiante1 = new Estudiante("Paul", "Miraflores", "54321", "Ingeniero de sistemas", procedencia1);
            Estudiante estudiante2 = new Estudiante("Charly", "Ormeño", "09876", "Arquitecto", procedencia2);

            Contenedora[] objetos = {persona1, persona2, goodies1, goodies2, estudiante1, estudiante2};

            System.out.println("Ingrese el nombre para verificar la existencia de una Persona:");
            String nombrePersona = scanner.nextLine();
            System.out.println("La Persona con nombre '" + nombrePersona + "' existe: " +
                    verificarExistencia(objetos, nombrePersona));

            System.out.println("\nIngrese el ID para verificar la existencia de un Goodie:");
            int idGoodie;
            try {
                idGoodie = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("El Goodie con ID " + idGoodie + " existe: " + verificarExistencia(objetos, idGoodie));
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor entero válido para el ID de Goodie.");
            }

            System.out.println("\nIngrese el nombre y la procedencia para verificar la existencia de un Estudiante:");
            System.out.print("Nombre del Estudiante: ");
            String nombreEstudiante = scanner.nextLine();
            System.out.print("Departamento de Procedencia: ");
            String departamentoProcedencia = scanner.nextLine();
            System.out.print("Provincia de Procedencia: ");
            String provinciaProcedencia = scanner.nextLine();

            Procedencia procedenciaEstudiante = new Procedencia(departamentoProcedencia, provinciaProcedencia);
            Estudiante estudianteBusqueda = new Estudiante(nombreEstudiante, null, null, null, procedenciaEstudiante);
            System.out.println("El Estudiante con nombre '" + nombreEstudiante + "' y procedencia '" +
                    departamentoProcedencia + ", " + provinciaProcedencia + "' existe: " +
                    verificarExistencia(objetos, estudianteBusqueda));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

