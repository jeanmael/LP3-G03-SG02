public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;

    public Persona(int id, String nombre, String apellido, int numeroCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuenta = new Cuenta(numeroCuenta, 0);
    }

    // Getter y setter para el campo cuenta
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCuenta: " + cuenta.toString();
    }
}

public class Cuenta {
    private int numero;
    private double saldo;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Cuenta(int numero) {
        this(numero, 0);
    }

    @Override
    public String toString() {
        return "Número de cuenta: " + numero + "\nSaldo: " + saldo;
    }
}
