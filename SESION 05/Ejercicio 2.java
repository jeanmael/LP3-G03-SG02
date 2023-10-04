//CLASE AUTOMOVIL
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
        if (motor != null) {
            return "Automovil con motor\n" +
                    "Placa: " + placa + "\n" +
                    "No. Motor: " + motor.getNumMotor() + "\n" +
                    "No. Puertas: " + numPuertas + "\n" +
                    "Marca: " + marca + "\n" +
                    "Modelo: " + modelo + "\n" +
                    "RPM: " + motor.getRevPorMin();
        } else {
            return "Automovil sin motor\n" +
                    "Placa: " + placa + "\n" +
                    "No. Puertas: " + numPuertas + "\n" +
                    "Marca: " + marca + "\n" +
                    "Modelo: " + modelo;
        }
    }
}
//CLASE MOTOR
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
        return "No. Motor: " + numMotor + "\n" +
                "RPM: " + revPorMin;
    }
}
//CLASE TESTAGREGACION
public class TestAgregacion {
    public static void main(String[] args) {
      
        Motor motor = new Motor(3728, 1000);

        Automovil automovilConMotor = new Automovil("VH742", 5, "Nissan", "Versa", motor);

        Automovil automovilSinMotor = new Automovil("AU398", 3, "Toyota", "Corolla", null);

        System.out.println("Informacion del Automovil con Motor:");
        System.out.println(automovilConMotor.toString());

        System.out.println("\n-----------------------------------\n");

        System.out.println("Informacion del Automovil sin Motor:");
        System.out.println(automovilSinMotor.toString());
    }
}

