/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Alumno
 */
public class Principal {
    public static void main(String[] args){
        Perro perro1=new Perro();
        
        perro1.peso=100.8;
        System.out.println(perro1.peso);
        
        
        
        Perro perro2=new Perro("Bulldog","naranja",25,6,20);
        perro2.setRaza("Chihuahua");
        System.out.println(perro2.getRaza());
        perro2.increEdad(5);
        System.out.println(perro2);
        
        System.out.println(perro2);
        
        Diagnostico D1= new Diagnostico();
        D1.aptoVacunaA(perro2);
        
    }
}
