public abstract class FiguraGeometrica {
    private String nombre;

    public FiguraGeometrica(String nombreFigura) {
        this.nombre = nombreFigura;
    }

    abstract public double area();

    final public boolean mayorQue(FiguraGeometrica otra) {
        return this.area() > otra.area();
    }

    @Override
    final public String toString() {
        return this.nombre + " con area " + this.area();
    }
}

public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double largo, double ancho) {
        super("Rectangulo");
        this.base = largo;
        this.altura = ancho;
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }
}

public class TestAbstracto {
    public static void main(String[] args) {
        Rectangulo r1;
        r1 = new Rectangulo(12.5, 23.7);
        System.out.println("Area de r1 = " + r1.area());

        Rectangulo r2 = new Rectangulo(8.6, 33.1);
        System.out.println("Area de r2 = " + r2.toString());

        if (r1.mayorQue(r2))
            System.out.println("El rectángulo de mayor área es r1");
        else
            System.out.println("El rectángulo de mayor área es r2");
    }
}
