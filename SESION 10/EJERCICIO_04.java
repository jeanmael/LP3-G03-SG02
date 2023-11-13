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

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto("P001", "Laptop", 2200.0);
        System.out.println("Producto: " + producto);

        Persona persona = new Persona("74787985", "Jhon Lennon", "Yanahuara");
        System.out.println("Persona: " + persona);

        Estudiante estudiante = new Estudiante("76548963", "Gerge Harrison", "Cayma", "Ing.de Sistemas");
        System.out.println("Estudiante: " + estudiante);

        System.out.println("Carrera del estudiante: " + estudiante.getCarrera());

        persona.setNombres("Jhon Lennon");
        System.out.println("Persona modificada: " + persona);
    }
}
