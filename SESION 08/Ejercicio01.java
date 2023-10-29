import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentesSwing {

    public static void main(String[] args) {

        JFrame frameBoton = new JFrame("Boton de Comando - Integrantes: Bill, Jean");
        JButton buttonBoton = new JButton("Haz clic en mi");

        buttonBoton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "¡Boton de Comando fue presionado!");
        });

        JFrame frameCasilla = new JFrame("Casilla de Verificacion - Integrantes: Bill, Jean");
        JCheckBox checkBox = new JCheckBox("Selecciona/Deselecciona");

        checkBox.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Estado de la casilla: " + checkBox.isSelected());
        });

        JFrame frameBotonesOpcion = new JFrame("Botones de Opcion - Integrantes: Bill, Jean");
        JRadioButton radioButton1 = new JRadioButton("Opcion 1");
        JRadioButton radioButton2 = new JRadioButton("Opcion 2");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        radioButton1.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Opcion 1 seleccionada");
        });

        radioButton2.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Opcion 2 seleccionada");
        });

        JPanel panelBotonesOpcion = new JPanel();
        panelBotonesOpcion.add(radioButton1);
        panelBotonesOpcion.add(radioButton2);

        JFrame frameCuadroCombinado = new JFrame("Cuadro Combinado - Integrantes: Bill, Jean");
        String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        comboBox.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Opcion seleccionada: " + comboBox.getSelectedItem());
        });

        // Lista
        JFrame frameLista = new JFrame("Lista - Integrantes: Bill, Jean");
        JList<String> list = new JList<>(opciones);

        list.addListSelectionListener(e -> {
            JOptionPane.showMessageDialog(null, "Elemento seleccionado: " + list.getSelectedValue());
        });

        configureFrame(frameBoton, buttonBoton);
        configureFrame(frameCasilla, checkBox);
        configureFrame(frameBotonesOpcion, panelBotonesOpcion);
        configureFrame(frameCuadroCombinado, comboBox);
        configureFrame(frameLista, new JScrollPane(list));
    }

    private static void configureFrame(JFrame frame, JComponent component) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);
    }
}
