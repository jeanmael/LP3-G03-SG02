import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Copy {

    public static void main(String[] args) {
        String[] arrayStrings1 = {"uno", "dos", "tres"};
        String[] arrayStrings2 = {"dos", "tres", "cuatro"};

        Producto[] arrayProductos1 = {
                new Producto("P1", "Laptop", 1200.0),
                new Producto("P2", "Teléfono", 500.0),
        };
        Producto[] arrayProductos2 = {
                new Producto("P2", "Teléfono", 500.0),
                new Producto("P3", "Tablet", 300.0),
        };

        Persona[] arrayPersonas1 = {
                new Persona("12", "Juan", "A"),
                new Persona("34", "María", "B")
        };
        Persona[] arrayPersonas2 = {
                new Persona("34", "María", "B"),
                new Persona("56", "Carlos", "C")
        };

        System.out.println("Strings: " + Arrays.toString(copyArray(arrayStrings1, arrayStrings2)));
        System.out.println("Productos: " + Arrays.toString(copyArray(arrayProductos1, arrayProductos2)));
        System.out.println("Personas: " + Arrays.toString(copyArray(arrayPersonas1, arrayPersonas2)));
    }

    public static <T> T[] copyArray(T[] array1, T[] array2) {
        List<T> resultadoList = new ArrayList<>(Arrays.asList(array1));

        for (T element : array2) {
            if (!resultadoList.contains(element)) {
                resultadoList.add(element);
            }
        }

        return resultadoList.toArray(Arrays.copyOf(array1, resultadoList.size()));
    }
}

class Producto {
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return"Producto{" + "codigo='" + codigo + "', descripcion='" + descripcion + "', precio=" + precio + '}';
    }
}

class Persona {
    private String dni;
    private String nombre;
    private String direccion;

    public Persona(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni='" + dni + "', nombre='" + nombre + "', direccion='" + direccion + "'}";
    }
}
