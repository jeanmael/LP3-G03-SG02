public class App {
    public static void main(String[] args) {
        String[] stringArray = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho"};
        System.out.printf("Array de cadenas contiene:%n");
        imprimirArray(stringArray);
    }

    // Sobrecarga 
    public static void imprimirArray(String[] stringArray) {
        int columnas = 4;
        for (int i = 0; i < stringArray.length; i++) {
            System.out.printf("%-10s", stringArray[i]);
            if ((i + 1) % columnas == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

