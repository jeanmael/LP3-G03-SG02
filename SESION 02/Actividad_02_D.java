package javaapplication1;

public class Diagnostico {
    public static boolean aptoVacunaA(Perro perro) {
        return perro.getTemp() >= 37 && perro.getTemp() <= 40 && perro.getPeso() > 5 && perro.getEdad() > 1;
    }

    public static boolean aptoVacunaB(double temp, double peso, int edad) {
        return temp >= 37 && temp <= 40 && peso >5 && edad> 1;
    }
}
