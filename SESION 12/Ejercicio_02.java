import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroDireccionesGUI extends JFrame {
    private JTextField txtID, txtNombre, txtApellido, txtEmail, txtTelefono, txtBuscarApellido;
    private JTextArea txtAreaResultados;
    private static final String URL = "jdbc:mysql://localhost:3306/Ejercicio2";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public LibroDireccionesGUI() {
        setTitle("Libro de Direcciones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Código para la conexión a la base de datos
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Elementos GUI
        JLabel lblID = new JLabel("Nro ID:");
        txtID = new JTextField();
        add(lblID);
        add(txtID);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        add(lblNombre);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField();
        add(lblApellido);
        add(txtApellido);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        add(lblEmail);
        add(txtEmail);

        JLabel lblTelefono = new JLabel("Nro de Telefono:");
        txtTelefono = new JTextField();
        add(lblTelefono);
        add(txtTelefono);

        JButton btnMostrarEntradas = new JButton("Mostrar todas las entradas");
        btnMostrarEntradas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodasLasEntradas();
            }
        });
        add(btnMostrarEntradas);

        JButton btnInsertarEntrada = new JButton("Insertar nueva entrada");
        btnInsertarEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarNuevaEntrada();
            }
        });
        add(btnInsertarEntrada);

        txtAreaResultados = new JTextArea();
        add(txtAreaResultados);

        setVisible(true);
    }

    private void mostrarTodasLasEntradas() {
        txtAreaResultados.setText("");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM personas");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                txtAreaResultados.append(id + "\t" + nombre + "\t" + apellido + "\t" + email + "\t" + telefono + "\n");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al recuperar las entradas de la DB", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertarNuevaEntrada() {
        int id = Integer.parseInt(txtID.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String email = txtEmail.getText();
        String telefono = txtTelefono.getText();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO personas VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, email);
            statement.setString(5, telefono);
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(this, "Entrada correcta");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "ERR0R", "Error", JOptionPane.ERROR_MESSAGE);
        }
        clearTextFields();
    }

    private void clearTextFields() {
        txtID.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibroDireccionesGUI();
            }
        });
    }
}


