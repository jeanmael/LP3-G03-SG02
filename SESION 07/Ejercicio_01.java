public class AccesoArreglo {

    public static void main(String[] args) {
        double[] v = new double[15];

        try {
            double resultado = acceso(v, 16);
            System.out.println("El valor en la posicion 16 es: " + resultado);
        } catch (MiExcepcion e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }

    public static double acceso(double[] v, int j) throws MiExcepcion {
        if (j >= 0 && j < v.length) {
            return v[j];
        } else {
            throw new MiExcepcion("El indice " + j + "no existe en el vector");
        }
    }

    static class MiExcepcion extends Exception {
        public MiExcepcion(String mensaje) {
            super(mensaje);
        }
    }
}

