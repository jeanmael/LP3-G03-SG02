public class EjemploCatchMultiple {
    public static void main(String[] args) {
        try {
            int[] numeros = {1, 2, 3};
            int indice = 4;
            int resultado = numeros[indice] / 0;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Se ha producido una excepción: " + e.getMessage());
            System.out.println("Manejando la excepción de manera genérica.");
        }
    }
}
