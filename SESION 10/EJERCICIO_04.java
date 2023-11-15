public class Producto {
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}

public class Persona {
    private String dni;
    private String nombres;
    private String direccion;

    public Persona(String dni, String nombres, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombres='" + nombres + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

public class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String dni, String nombres, String direccion, String carrera) {
        super(dni, nombres, direccion);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "carrera='" + carrera + '\'' +
                "} " + super.toString();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del Producto:");
        System.out.print("Codigo: ");
        String codigoProducto = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcionProducto = scanner.nextLine();
        System.out.print("Precio: ");
        double precioProducto = scanner.nextDouble();
        scanner.nextLine(); 

        Producto producto = new Producto(codigoProducto, descripcionProducto, precioProducto);
        System.out.println("Producto: " + producto);

        System.out.println("\nIngrese los datos de la Persona:");
        System.out.print("DNI: ");
        String dniPersona = scanner.nextLine();
        System.out.print("Nombres: ");
        String nombresPersona = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccionPersona = scanner.nextLine();

        Persona persona = new Persona(dniPersona, nombresPersona, direccionPersona);
        System.out.println("Persona: " + persona);

        System.out.println("\nIngrese los datos del Estudiante:");
        System.out.print("Carrera: ");
        String carreraEstudiante = scanner.nextLine();

        Estudiante estudiante = new Estudiante(dniPersona, nombresPersona, direccionPersona, carreraEstudiante);
        System.out.println("Estudiante: " + estudiante);

        System.out.println("\nCarrera del estudiante: " + estudiante.getCarrera());

        System.out.println("\nModifique el nombre de la persona:");
        System.out.print("Nuevo nombre: ");
        String nuevoNombrePersona = scanner.nextLine();
        persona.setNombres(nuevoNombrePersona);
        System.out.println("Persona modificada: " + persona);
    }
}

