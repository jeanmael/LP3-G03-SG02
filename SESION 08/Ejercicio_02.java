package com.mycompany.compradepasajesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraDePasajesApp extends JFrame implements ActionListener {
    private JLabel lblNombre, lblDocumento, lblOrigen, lblDestino, lblFecha, lblServicio, lblPiso, lblExtras;
    private JTextField txtNombre, txtDocumento, txtFecha;
    private JComboBox<String> cmbOrigen, cmbDestino;
    private JRadioButton rbtnPrimerPiso, rbtnSegundoPiso;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JList<String> lstServicio;
    private JButton btnResumen;

    public CompraDePasajesApp() {
        setTitle("Compra de Pasajes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        lblNombre = new JLabel("Nombre:");
        lblDocumento = new JLabel("Documento:");
        lblOrigen = new JLabel("Origen:");
        lblDestino = new JLabel("Destino:");
        lblFecha = new JLabel("Fecha de Viaje:");
        lblServicio = new JLabel("Servicio:");
        lblPiso = new JLabel("Piso:");
        lblExtras = new JLabel("Extras:");

        txtNombre = new JTextField(20);
        txtDocumento = new JTextField(10);
        txtFecha = new JTextField(10);

        String[] origenes = {"Ciudad A", "Ciudad B", "Ciudad C"};
        cmbOrigen = new JComboBox<>(origenes);
        String[] destinos = {"Ciudad X", "Ciudad Y", "Ciudad Z"};
        cmbDestino = new JComboBox<>(destinos);

        rbtnPrimerPiso = new JRadioButton("Primer Piso");
        rbtnSegundoPiso = new JRadioButton("Segundo Piso");
        ButtonGroup pisoGroup = new ButtonGroup();
        pisoGroup.add(rbtnPrimerPiso);
        pisoGroup.add(rbtnSegundoPiso);

        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");

        String[] servicios = {"Económico", "Estándar", "VIP"};
        lstServicio = new JList<>(servicios);

        btnResumen = new JButton("Mostrar Resumen");
        btnResumen.addActionListener(this);

        add(lblNombre);
        add(txtNombre);
        add(lblDocumento);
        add(txtDocumento);
        add(lblOrigen);
        add(cmbOrigen);
        add(lblDestino);
        add(cmbDestino);
        add(lblFecha);
        add(txtFecha);
        add(lblServicio);
        add(new JScrollPane(lstServicio));
        add(lblPiso);
        add(rbtnPrimerPiso);
        add(new JLabel(""));
        add(rbtnSegundoPiso);
        add(lblExtras);
        add(chkAudifonos);
        add(chkManta);
        add(chkRevistas);
        add(new JLabel("")); // Espacio en blanco
        add(btnResumen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Manejo del evento del botón "Mostrar Resumen"
        String nombre = txtNombre.getText();
        String documento = txtDocumento.getText();
        String origen = cmbOrigen.getSelectedItem().toString();
        String destino = cmbDestino.getSelectedItem().toString();
        String fecha = txtFecha.getText();
        String servicio = lstServicio.getSelectedValue();
        String piso = rbtnPrimerPiso.isSelected() ? "Primer Piso" : "Segundo Piso";
        String extras = "";

        if (chkAudifonos.isSelected()) extras += "Audífonos, ";
        if (chkManta.isSelected()) extras += "Manta, ";
        if (chkRevistas.isSelected()) extras += "Revistas";

        // Mostrar resumen en un cuadro de diálogo
        JOptionPane.showMessageDialog(this,
                "Resumen de la Compra:\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "Documento: " + documento + "\n" +
                        "Origen: " + origen + "\n" +
                        "Destino: " + destino + "\n" +
                        "Fecha de Viaje: " + fecha + "\n" +
                        "Servicio: " + servicio + "\n" +
                        "Piso: " + piso + "\n" +
                        "Extras: " + (extras.isEmpty() ? "Ninguno" : extras));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompraDePasajesApp app = new CompraDePasajesApp();
            app.setVisible(true);
        });
    }
}
