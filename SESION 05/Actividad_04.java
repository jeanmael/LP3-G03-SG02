public class Asalariado {
    private String nombre;
    private long dni;
    private int diasVacaciones;

    public Asalariado(String nombre, long dni, int diasVacaciones) {
        this.nombre = nombre;
        this.dni = dni;
        this.diasVacaciones = diasVacaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public long getDni() {
        return dni;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }
}

public class EmpleadoProduccion extends Asalariado {
    private String turno;

    public EmpleadoProduccion(String nombre, long dni, int diasVacaciones, String turno) {
        super(nombre, dni, diasVacaciones);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}

public class EmpleadoDistribucion extends Asalariado {
    private String zona;

    public EmpleadoDistribucion(String nombre, long dni, int diasVacaciones, String zona) {
        super(nombre, dni, diasVacaciones);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
}

public class Main {
    public static void main(String[] args) {
        Asalariado empleado1 = new Asalariado("Manuel Cortina", 1651265651, 28);
        EmpleadoProduccion empleado2 = new EmpleadoProduccion("Juan Mota", 555333111, 30, "Noche");
        EmpleadoDistribucion empleado3 = new EmpleadoDistribucion("Elsa Pito", 55533366, 35, "Granada");

        System.out.println("Nombre del empleado 1: " + empleado1.getNombre());

        System.out.println("Nombre del empleado 2: " + empleado2.getNombre());
        System.out.println("Turno del empleado 2: " + empleado2.getTurno());

        System.out.println("Nombre del empleado 3: " + empleado3.getNombre());
        System.out.println("Zona del empleado 3: " + empleado3.getZona());
    }
}
