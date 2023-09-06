import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int fila = 0, columna = 0, principal = 0, inversa = 0, sumaMedia = 0, media = 0;

        System.out.println("Introduce los valores de la matriz: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" - Fila " + (i + 1) + " Columna " + (j + 1) + ": ");
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        System.out.println("Introduce la fila que quieras sumar: ");
        fila = sc.nextInt() - 1; 
        int sumaFila = 0;
        for (int j = 0; j < 4; j++) {
            sumaFila += matriz[fila][j];
        }
        System.out.println("El resultado de la FILA es: " + sumaFila);

        System.out.println();

        System.out.println("Introduce la columna que quieras sumar: ");
        columna = sc.nextInt() - 1; 
        int sumaColumna = 0;
        for (int i = 0; i < 4; i++) {
            sumaColumna += matriz[i][columna];
        }
        System.out.println("El resultado de la COLUMNA es: " + sumaColumna);

        System.out.println();

      for (int i = 0; i < 4; i++) {
            principal += matriz[i][i];
        }
        System.out.println("El resultado de la DIAGONAL PRINCIPAL es: " + principal);

        System.out.println();

        for (int i = 0; i < 4; i++) {
            inversa += matriz[i][3 - i]; 
        }
        System.out.println("El resultado de la DIAGONAL INVERSA es: " + inversa);

        System.out.println();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sumaMedia += matriz[i][j];
            }
        }
        media = sumaMedia / 16;
        System.out.println("El resultado de la MEDIA es: " + media);
    }
}
