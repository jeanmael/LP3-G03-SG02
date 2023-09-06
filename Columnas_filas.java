/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.diagonal;

/**
 *
 * @author USER
 */
import java.util.Scanner;
 
public class Diagonal {
    public static void main (String[] args) {
 
	Scanner sc = new Scanner (System.in);
	int[][] matriz = new int[4][4];
	int[] sumaFila = new int[4];
	int i, j, fila = 0, columna=0, principal=0, inversa=0, sumaMedia=0, media=0;
 
 
	System.out.println ("Introduce los valores de la matriz: ");
	for (i=0; i<4; i++)
            for (j=0; j<4; j++) {
		System.out.print (" - Fila " + (i+0) + " Columna " + (j+0) + ": ");
		matriz[i][j] = sc.nextInt();
	}
 
	System.out.println (" ");
 
		//Suma de una FILA que se pedirá al usuario
	System.out.println ("Introduce la fila que quieras sumar");
	for (i=0; i<4; i++) {
 
	}
 
	System.out.println ("El resultado de la FILA es: " + fila);
 
	System.out.println (" ");
 
		//Suma de la COLUMNA que se pide al usuario
	System.out.println ("Introduce la columna que quieras sumar");
            for (j=0; j<4; j++) {
		columna=sc.nextInt();
 
            }
            System.out.println ("El resultado de la COLUMNA es: " + columna);
 
	System.out.println (" ");
 
		//Suma de la DIAGONAL PRINCIPAL
            for (i=0; i<4; i++)
		for (j=0; j<4; j++) {
                    principal = matriz[0][0] + matriz[1][1] + matriz[2][2] + matriz[3][3];
				}
            System.out.println ("El resultado de la DIAGONAL PRINCIPAL es: " + principal);
 
    System.out.println (" ");
 
		//Suma de la DIAGONAL INVERSA
            for (i=0; i<4; i++)
		for (j=0; j<4; j++) {
                    inversa = matriz[3][0] + matriz[2][1] + matriz[1][2] + matriz[0][3];
                    }
            System.out.println ("El resultado de la DIAGONAL INVERSA es: " + inversa);
 
    System.out.println (" ");
 
		//MEDIA de todos lo valores de la matriz
            for (i=0; i<4; i++)
                for (j=0; j<4; j++) {
                    sumaMedia+= matriz[i][j];
                    media = sumaMedia/16;
		}
            System.out.println ("El resultado de la MEDIA es: " + media);
    }
}
