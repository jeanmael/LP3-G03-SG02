import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arrayStrings1 = {"A", "B", "C"};
        String[] arrayStrings2 = {"B", "C", "D"};

        String[] resultadoStrings = copyArray(arrayStrings1, arrayStrings2);
        System.out.println(Arrays.toString(resultadoStrings));

        Producto[] arrayProductos1 = {
            new Producto("P001", "Laptop", 3400.0),
            new Producto("P002", "Iphone", 1200.0)
        };

        Producto[] arrayProductos2 = {
            new Producto("P001", "Laptop", 4200.0),
            new Producto("P003", "Tablet", 1000.0)
        };

        Producto[] resultadoProductos = copyArray(arrayProductos1, arrayProductos2);
        System.out.println(Arrays.toString(resultadoProductos));

        Persona[] arrayPersonas1 = {
            new Persona("73456895", "John Lennon", "Yanahuara"),
            new Persona("79458612", "George Harrison", "Cayma")
        };

        Persona[] arrayPersonas2 = {
            new Persona("73316549", "Paul McCartney", "Av. Ejercito"),
            new Persona("76458965", "Ringo", "Av. Prada")
        };

        Persona[] resultadoPersonas = copyArray(arrayPersonas1, arrayPersonas2);
        System.out.println(Arrays.toString(resultadoPersonas));
    }

    public static <T> T[] copyArray(T[] array1, T[] array2) {
        T[] combinedArray = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);

        int newSize = removeDuplicates(combinedArray);
        
        return Arrays.copyOf(combinedArray, newSize);
    }

    private static <T> int removeDuplicates(T[] array) {
        int newSize = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < newSize; j++) {
                if (array[i].equals(array[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                array[newSize++] = array[i];
            }
        }
        return newSize;
    }
}
