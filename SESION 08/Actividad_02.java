package com.mycompany.administradoresdeesquemas;

import javax.swing.*;
import java.awt.*;

public class AdministradoresDeEsquemas {
    public static void main(String[] args) {
        // Crear una ventana con FlowLayout
        JFrame flowLayoutFrame = new JFrame("FlowLayout - Jean De Los Rios y Bill Bernal");
        flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flowLayoutFrame.setLayout(new FlowLayout());

        // Agregar componentes (botones, etiquetas, etc.) con FlowLayout
        flowLayoutFrame.add(new JButton("Botón 1"));
        flowLayoutFrame.add(new JButton("Botón 2"));
        flowLayoutFrame.add(new JButton("Botón 3"));

        // Ajustar el tamaño de la ventana y hacerla visible
        flowLayoutFrame.pack();
        flowLayoutFrame.setVisible(true);

        // Crear una ventana con BorderLayout
        JFrame borderLayoutFrame = new JFrame("BorderLayout - Jean De Los Rios y Bill Bernal");
        borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayoutFrame.setLayout(new BorderLayout());

        // Agregar componentes (botones, etiquetas, etc.) con BorderLayout
        borderLayoutFrame.add(new JButton("Norte"), BorderLayout.NORTH);
        borderLayoutFrame.add(new JButton("Sur"), BorderLayout.SOUTH);
        borderLayoutFrame.add(new JButton("Este"), BorderLayout.EAST);
        borderLayoutFrame.add(new JButton("Oeste"), BorderLayout.WEST);
        borderLayoutFrame.add(new JButton("Centro"), BorderLayout.CENTER);

        // Ajustar el tamaño de la ventana y hacerla visible
        borderLayoutFrame.pack();
        borderLayoutFrame.setVisible(true);

        // Crear una ventana con GridLayout
        JFrame gridLayoutFrame = new JFrame("GridLayout - Jean De Los Rios y Bill Bernal");
        gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridLayoutFrame.setLayout(new GridLayout(3, 2)); // 3 filas y 2 columnas

        // Agregar componentes (botones, etiquetas, etc.) con GridLayout
        gridLayoutFrame.add(new JButton("Botón 1"));
        gridLayoutFrame.add(new JButton("Botón 2"));
        gridLayoutFrame.add(new JButton("Botón 3"));
        gridLayoutFrame.add(new JButton("Botón 4"));
        gridLayoutFrame.add(new JButton("Botón 5"));
        gridLayoutFrame.add(new JButton("Botón 6"));

        // Ajustar el tamaño de la ventana y hacerla visible
        gridLayoutFrame.pack();
        gridLayoutFrame.setVisible(true);
    }
}
