public class AppMiExcepcion {
    public static void main(String[] args) {
    }

    public static void validaPropia(int 15) {
        try {
            minimo(n);
            System.out.println(n + " es mayor a 10");
        } catch (MiExcepcion e) {
            System.out.println("No me sirve ese número");
        }
    }

    public static void minimo(int numero) throws MiExcepcion {
        if (numero <= 10) {
            throw new MiExcepcion("Necesito un número mayor a 10");
        }
    }
}
