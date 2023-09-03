public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    private String color;
    private static String[] colores = {"verde", "amarillo", "rojo"};
    private static int indiceColor = 0;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;
        this.color = asignarColor();
    }

    public Rectangulo(double base, double altura) {
        this.esquina1 = new Coordenada(0, 0);
        this.esquina2 = new Coordenada(base, altura);
        this.color = asignarColor();
    }

    public Coordenada getEsquina1() {
        return esquina1;
    }

    public void setEsquina1(Coordenada c) {
        esquina1 = c;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    public void setEsquina2(Coordenada c) {
        esquina2 = c;
    }

    public String getColor() {
        return color;
    }

    private String asignarColor() {
        String colorAsignado = colores[indiceColor];
        indiceColor = (indiceColor + 1) % colores.length;
        return colorAsignado;
    }

    public double calcularArea() {
        double base = Math.abs(esquina2.getX() - esquina1.getX());
        double altura = Math.abs(esquina2.getY() - esquina1.getY());
        return base * altura;
    }

    public double calcularPerimetro() {
        double base = Math.abs(esquina2.getX() - esquina1.getX());
        double altura = Math.abs(esquina2.getY() - esquina1.getY());
        return 2 * (base + altura);
    }

    public void moverX(int puntos) {
        esquina1.setX(esquina1.getX() + puntos);
        esquina2.setX(esquina2.getX() + puntos);
    }

    public void moverY(int puntos) {
        esquina1.setY(esquina1.getY() + puntos);
        esquina2.setY(esquina2.getY() + puntos);
    }

    @Override
    public String toString() {
        return "Rectángulo [Esquina1: " + esquina1 + ", Esquina2: " + esquina2 + ", Color: " + color + "]";
    }
}
