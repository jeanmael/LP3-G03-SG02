//CLASE DICCIONARIO
//CLASE DICCIONARIO
package com.mycompany.principal;

import java.util.ArrayList;

public class Diccionario<K, V> {
    private ArrayList<Par<K, V>> pares;

    public Diccionario() {
        this.pares = new ArrayList<>();
    }

    public void agregar(K clave, V valor) {
        Par<K, V> par = new Par<>(clave, valor);
        pares.add(par);
    }

    public boolean eliminar(K clave) {
        Par<K, V> parAEliminar = null;

        for (Par<K, V> par : pares) {
            if (par.getClave().equals(clave)) {
                parAEliminar = par;
                break;
            }
        }

        if (parAEliminar != null) {
            pares.remove(parAEliminar);
            return true;
        }

        return false;
    }

    public V obtenerValor(K clave) throws ObjetoNoExiste {
        for (Par<K, V> par : pares) {
            if (par.getClave().equals(clave)) {
                return par.getValor();
            }
        }

        throw new ObjetoNoExiste("El objeto con clave '" + clave + "' no existe en el diccionario");
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        for (Par<K, V> par : pares) {
            resultado.append(par).append("\n");
        }

        return resultado.toString();
    }

    private static class Par<K, V> {
        private K clave;
        private V valor;

        public Par(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public K getClave() {
            return clave;
        }

        public V getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return "(" + clave + ", " + valor + ")";
        }
    }
}



//CLASE CONTACTO
//CLASE CONTACTO
package com.mycompany.principal;

import java.util.Scanner;

public class ContactsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diccionario<String, DatosPersona> contactosDiccionario = new Diccionario<>();

        while (true) {
            System.out.println("Menú de opciones para gestionar contactos:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Obtener datos de contacto por DNI");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el DNI del contacto: ");
                    String dni = scanner.nextLine();

                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();

                    DatosPersona datosPersona = new DatosPersona(nombre, telefono);
                    contactosDiccionario.agregar(dni, datosPersona);
                    System.out.println("Contacto agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el DNI del contacto a eliminar: ");
                    String dniEliminar = scanner.nextLine();

                    boolean resultadoEliminar = contactosDiccionario.eliminar(dniEliminar);
                    if (resultadoEliminar) {
                        System.out.println("Contacto eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró el contacto con ese DNI.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el DNI del contacto a obtener: ");
                    String dniObtener = scanner.nextLine();

                    try {
                        DatosPersona datosObtenidos = contactosDiccionario.obtenerValor(dniObtener);
                        System.out.println("Datos del contacto con DNI '" + dniObtener + "':\n" + datosObtenidos);
                    } catch (ObjetoNoExiste e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Todos los contactos:");
                    System.out.println(contactosDiccionario);
                    break;

                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 5.");
            }
        }
    }
}


//CLASE PRINCIPAL
//CLASE PRINCIPAL
package com.mycompany.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diccionario<String, Integer> diccionario = new Diccionario<>();

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar par ordenado");
            System.out.println("2. Eliminar par ordenado");
            System.out.println("3. Obtener valor por clave");
            System.out.println("4. Mostrar todos los pares ordenados");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    String clave = scanner.nextLine();

                    System.out.print("Ingrese el valor (entero): ");
                    int valor = scanner.nextInt();
                    scanner.nextLine();

                    diccionario.agregar(clave, valor);
                    System.out.println("Par ordenado agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese la clave del par ordenado a eliminar: ");
                    String claveEliminar = scanner.nextLine();

                    boolean resultadoEliminar = diccionario.eliminar(claveEliminar);
                    if (resultadoEliminar) {
                        System.out.println("Par ordenado eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró el par ordenado con esa clave.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave del par ordenado a obtener: ");
                    String claveObtener = scanner.nextLine();

                    try {
                        int valorObtenido = diccionario.obtenerValor(claveObtener);
                        System.out.println("Valor del par ordenado con clave '" + claveObtener + "': " + valorObtenido);
                    } catch (ObjetoNoExiste e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Todos los pares ordenados:");
                    System.out.println(diccionario);
                    break;

                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 5.");
            }
        }
    }
}

class ObjetoNoExiste extends Exception {
    public ObjetoNoExiste(String mensaje) {
        super(mensaje);
    }
}



//CLASE DATOS PERSONA
//CLASE DATOS PERSONA
package com.mycompany.principal;

public class DatosPersona {
    private String nombre;
    private String telefono;

    public DatosPersona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTeléfono: " + telefono;
    }
}


