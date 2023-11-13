public class Persona {
    private String dni;
    private String nombres;
    private String direccion;

    public Persona(String dni, String nombres, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombres='" + nombres + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'O', 'L', 'A'};
        Float[] floatArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        Boolean[] boolArray = {true, false, true};
        Persona[] personaArray = {
                new Persona("75777263", "Paul McCartney", "Av. Ejercito"),
                new Persona("73587962", "Jhon Lennon", "Yanahuara")
        };

        System.out.println("Array intArray contiene:");
        imprimirArray(intArray);

        System.out.println("\nArray doubleArray contiene:");
        imprimirArray(doubleArray);

        System.out.println("\nArray charArray contiene:");
        imprimirArray(charArray);

        System.out.println("\nArray floatArray contiene:");
        imprimirArray(floatArray);

        System.out.println("\nArray boolArray contiene:");
        imprimirArray(boolArray);

        System.out.println("\nArray personaArray contiene:");
        imprimirArray(personaArray);
    }

    public static <T> void imprimirArray(T[] inputArray) {
        for (T elemento : inputArray) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }
}
