public class Persona implements Comparable<Persona> {
    private String nombres;

    public Persona(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombres='" + nombres + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona otraPersona) {
        return this.nombres.compareTo(otraPersona.getNombres());
    }
}

public class Main {
    public static void main(String[] args) {
        Integer minInt = minimo(3, 1, 5, 2);
        Double minDouble = minimo(3.3, 1.1, 5.5, 2.2);
        String minString = minimo("platano", "manzana", "naranja", "pera");
        Persona minPersona = minimo(
                new Persona("John"),
                new Persona("Paul"),
                new Persona("George"),
                new Persona("Ringo")
        );

        System.out.println("Mínimo Integer: " + minInt);
        System.out.println("Mínimo Double: " + minDouble);
        System.out.println("Mínimo String: " + minString);
        System.out.println("Mínimo Persona: " + minPersona);
    }

    public static <T extends Comparable<T>> T minimo(T a, T b, T c, T d) {
        T min = a;
        if (b.compareTo(min) < 0) min = b;
        if (c.compareTo(min) < 0) min = c;
        if (d.compareTo(min) < 0) min = d;
        return min;
    }
}
