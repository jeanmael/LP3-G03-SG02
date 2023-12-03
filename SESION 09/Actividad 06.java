import java.io.*;

class Fecha {
    int dia, mes, año;

    Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    int getDia() {
        return dia;
    }

    void setDia(int dia) {
        this.dia = dia;
    }

    int getMes() {
        return mes;
    }

    void setMes(int mes) {
        this.mes = mes;
    }

    int getAño() {
        return año;
    }

    void setAño(int año) {
        this.año = año;
    }
}

class Personal {
    String nif, nombre;
    int edad;

    Personal(String nif, String nombre, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
    }

    String getNif() {
        return nif;
    }

    void setNif(String nif) {
        this.nif = nif;
    }

    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    int getEdad() {
        return edad;
    }

    void setEdad(int edad) {
        this.edad = edad;
    }
}

class Alumno extends Personal {
    Fecha fechaMatricula;

    Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nif, nombre, edad);
        this.fechaMatricula = fechaMatricula;
    }

    Alumno() {
        super("", "", 0);
        fechaMatricula = new Fecha(0, 0, 0);
    }

    Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes(fechaMatricula.getMes());
        this.fechaMatricula.setAño(fechaMatricula.getAño());
    }
}

public class Main {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        try {
            fos = new FileOutputStream("Ficheros/alumnos.dat");
            salida = new ObjectOutputStream(fos);

            Fecha fecha1 = new Fecha(5, 9, 2011);
            Alumno alumno1 = new Alumno("123456784", "Lucas Gonzalez", 25, fecha1);
            salida.writeObject(alumno1);

            Fecha fecha2 = new Fecha(7, 9, 2011);
            Alumno alumno2 = new Alumno("987654328", "Maria Zapata", 22, fecha2);
            salida.writeObject(alumno2);

            Fecha fecha3 = new Fecha(8, 9, 2011);
            Alumno alumno3 = new Alumno("782342128", "Juan Perez", 20, fecha3);
            salida.writeObject(alumno3);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (salida != null)
                    salida.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
