public class Asalariado {
    private String nombre;
    private long dni;
    private int diasVacaciones;
    private double salarioBase;

    public Asalariado(String nombre, long dni, int diasVacaciones, double salarioBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.diasVacaciones = diasVacaciones;
        this.salarioBase = salarioBase;
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

    public double getSalarioBase() {
        return salarioBase;
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

    public double calcularNomina() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDNI: " + dni + "\nDías de Vacaciones: " + diasVacaciones + "\nSalario Base: " + salarioBase;
    }
}

public class EmpleadoProduccion extends Asalariado {
    private String turno;

    public EmpleadoProduccion(String nombre, long dni, int diasVacaciones, String turno, double salarioBase) {
        super(nombre, dni, diasVacaciones, salarioBase);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public double calcularNomina() {
        return getSalarioBase() * 1.15;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTurno: " + turno + "\nNómina: " + calcularNomina();
    }
}

public class EmpleadoDistribucion extends Asalariado {
    private String zona;

    public EmpleadoDistribucion(String nombre, long dni, int diasVacaciones, String zona, double salarioBase) {
        super(nombre, dni, diasVacaciones, salarioBase);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public double calcularNomina() {
        return getSalarioBase() * 1.10;
    }

    @Override
    public String toString() {
        return super.toString() + "\nZona: " + zona + "\nNómina: " + calcularNomina();
    }
}

public class TestHerencia {
    public static void main(String[] args) {
        Asalariado empleado1 = new Asalariado("Manuel Cortina", 1651265651, 28, 1000.0);
        EmpleadoProduccion empleado2 = new EmpleadoProduccion("Juan Mota", 555333111, 30, "Noche", 1200.0);
        EmpleadoDistribucion empleado3 = new EmpleadoDistribucion("Elsa Pito", 55533366, 35, "Granada", 1100.0);

        System.out.println("Empleado 1:");
        System.out.println(empleado1);

        System.out.println("\nEmpleado 2:");
        System.out.println(empleado2);

        System.out.println("\nEmpleado 3:");
        System.out.println(empleado3);
    }
}
