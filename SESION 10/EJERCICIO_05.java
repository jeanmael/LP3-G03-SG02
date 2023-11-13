public class BusquedaUtil {
    public static <T extends Number> int buscarElementoNumerico(T[] arreglo, T elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(elemento)) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Integer[] arregloEnteros = {1, 2, 3, 4, 5};
        int posicionEntero = buscarElementoNumerico(arregloEnteros, 3);
        System.out.println("Posicion del elemento en el arreglo de enteros: " + posicionEntero);

        Double[] arregloDoubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        int posicionDouble = buscarElementoNumerico(arregloDoubles, 4.4);
        System.out.println("Posicion del elemento en el arreglo de doubles: " + posicionDouble);

    }
}
