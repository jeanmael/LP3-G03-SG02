/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrizcuadrada;

/**
 *
 * @author USER
 */
import java.util.Scanner;

public class MatrizCuadrada {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int matriz[][] = new int[4][4];
        boolean salir = false;
        int opcion;
        boolean rellenado = false;

        do {
            System.out.println("Menu");
            System.out.println("1. Rellenar Matriz");
            System.out.println("2. Sumar fila");
            System.out.println("3. Sumar columna");
            System.out.println("4. Sumar diagonal principal");
            System.out.println("5. Sumar diagonal inversa");
            System.out.println("6. Calcular la media de la matriz");
            System.out.println("7. Salir");
            System.out.print("Elije una opción: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    if (!rellenado) {
                        rellenarMatriz(sn, matriz);
                        rellenado = true;
                    }
                    break;
                case 2:
                    if (rellenado) {
                        System.out.print("Elige una fila (0-3): ");
                        int fila = sn.nextInt();
                        if (fila >= 0 && fila < matriz.length) {
                            System.out.println("La suma de los valores de la fila " + fila + " es: " + sumaFila(matriz, fila));
                        } else {
                            System.out.println("Debe estar entre 0 y 3.");
                        }
                    } else {
                        System.out.println("Debes rellenar la matriz primero.");
                    }
                    break;
                case 3:
                    if (rellenado) {
                        System.out.print("Elige una columna (0-3): ");
                        int columna = sn.nextInt();
                        if (columna >= 0 && columna < matriz[0].length) {
                            System.out.println("La suma de los valores de la columna " + columna + " es: " + sumaColumna(matriz, columna));
                        } else {
                            System.out.println("Debe estar entre 0 y 3.");
                        }
                    } else {
                        System.out.println("Debes rellenar la matriz primero.");
                    }
                    break;
                case 4:
                    if (rellenado) {
                        System.out.println("La suma de la diagonal principal es: " + sumaDiagonalPrincipal(matriz));
                    } else {
                        System.out.println("Debes rellenar la matriz primero.");
                    }
                    break;
                case 5:
                    if (rellenado) {
                        System.out.println("La suma de la diagonal inversa es: " + sumaDiagonalInversa(matriz));
                    } else {
                        System.out.println("Debes rellenar la matriz primero.");
                    }
                    break;
                case 6:
                    if (rellenado) {
                        System.out.println("La media de los valores de la matriz es: " + calcularMedia(matriz));
                    } else {
                        System.out.println("Debes rellenar la matriz primero.");
                    }
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Tienes que meter un valor entre 1 y 7");
            }
        } while (!salir);

        System.out.println("FIN");
    }

    public static void rellenarMatriz(Scanner sn, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Escribe un número en la posición " + i + " " + j + ": ");
                matriz[i][j] = sn.nextInt();
            }
        }
    }

    public static int sumaFila(int[][] matriz, int fila) {
        int suma = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            suma += matriz[fila][j];
        }
        return suma;
    }

    public static int sumaColumna(int[][] matriz, int columna) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][columna];
        }
        return suma;
    }

    public static int sumaDiagonalPrincipal(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    public static int sumaDiagonalInversa(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][matriz.length - 1 - i];
        }
        return suma;
    }

    public static double calcularMedia(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[i][j];
            }
        }
        return (double) suma / (matriz.length * matriz[0].length);
    }
}
