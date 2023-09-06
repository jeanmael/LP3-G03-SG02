import java.util.Random;

public class EvaluacionCrediticia {
    public static void main(String[] args) {
        int totalPersonas = 8;
        int hombres = 0;
        int mujeres = 0;
        int hombresTrabajan = 0;
        int mujeresTrabajan = 0;
        int sueldoHombres = 0;
        int sueldoMujeres = 0;

        Random random = new Random();
        for (int i = 0; i < totalPersonas; i++) {
            int sexo = random.nextInt(2) + 1; 
            int trabaja = random.nextInt(2) + 1; 
            int sueldo = 0;

            if (trabaja == 1) {
                sueldo = random.nextInt(2051) + 950; 
            }

            if (sexo == 1) {
                hombres++;
                sueldoHombres += sueldo;
                if (trabaja == 1) {
                    hombresTrabajan++;
                }
            } else {
                mujeres++;
                sueldoMujeres += sueldo;
                if (trabaja == 1) {
                    mujeresTrabajan++;
                }
            }
        }

        double porcentajeHombres = (double) hombres / totalPersonas * 100;
        double porcentajeMujeres = (double) mujeres / totalPersonas * 100;
        double porcentajeHombresTrabajan = (double) hombresTrabajan / hombres * 100;
        double porcentajeMujeresTrabajan = (double) mujeresTrabajan / mujeres * 100;
        double sueldoPromedioHombres = (double) sueldoHombres / hombresTrabajan;
        double sueldoPromedioMujeres = (double) sueldoMujeres / mujeresTrabajan;

        System.out.println("Porcentaje de hombres: " + porcentajeHombres + "%");
        System.out.println("Porcentaje de mujeres: " + porcentajeMujeres + "%");
        System.out.println("Porcentaje de hombres que trabajan: " + porcentajeHombresTrabajan + "%");
        System.out.println("Porcentaje de mujeres que trabajan: " + porcentajeMujeresTrabajan + "%");
        System.out.println("Sueldo promedio de hombres que trabajan: $" + sueldoPromedioHombres);
        System.out.println("Sueldo promedio de mujeres que trabajan: $" + sueldoPromedioMujeres);
    }
}
