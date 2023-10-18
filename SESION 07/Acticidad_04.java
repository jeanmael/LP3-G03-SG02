public class AppStack {
    public static void main(String[] args) {
        try {
            metodo1();
        } catch (Exception excepcion) {
            System.out.printf("%s%n", excepcion.getMessage());
            excepcion.printStackTrace();

            StackTraceElement[] itemRastreo = excepcion.getStackTrace();

            System.out.println("\nRastreo de la pila de getStackTrace:");
            System.out.println("Clase\tArchivo\tLínea\tMétodo");

            for (StackTraceElement item : itemRastreo) {
                System.out.printf("%s\t%s\t%s\t%s%n", item.getClassName(), item.getFileName(), item.getLineNumber(), item.getMethodName());
            }
        }
    }

    public static void metodo1() throws Exception {
        metodo2();
    }

    public static void metodo2() throws Exception {
        metodo3();
    }

    public static void metodo3() throws Exception {
        throw new Exception("La excepción se lanzó");
    }
}
