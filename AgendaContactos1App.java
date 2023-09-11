import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContactos1App {
    private static ArrayList<Contacto> agenda = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\nMENU DE OPCIONES");
            System.out.println("1) Añadir contacto");
            System.out.println("2) Buscar contacto");
            System.out.println("3) Modificar contacto");
            System.out.println("4) Borrar contacto");
            System.out.println("5) Eliminar contacto");
            System.out.println("6) Mostrar contactos");
            System.out.println("7) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    modificarContacto();
                    break;
                case 4:
                    borrarContacto();
                    break;
                case 5:
                    eliminarContacto();
                    break;
                case 6:
                    mostrarContactos();
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 7);
    }

    private static void agregarContacto() {
        scanner.nextLine(); // Consumir la nueva línea pendiente
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nombre, telefono, direccion);
        agenda.add(nuevoContacto);

        System.out.println("Contacto agregado con éxito.");
    }

    private static void buscarContacto() {
        scanner.nextLine(); // Consumir la nueva línea pendiente
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombreBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Contacto encontrado:");
                System.out.println("Nombre: " + contacto.getNombre());
                System.out.println("Teléfono: " + contacto.getTelefono());
                System.out.println("Dirección: " + contacto.getDireccion());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void modificarContacto() {
        scanner.nextLine(); // Consumir la nueva línea pendiente
        System.out.print("Ingrese el nombre del contacto a modificar: ");
        String nombreBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Contacto encontrado. Ingrese los nuevos datos:");

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                contacto.setNombre(nuevoNombre);

                System.out.print("Nuevo teléfono: ");
                String nuevoTelefono = scanner.nextLine();
                contacto.setTelefono(nuevoTelefono);

                System.out.print("Nueva dirección: ");
                String nuevaDireccion = scanner.nextLine();
                contacto.setDireccion(nuevaDireccion);

                System.out.println("Contacto modificado con éxito.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void borrarContacto() {
        scanner.nextLine(); // Consumir la nueva línea pendiente
        System.out.print("Ingrese el nombre del contacto a borrar: ");
        String nombreBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                agenda.remove(contacto);
                System.out.println("Contacto borrado con éxito.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void eliminarContacto() {
        agenda.clear();
        System.out.println("Todos los contactos han sido eliminados.");
    }

    private static void mostrarContactos() {
        System.out.println("Lista de contactos:");

        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Contacto contacto : agenda) {
                System.out.println("Nombre: " + contacto.getNombre());
                System.out.println("Teléfono: " + contacto.getTelefono());
                System.out.println("Dirección: " + contacto.getDireccion());
                System.out.println("------------------------");
            }
        }
    }
}
