public class EjemploAserciones {
    public static void main(String[] args) {
        int x = 10;
        assert x > 0 : "x no es positivo";
        System.out.println("Después de la aserción");
    }
}
