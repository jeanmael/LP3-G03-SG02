package EJERCICIOS.Ejercicio1;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SQLQuerys {
    private JFrame frame;
    private JTable table;
    private JTextField sqlTextField;
    private JTextField filterTextField;
    private JButton submitButton;
    private Connection conn;

    public SQLQuerys() {
        try {
            String url = "jdbc:mysql://localhost:3306/personas";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            createUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createUI() {
        frame = new JFrame("Displaying Query Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        sqlTextField = new JTextField();
        filterTextField = new JTextField();
        submitButton = new JButton("Submit Query");
        table = new JTable();

        submitButton.addActionListener(e -> executeQuery());

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(new JLabel("SQL:"));
        frame.add(sqlTextField);
        frame.add(new JLabel("Filter:"));
        frame.add(filterTextField);
        frame.add(submitButton);
        frame.add(new JScrollPane(table));

        frame.setVisible(true);
    }

    private void executeQuery() {
        String sql = sqlTextField.getText();
        String filter = filterTextField.getText();

        if (!filter.isEmpty()) {
            sql += " WHERE " + filter;
        }

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];

                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }

                model.addRow(row);
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SQLQuerys::new);
    }
}

