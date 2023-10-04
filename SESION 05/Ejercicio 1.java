(CODIGO de las tres clases)
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private char tipoCliente;
    private Cuenta cuenta;

    public Persona(int id, String nombre, String apellido, char tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = (tipoCliente == 'B' || tipoCliente == 'E') ? tipoCliente : 'C';
        int numeroCuentaBase = (tipoCliente == 'C') ? 1000 : (tipoCliente == 'B') ? 5000 : 8000;
        int numeroCuenta = (tipoCliente - 'A') * 1000 + numeroCuentaBase;
        this.cuenta = new Cuenta(numeroCuenta, 0, this.tipoCliente);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(char tipoCliente) {
        this.tipoCliente = (tipoCliente == 'B' || tipoCliente == 'E') ? tipoCliente : 'C';
        this.cuenta.setTipoCliente(this.tipoCliente);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        String tipoClienteString = (tipoCliente == 'C') ? "Cliente" : (tipoCliente == 'B') ? "Banca Exclusiva" : "Empresarial";
        return "ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido +
               "\nTipo de Cliente: " + tipoClienteString + "\n" + cuenta.toString();
    }
}

public class Cuenta {
    private int numero;
    private double saldo;
    private char tipoCliente;

    public Cuenta(int numero, double saldo, char tipoCliente) {
        this.numero = numero;
        this.saldo = Math.max(saldo, 50); // Garantizar saldo mínimo de 50 soles
        this.tipoCliente = tipoCliente;
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && saldo - cantidad >= 50) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: No se puede retirar esa cantidad o saldo mínimo no alcanzado.");
        }
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: Cantidad de depósito inválida.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public char getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(char tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Numero de cuenta: " + tipoCliente + numero + "\nSaldo: " + saldo + " soles";
    }
}

public class TestComposicion {
    public static void main(String[] args) {
        // Crear objetos de Persona
        Persona persona1 = new Persona(1, "Jeik", "Slot", 'C');
        Persona persona2 = new Persona(2, "Alf", "Garr", 'B');

        // Realizar operaciones de depósito y retiro en las cuentas
        persona1.getCuenta().depositar(100);
        persona1.getCuenta().retirar(30);

        persona2.getCuenta().depositar(500);
        persona2.getCuenta().retirar(200);

        // Mostrar la información de las personas y sus cuentas antes y después de las operaciones
        System.out.println("Informacion de Persona 1 antes de las operaciones:");
        System.out.println(persona1.toString());

        System.out.println("\nInformacion de Persona 2 antes de las operaciones:");
        System.out.println(persona2.toString());

        // Realizar más operaciones para demostrar restricciones de saldo mínimo
        persona1.getCuenta().retirar(80); // Intentar retirar más dinero del saldo actual

        // Cambiar el tipo de cliente y mostrar la nueva información
        persona2.setTipoCliente('E');

        System.out.println("\nInformacion de Persona 2 después de cambiar el tipo de cliente:");
        System.out.println(persona2.toString());

        // Intentar realizar una operación de retiro inválida
        persona2.getCuenta().retirar(1000); // Intentar retirar más dinero del saldo actual

        // Mostrar la información de las personas y sus cuentas después de las operaciones
        System.out.println("\nInformacion de Persona 1 despues de las operaciones:");
        System.out.println(persona1.toString());

        System.out.println("\nInformacion de Persona 2 despues de las operaciones:");
        System.out.println(persona2.toString());
    }
}
