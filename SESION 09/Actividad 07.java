import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.nio.file.*;
import java.io.IOException;
import java.util.Formatter;

public class DemoJFileChooser extends JFrame {

    private final JTextArea areaSalida;

    public DemoJFileChooser() {
        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida));

        try {
            analizarRuta();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analizarRuta() throws IOException {
        Path ruta = obtenerRutaArchivoDirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();

            builder.append(String.format("Nombre del archivo o directorio: %s%n", ruta.getFileName()));
            builder.append(String.format("Es un directorio: %b%n", Files.isDirectory(ruta)));
            builder.append(String.format("Es una ruta absoluta: %b%n", ruta.isAbsolute()));
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamaño: %d bytes%n", Files.size(ruta)));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) {
                builder.append("Contenido del directorio:\n");

                try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                    for (Path p : flujoDirectorio) {
                        builder.append(String.format("%s%n", p.getFileName()));
                    }
                }
            }

            areaSalida.setText(builder.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un archivo o directorio válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int resultado = selectorArchivos.showOpenDialog(this);

        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        return selectorArchivos.getSelectedFile().toPath();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DemoJFileChooser aplicacion = new DemoJFileChooser();
            aplicacion.setSize(400, 400);
            aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aplicacion.setVisible(true);
        });
    }
}

