import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba el nombre del archivo o directorio:");
        // crear objeto Path con base en la entrada del usuario
        Path ruta = Paths.get(sc.nextLine());

        try {
            if (Files.exists(ruta)) {
                // mostrar información de archivo (o directorio)
                System.out.printf("Nombre: %s%n", ruta.getFileName());
                System.out.printf("Es un directorio: %s%n", Files.isDirectory(ruta) ? "Sí" : "No");
                System.out.printf("Es una ruta absoluta: %s%n", ruta.isAbsolute() ? "Sí" : "No");
                System.out.printf("Fecha de última modificación: %s%n", Files.getLastModifiedTime(ruta));
                System.out.printf("Tamaño: %d bytes%n", Files.size(ruta));
                System.out.printf("Ruta: %s%n", ruta);
                System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

                if (Files.isDirectory(ruta)) {
                    System.out.println("Contenido del directorio:");
                    // objeto para iterar en el contenido de un directorio
                    try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                        for (Path p : flujoDirectorio) {
                            System.out.println(p);
                        }
                    }
                }
            } else {
                System.out.printf("%s no existe%n", ruta);
            }
        } catch (IOException e) {
            System.out.println("Error al acceder al archivo o directorio: " + e.getMessage());
        }
    }
}

