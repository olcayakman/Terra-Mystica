package com.TerraMystica;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main( String[] args) {
        String text = "Vatana millete hayırlı olsun...";
        System.out.println(text);
        final JFrame frame = new JFrame();

        Container pane = frame.getContentPane();

        JLabel fotoLabel = new JLabel( new ImageIcon("./images/ERAY.jpg"));
        JLabel textLabel = new JLabel("\"K O R O N A   K O D   Y A Z M A Y A   E N G E L   D E G I L\"");


        pane.setLayout(new GridLayout(1, 0));
        pane.add(fotoLabel);
        pane.add(textLabel);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setVisible(true);

    }

}