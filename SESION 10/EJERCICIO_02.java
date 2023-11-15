import java.util.Scanner;

public class IntercambioElementos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] intArray = {1, 2, 3, 4, 5};
        imprimirArray(intArray);

        System.out.println("Primera posición ");
        int posicion1 = scanner.nextInt();

        System.out.println("Segunda posición ");
        int posicion2 = scanner.nextInt();

        intercambiarElementos(intArray, posicion1, posicion2);
        imprimirArray(intArray);

        String[] stringArray = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
        imprimirArray(stringArray);

        System.out.println("Primera posición ");
        posicion1 = scanner.nextInt();

        System.out.println("Segunda posición ");
        posicion2 = scanner.nextInt();

        intercambiarElementos(stringArray, posicion1, posicion2);
        imprimirArray(stringArray);

        scanner.close();
    }

    public static <T> void intercambiarElementos(T[] array, int posicion1, int posicion2) {
        T temp = array[posicion1];
        array[posicion1] = array[posicion2];
        array[posicion2] = temp;
    }

    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}

