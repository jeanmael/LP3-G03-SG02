//
//Interfaz PorPagar
//
package com.mycompany.porpagar;

/**
 *
 * @author User
 */
public interface PorPagar {
    double obtenerMontoPago(); //Calcula el Pago; no hay implementacion
} //fin de la interfaz PorPagar


//
//clase Factura que implementa PorPagar. 
//
public class Factura implements PorPagar{
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    public Factura(String pieza, String descripcion, int cuenta, double precio) {
        numeroPieza = pieza;
        descripcionPieza = descripcion;
        establecerCantidad(cuenta); // valida y almacena la cantidad
        establecerPrecioPorArticulo(precio); // valida y almacena el precio por argumento
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    public void establecerCantidad(int cuenta) {
        if (cuenta >= 0) {
            cantidad = cuenta;
        } else {
            cantidad = 0;
        }
    }

    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void establecerPrecioPorArticulo(double precio) {
        if (precio >= 0.0) {
            precioPorArticulo = precio;
        } else {
            precioPorArticulo = 0.0;
        }
    }

    @Override
    public double obtenerMontoPago() {
        return obtenerCantidad() * obtenerPrecioPorArticulo();
    }

    @Override
    public String toString() {
        return String.format("Factura: %s\nDescripción: %s\nCantidad: %d\nPrecio por Artículo: $%.2f\n",
                numeroPieza, descripcionPieza, cantidad, precioPorArticulo);
    }
}

//
//superclase abstracta Empleado que implementa PorPagar
//
public abstract class Empleado implements PorPagar{
    private String primerNombre;
    private String apellidoPaterno;
    private String numeroSeguroSocial;

    public Empleado(String nombre, String apellido, String nss) {
        primerNombre = nombre;
        apellidoPaterno = apellido;
        numeroSeguroSocial = nss;
    }
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public String obtenerNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    @Override
    public double obtenerMontoPago() {
        return 0; // Método abstracto, pero debe implementarse en las subclases.
    }

    @Override
    public String toString() {
        return String.format("Empleado: %s %s\nNúmero de Seguro Social: %s\n", primerNombre, apellidoPaterno, numeroSeguroSocial);
    }
}



//
//clase EmpleadoAsalariado que extiende a Empleado e implementa a PorPagar
//
public class EmpleadoAsalariado extends Empleado{
    private double salarioSemanal;

    public EmpleadoAsalariado(String nombre, String apellido, String nss, double salario) {
        super(nombre, apellido, nss);
        establecerSalarioSemanal(salario);
    }

    public double obtenerSalarioSemanal() {
        return salarioSemanal;
    }

    public void establecerSalarioSemanal(double salario) {
        if (salario >= 0.0) {
            salarioSemanal = salario;
        } else {
            salarioSemanal = 0.0;
        }
    }

    @Override
    public double obtenerMontoPago() {
        return obtenerSalarioSemanal();
    }

    @Override
    public String toString() {
        return String.format("Empleado asalariado: %s %s\nNúmero de Seguro Social: %s\nSalario semanal: $%.2f\n",
                obtenerPrimerNombre(), obtenerApellidoPaterno(), obtenerNumeroSeguroSocial(), salarioSemanal);
    }
}



//
//clase principal PruebaInterfazPorPagar
//
public class PruebaInterfazPorPagar {
    public static void main(String[] args) {
        PorPagar[] objetosPorPagar = new PorPagar[4];

        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("56789", "llanta", 4, 79.95);
        objetosPorPagar[2] = new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        objetosPorPagar[3] = new EmpleadoAsalariado("Lisa", "Barnes", "888-88-8888", 1200.00);

        System.out.println("Facturas y Empleados procesados en forma polimórfica:\n");

        for (PorPagar porPagarActual : objetosPorPagar) {
            System.out.println(porPagarActual.toString());
            System.out.printf("Pago vencido: $%.2f\n\n", porPagarActual.obtenerMontoPago());
        }
    }
}



//
//clase Prestamo que implemente la interfaz PorPagar
//
