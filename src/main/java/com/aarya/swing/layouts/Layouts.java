package com.aarya.swing.layouts;

import java.awt.*;
import javax.swing.*;

public class Layouts extends JFrame {

    JButton b1, b2, b3, b4, b5;

    public Layouts() {
        this.setSize(400, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Swing");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
    }

    public void createFlowLayout() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        this.add(p);
    }

    public void createBorderLayout() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        p.add(b1, BorderLayout.NORTH);
        p.add(b2, BorderLayout.SOUTH);
        p.add(b3, BorderLayout.EAST);
        p.add(b4, BorderLayout.WEST);
        p.add(b5, BorderLayout.CENTER);

        this.add(p);
    }

    public void createBoxLayout() {
        Box box = Box.createHorizontalBox();
        box.add(b1);
        box.add(Box.createHorizontalGlue());
        box.add(b2);
        this.add(box);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Layouts l = new Layouts();
            l.createBorderLayout();
        });
    }
}
