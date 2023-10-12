//
//CLASE PRINCIPAL PruebaInterfazPorPagar
//
public class PruebaInterfazPorPagar {
    public static void main(String[] args) {
        PorPagar[] objetosPorPagar = new PorPagar[5];

        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("56789", "llanta", 4, 79.95);
        objetosPorPagar[2] = new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        objetosPorPagar[3] = new EmpleadoAsalariado("Lisa", "Barnes", "888-88-8888", 1200.00);
        objetosPorPagar[4] = new Prestamo(36, 200.00);

        System.out.println("Facturas, Empleados y Prestamo procesados en forma polimórfica:\n");

        for (PorPagar porPagarActual : objetosPorPagar) {
            System.out.println(porPagarActual.toString());
            System.out.printf("Pago vencido: $%.2f\n\n", porPagarActual.obtenerMontoPago());
        }
    }
}


//
//clase Prestamo que implemente la interfaz PorPagar
//
public class Prestamo implements PorPagar {
    private int numeroDeCuotas;
    private double montoDeCuota;

    public Prestamo(int cuotas, double monto) {
        numeroDeCuotas = cuotas;
        montoDeCuota = monto;
    }

    public int obtenerNumeroDeCuotas() {
        return numeroDeCuotas;
    }

    public void establecerNumeroDeCuotas(int cuotas) {
        if (cuotas >= 0) {
            numeroDeCuotas = cuotas;
        } else {
            numeroDeCuotas = 0;
        }
    }

    public double obtenerMontoDeCuota() {
        return montoDeCuota;
    }

    public void establecerMontoDeCuota(double monto) {
        if (monto >= 0.0) {
            montoDeCuota = monto;
        } else {
            montoDeCuota = 0.0;
        }
    }

    @Override
    public double obtenerMontoPago() {
        return obtenerNumeroDeCuotas() * obtenerMontoDeCuota();
    }

    @Override
    public String toString() {
        return String.format("Prestamo:\nNúmero de Cuotas: %d\nMonto de Cuota: $%.2f\n",
                numeroDeCuotas, montoDeCuota);
    }
}

