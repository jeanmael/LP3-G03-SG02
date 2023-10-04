import java.util.Scanner;

public class ResumenVentas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] ventas = new double[4][5];

        for (int vendedor = 0; vendedor < 4; vendedor++) {
            for (int producto = 0; producto < 5; producto++) {
                System.out.print("Ingrese las ventas del vendedor " + (vendedor + 1) +
                                 " para el producto " + (producto + 1) + " del último mes: $");
                ventas[vendedor][producto] = sc.nextDouble();
            }
        }

        double[] ventasTotalesPorVendedor = new double[4];
        double[] ventasTotalesPorProducto = new double[5];

        for (int vendedor = 0; vendedor < 4; vendedor++) {
            for (int producto = 0; producto < 5; producto++) {
                ventasTotalesPorVendedor[vendedor] += ventas[vendedor][producto];
                ventasTotalesPorProducto[producto] += ventas[vendedor][producto];
            }
        }

        System.out.println("\nResumen de Ventas:");
        System.out.println("Vendedor | Producto 1 | Producto 2 | Producto 3 | Producto 4 | Producto 5 | Total");

        for (int vendedor = 0; vendedor < 4; vendedor++) {
            System.out.print("   " + (vendedor + 1) + "    |");

            for (int producto = 0; producto < 5; producto++) {
                System.out.printf(" $%.2f   |", ventas[vendedor][producto]);
            }

            System.out.printf(" $%.2f%n", ventasTotalesPorVendedor[vendedor]);
        }

        System.out.print("Total   |");

        for (int producto = 0; producto < 5; producto++) {
            System.out.printf(" $%.2f   |", ventasTotalesPorProducto[producto]);
        }

        double ventasTotales = 0;
        for (int vendedor = 0; vendedor < 4; vendedor++) {
            ventasTotales += ventasTotalesPorVendedor[vendedor];
        }
        System.out.printf(" $%.2f%n", ventasTotales);
    }
}
