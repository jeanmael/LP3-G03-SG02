import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Copy {

    public static void main(String[] args) {
        String[] arrayStrings1 = {"uno", "dos", "tres"};
        String[] arrayStrings2 = {"dos", "tres", "cuatro"};

        Producto[] arrayProductos1 = {
                new Producto("P001", "Laptop", 1200.0),
                new Producto("P002", "Teléfono", 500.0),
        };
        Producto[] arrayProductos2 = {
                new Producto("P002", "Teléfono", 500.0),
                new Producto("P003", "Tablet", 300.0),
        };

        Persona[] arrayPersonas1 = {
                new Persona("123", "Juan", "Calle A"),
                new Persona("456", "María", "Calle B")
        };
        Persona[] arrayPersonas2 = {
                new Persona("456", "María", "Calle B"),
                new Persona("789", "Carlos", "Calle C")
        };

        System.out.println("Strings: " + Arrays.toString(copyArray(arrayStrings1, arrayStrings2)));
        System.out.println("Productos: " + Arrays.toString(copyArray(arrayProductos1, arrayProductos2)));
        System.out.println("Personas: " + Arrays.toString(copyArray(arrayPersonas1, arrayPersonas2)));
    }

    public static <T> T[] copyArray(T[] array1, T[] array2) {
        List<T> resultadoList = new ArrayList<>(Arrays.asList(array1));
        resultadoList.addAll(Arrays.asList(array2));
        return resultadoList.toArray(Arrays.copyOf(array1, 0));
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
