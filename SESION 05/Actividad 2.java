public class Automovil {
    private String placa;
    private int numPuertas;
    private String marca;
    private String modelo;
    private Motor motor;

    public Automovil(String placa, int numPuertas, String marca, String modelo, Motor motor) {
        this.placa = placa;
        this.numPuertas = numPuertas;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Información del Automóvil:\n" +
                "Placa: " + placa + "\n" +
                "Número de Puertas: " + numPuertas + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Motor:\n" + motor.toString();
    }
}

public class Motor {
    private int numMotor;
    private int revPorMin;

    public Motor(int numMotor, int revPorMin) {
        this.numMotor = numMotor;
        this.revPorMin = revPorMin;
    }

    public int getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(int numMotor) {
        this.numMotor = numMotor;
    }

    public int getRevPorMin() {
        return revPorMin;
    }

    public void setRevPorMin(int revPorMin) {
        this.revPorMin = revPorMin;
    }

    @Override
    public String toString() {
        return "Número de Motor: " + numMotor + "\n" +
                "Revoluciones por Minuto: " + revPorMin;
    }
}

public class TestAgregacion {
    public static void main(String[] args) {

        Motor motor1 = new Motor(12345, 2000);
        Motor motor2 = new Motor(67890, 1800);
        Automovil auto1 = new Automovil("ABC123", 4, "Toyota", "Corolla", motor1);
        Automovil auto2 = new Automovil("XYZ789", 2, "Honda", "Civic", motor2);

        System.out.println("Información del Automóvil 1:");
        System.out.println(auto1.toString());

        System.out.println("\nInformación del Automóvil 2:");
        System.out.println(auto2.toString());
    }
}
