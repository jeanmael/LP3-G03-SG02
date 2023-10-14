import java.util.ArrayList;

interface ImpactoEcológico {
    double obtenerImpactoEcológico();
}

class Edificio implements ImpactoEcológico {
    private double area;
    private int personas;

    public Edificio(double area, int personas) {
        this.area = area;
        this.personas = personas;
    }

    public double obtenerImpactoEcológico() {
        double datoActividad = (2 * area - personas) * 1.0; 
        double factorEmision = 0.5;
        return datoActividad * factorEmision;
    }
}

class Auto implements ImpactoEcológico {
    private double emisionesAnuales;

    public Auto(double emisionesAnuales) {
        this.emisionesAnuales = emisionesAnuales;
    }

    public double obtenerImpactoEcológico() {
        double datoActividad = emisionesAnuales * 1.0; 
        double factorEmision = 0.3; 
        return datoActividad * factorEmision;
    }
}

class Bicicleta implements ImpactoEcológico {
    private boolean electrica;

    public Bicicleta(boolean electrica) {
        this.electrica = electrica;
    }

    public double obtenerImpactoEcológico() {
        double datoActividad = electrica ? 1.0 : 0.0;
        double factorEmision = 0.05;
        return datoActividad * factorEmision;
    }
}

public class Main {
    public static void main(String[] args) {
        Edificio edificio = new Edificio(1000, 200); 
        Auto auto = new Auto(5000); 
        Bicicleta bicicleta = new Bicicleta(false); 

        ArrayList<ImpactoEcológico> lista = new ArrayList<>();
        lista.add(edificio);
        lista.add(auto);
        lista.add(bicicleta);

        for (ImpactoEcológico objeto : lista) {
            if (objeto instanceof Edificio) {
                System.out.println("Edificio - Área: 1000 m^2, Personas: 200");
            } else if (objeto instanceof Auto) {
                System.out.println("Auto - Emisiones anuales: 5000 kg CO2");
            } else if (objeto instanceof Bicicleta) {
                System.out.println("Bicicleta - No eléctrica");
            }
            double impactoEcológico = objeto.obtenerImpactoEcológico();
            System.out.println("Impacto Ecológico: " + impactoEcológico + " GEI");
            System.out.println("-------------------");
        }
    }
}
