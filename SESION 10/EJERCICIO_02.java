public class IntercambioElementos {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        imprimirArray(intArray);

        intercambiarElementos(intArray, 1, 3);
        imprimirArray(intArray);

        String[] stringArray = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
        imprimirArray(stringArray);

        intercambiarElementos(stringArray, 0, 4);
        imprimirArray(stringArray);
    }

    public static <T> void intercambiarElementos(T[] array, int posicion1, int posicion2) {
        if (posicion1 < 0) {
            System.out.println("Posición 1 es inválida");
            return;
        }

        if (posicion1 >= array.length) {
            System.out.println("Posición 1 está fuera de rango");
            return;
        }

        if (posicion2 < 0) {
            System.out.println("Posición 2 es inválida");
            return;
        }

        if (posicion2 >= array.length) {
            System.out.println("Posición 2 está fuera de rango");
            return;
        }

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

