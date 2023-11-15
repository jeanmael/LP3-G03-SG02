public class ComparacionGenerica {

    public static void main(String[] args) {
        System.out.println(isEqualTo(5, 5));           //Integer
        System.out.println(isEqualTo(3.14, 3.14));     //Double
        System.out.println(isEqualTo("Hola", "Holá")); //String
        System.out.println(isEqualTo(2.71, 3.14));      //Double
        System.out.println(isEqualTo("Hola", "Mundo")); //String
    }

    public static <T> boolean isEqualTo(T obj1, T obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }

        if (obj1 == null || obj2 == null) {
            return false;
        }

        return obj1.equals(obj2);
    }
}

