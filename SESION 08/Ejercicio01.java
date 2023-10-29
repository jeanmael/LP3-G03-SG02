import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiVentana {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Ventana - Integrantes: Bill, Jean");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton button = new JButton("Haz clic");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Boton fue presionado!");
            }
        });

        panel.add(button);

        frame.getContentPane().add(panel);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
