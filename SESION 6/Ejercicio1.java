abstract class Figura {
    abstract void obtenerDescripcion();
}
abstract class FiguraBidimensional extends Figura {
    abstract double obtenerArea();
}
public abstract class FiguraTridimensional extends Figura {
    abstract double obtenerArea();
    abstract double obtenerVolumen();
}

public class Circulo extends FiguraBidimensional {
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    void obtenerDescripcion() {
        System.out.println("Circulo con radio: " + radio);
    }

    @Override
    double obtenerArea() {
        return Math.PI * radio * radio;
    }
}

public class Cuadrado extends FiguraBidimensional {
    double lado;
    
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    @Override
    void obtenerDescripcion() {
        System.out.println("Cuadrado con lado: " + lado);
    }
    
    @Override
    double obtenerArea() {
        return lado * lado;
    }
}

public class Triangulo extends FiguraBidimensional {
    double base;
    double altura;
    
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    void obtenerDescripcion() {
        System.out.println("Triangulo con base: " + base + " y altura: " + altura);
    }
    
    @Override
    double obtenerArea() {
        return 0.5 * base * altura;
    }
}
public class Esfera extends FiguraTridimensional {
    double radio;
    
    public Esfera(double radio) {
        this.radio = radio;
    }
    
    @Override
    void obtenerDescripcion() {
        System.out.println("Esfera con radio: " + radio);
    }
    
    @Override
    double obtenerArea() {
        return 4 * Math.PI * radio * radio;
    }
    
    @Override
    double obtenerVolumen() {
        return (4.0 / 3.0) * Math.PI * radio * radio * radio;
    }
}

public class Cubo extends FiguraTridimensional {
    double lado;
    
    public Cubo(double lado) {
        this.lado = lado;
    }
    
    @Override
    void obtenerDescripcion() {
        System.out.println("Cubo con lado: " + lado);
    }
    
    @Override
    double obtenerArea() {
        return 6 * lado * lado;
    }
    
    @Override
    double obtenerVolumen() {
        return lado * lado * lado;
    }
}

public class Tetraedro extends FiguraTridimensional {
    double arista;
    
    public Tetraedro(double arista) {
        this.arista = arista;
    }
    
    @Override
    void obtenerDescripcion() {
        System.out.println("Tetraedro con arista: " + arista);
    }
    
    @Override
    double obtenerArea() {
        return Math.sqrt(3) * arista * arista;
    }
    
    @Override
    double obtenerVolumen() {
        return (Math.sqrt(2) / 12) * arista * arista * arista;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Figura[] figuras = new Figura[6];

        System.out.print("Ingrese el radio del circulo: ");
        double radioCirculo = scanner.nextDouble();
        figuras[0] = new Circulo(radioCirculo);

        System.out.print("Ingrese el lado del cuadrado: ");
        double ladoCuadrado = scanner.nextDouble();
        figuras[1] = new Cuadrado(ladoCuadrado);

        System.out.print("Ingrese la base del triangulo: ");
        double baseTriangulo = scanner.nextDouble();
        System.out.print("Ingrese la altura del triangulo: ");
        double alturaTriangulo = scanner.nextDouble();
        figuras[2] = new Triangulo(baseTriangulo, alturaTriangulo);

        System.out.print("Ingrese el radio de la esfera: ");
        double radioEsfera = scanner.nextDouble();
        figuras[3] = new Esfera(radioEsfera);

        System.out.print("Ingrese el lado del cubo: ");
        double ladoCubo = scanner.nextDouble();
        figuras[4] = new Cubo(ladoCubo);

        System.out.print("Ingrese la arista del tetraedro: ");
        double aristaTetraedro = scanner.nextDouble();
        figuras[5] = new Tetraedro(aristaTetraedro);

        for (Figura figura : figuras) {
            figura.obtenerDescripcion();
            if (figura instanceof FiguraBidimensional) {
                FiguraBidimensional bidimensional = (FiguraBidimensional) figura;
                System.out.println("Area: " + bidimensional.obtenerArea());
            } else if (figura instanceof FiguraTridimensional) {
                FiguraTridimensional tridimensional = (FiguraTridimensional) figura;
                System.out.println("Area superficial: " + tridimensional.obtenerArea());
                System.out.println("Volumen: " + tridimensional.obtenerVolumen());
            }
            System.out.println("-------------");
        }

        scanner.close();
    }
}
