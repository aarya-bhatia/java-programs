package com.aarya.swing.layouts;

import java.awt.*;
import javax.swing.*;

public class GridBagEx1 extends JFrame {

    public GridBagEx1() {
        this.init();
        this.createLayout();
    }

    public void init() {
        this.setTitle("Swing Application");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFont(new Font("Helvetica", Font.PLAIN, 18));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    public void createLayout() {
        JPanel panel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        this.add(panel);

        JLabel top = new JLabel("Top");
        JLabel left = new JLabel("Left");
        JLabel middle = new JLabel("middle");
        JLabel right = new JLabel("right");
        JLabel bottom = new JLabel("bottom");

        addComp(1, 0, 1.0, 1.0, top, panel);
        addComp(0, 1, 0.5, 1.0, left, panel);
        addComp(1, 1, 1.0, 1.0, middle, panel);
        addComp(2, 1, 0.5, 1.0, right, panel);
        addComp(1, 2, 1.0, 1.0, bottom, panel);
    }

    public void addComp(int x, int y, double wx, double wy, JComponent comp, JPanel p) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.weightx = wx;
        c.weighty = wy;
        p.add(comp, c);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridBagEx1());
    }
}
