/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Perro fido = new Perro("chihuahua", "marron");
        Perro pelusa = new Perro("pequines", "blanco");

        System.out.print("Ingrese el nuevo peso para Fido: ");
        double nuevoPesoFido = scanner.nextDouble();
        fido.setPeso(nuevoPesoFido);

        System.out.print("Ingrese la nueva edad para Fido: ");
        int nuevaEdadFido = scanner.nextInt();
        fido.setEdad(nuevaEdadFido);

        System.out.print("Ingrese la nueva temperatura para Fido: ");
        double nuevaTempFido = scanner.nextDouble();
        fido.setTemp(nuevaTempFido);

        System.out.print("Ingrese el nuevo peso para Pelusa: ");
        double nuevoPesoPelusa = scanner.nextDouble();
        pelusa.setPeso(nuevoPesoPelusa);

        System.out.print("Ingrese la nueva edad para Pelusa: ");
        int nuevaEdadPelusa = scanner.nextInt();
        pelusa.setEdad(nuevaEdadPelusa);

        System.out.print("Ingrese la nueva temperatura para Pelusa: ");
        double nuevaTempPelusa = scanner.nextDouble();
        pelusa.setTemp(nuevaTempPelusa);

        System.out.println("DIAGNÓSTICO Fido: " + (Diagnostico.aptoVacunaA(fido) ? "Está SANO" : "Está ENFERMO"));
        System.out.println("DIAGNÓSTICO Pelusa: " + (Diagnostico.aptoVacunaA(pelusa) ? "Está SANO" : "Está ENFERMO"));
    }
}
