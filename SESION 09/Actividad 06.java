//class Alumno
//class Alumno
public class Alumno extends Persona {

    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nif, nombre, edad);
        this.fechaMatricula = fechaMatricula;
    }

    public Alumno() {

    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}


