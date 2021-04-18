package com.aarya.swing.tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame {

    private int clickCount = 0;

    public MyFrame() {

        this.setSize(new Dimension(400, 400));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[] coords = getCentrePosition();

        this.setLocation(coords[0], coords[1]);

        this.setResizable(false);

        this.add(createMyPanel());

        this.setVisible(true);
    }

    private JPanel createMyPanel() {

        JPanel panel = new JPanel();

        JLabel label = createMyLabel();

        panel.add(label);

        panel.add(createMyButton(label));

        panel.add(createMyTextField());

        panel.add(createJScrollPane(createMyTextArea()));

        return panel;
    }

    private JTextArea createMyTextArea() {

        JTextArea textArea = new JTextArea(15, 20);

        textArea.setLineWrap(true);

        textArea.setWrapStyleWord(true);

        textArea.append("Just a whole bunch of text that is not important.");

        textArea.append("\n Number of lines: " + textArea.getLineCount());

        return textArea;

    }

    private JScrollPane createJScrollPane(JTextArea textArea) {

        return new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private JLabel createMyLabel() {

        JLabel label = new JLabel("Click the button");

        label.setToolTipText("does not do nothing");

        label.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        label.setForeground(Color.DARK_GRAY);

        return label;
    }

    private JButton createMyButton(JLabel label) {

        JButton btn = new JButton("Click me");

        btn.addActionListener(e -> label.setText("Button clicked: " + ++clickCount));

        return btn;
    }

    private int[] getCentrePosition() {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = dim.width / 2 - this.getWidth() / 2;

        int y = dim.height / 2 - this.getHeight() / 2;

        return new int[] { x, y };
    }

    private JTextField createMyTextField() {

        JTextField field = new JTextField("Type something", 10);

        field.setToolTipText("its a field");

        return field;
    }
}