public class App {

    public static void main(String[] args) throws Exception {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'O', 'L', 'A'};

        System.out.printf("Array integerArray contiene:%n");
        imprimirArray(intArray, 6, 7);
        System.out.printf("%nArray doubleArray contiene:%n");
        imprimirArray(doubleArray, 8, 9);
        System.out.printf("%nArray charArray contiene:%n");
        imprimirArray(charArray, 5, 7);
    }

    public static <T> void imprimirArray(T[] inputArray, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
        if (limiteInferior < 0 || limiteInferior >= inputArray.length) {
            throw new LimiteInvalidoException("El límite inferior es inválido");
        }
        if (limiteSuperior < limiteInferior || limiteSuperior >= inputArray.length) {
            throw new LimiteInvalidoException("El límite superior es inválido");
        }

        int numeroElementos = limiteSuperior - limiteInferior + 1;
        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            System.out.printf("%s ", inputArray[i]);
        }
        System.out.println();
        System.out.printf("Número de elementos en el rango: %d%n", numeroElementos);
    }

    public static class LimiteInvalidoException extends Exception {

        public LimiteInvalidoException(String mensaje) {
            super(mensaje);
        }
    }
}
