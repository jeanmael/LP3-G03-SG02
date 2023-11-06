import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Numero: " + numero + ", Nombre: " + nombre + ", Sueldo: " + sueldo;
    }
}

class GestorEmpleados {
    private static final String ARCHIVO_EMPLEADOS = "empleados.dat";
    private List<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
        cargarEmpleados();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        guardarEmpleados();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    private void cargarEmpleados() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO_EMPLEADOS))) {
            empleados = (List<Empleado>) entrada.readObject();
        } catch (FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar empleados: " + e.getMessage());
        }
    }

    private void guardarEmpleados() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EMPLEADOS))) {
            salida.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }
}

public class VentanaPrincipal {
    private JFrame frame;
    private JTextField txtNumero, txtNombre, txtSueldo;
    private GestorEmpleados gestor;

    public VentanaPrincipal() {
        frame = new JFrame("Gestion de Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        gestor = new GestorEmpleados();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        txtNumero = new JTextField(10);
        txtNombre = new JTextField(10);
        txtSueldo = new JTextField(10);

        JButton btnAgregar = new JButton("Agregar Empleado");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    String nombre = txtNombre.getText();
                    double sueldo = Double.parseDouble(txtSueldo.getText());
                    Empleado empleado = new Empleado(numero, nombre, sueldo);
                    gestor.agregarEmpleado(empleado);
                    JOptionPane.showMessageDialog(frame, "Empleado agregado correctamente");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese datos validos");
                }
            }
        });

        JButton btnMostrar = new JButton("Mostrar Reporte");
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReporte();
            }
        });

        panel.add(new JLabel("Numero:"));
        panel.add(txtNumero);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Sueldo:"));
        panel.add(txtSueldo);
        panel.add(btnAgregar);
        panel.add(btnMostrar);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void mostrarReporte() {
        StringBuilder reporte = new StringBuilder("Reporte de Empleados:\n");
        for (Empleado empleado : gestor.getEmpleados()) {
            reporte.append(empleado.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(frame, reporte.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}
