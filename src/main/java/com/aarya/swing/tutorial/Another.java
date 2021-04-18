package com.aarya.swing.tutorial;

import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Another extends JFrame {

    double totalCalc = 0;

    public Another() {

        setSize(400, 400);
        setTitle("My Third Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton button = new JButton("Calculate");
        JLabel label1 = new JLabel("Number 1");
        JLabel label2 = new JLabel("Number 2");
        JTextField num1 = new JTextField("", 5);
        JTextField num2 = new JTextField("", 5);
        JCheckBox checkbox1 = new JCheckBox("Dollars");
        JCheckBox checkbox2 = new JCheckBox("Commas", true);

        button.addActionListener(e -> {
        });

        panel.add(button);
        panel.add(label1);
        panel.add(num1);
        panel.add(label2);
        panel.add(num2);

        panel.add(checkbox1);
        panel.add(checkbox2);

        ButtonGroup operations = new ButtonGroup();

        JRadioButton radio1 = new JRadioButton("Add");
        JRadioButton radio2 = new JRadioButton("Subtract");
        JRadioButton radio3 = new JRadioButton("Multiply");
        JRadioButton radio4 = new JRadioButton("Divide");

        operations.add(radio1);
        operations.add(radio2);
        operations.add(radio3);
        operations.add(radio4);

        JPanel childPanel = new JPanel();

        Border panelBorder = BorderFactory.createTitledBorder("Operation");

        childPanel.setBorder(panelBorder);

        childPanel.add(radio1);
        childPanel.add(radio2);
        childPanel.add(radio3);
        childPanel.add(radio4);

        radio1.setSelected(true);

        panel.add(childPanel);

        add(panel);

        JLabel label = new JLabel("perform how many times?");
        panel.add(label);

        JSlider slider = new JSlider(0, 49, 1);

        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);

        JLabel sliderValue = new JLabel();
        panel.add(sliderValue);

        button.addActionListener(e -> {
            try {
                double d1 = Double.parseDouble(num1.getText());
                double d2 = Double.parseDouble(num2.getText());

                if (radio1.isSelected()) {
                    totalCalc = d1 + d2;
                } else if (radio2.isSelected()) {
                    totalCalc = d1 - d2;
                } else if (radio3.isSelected()) {
                    totalCalc = d1 * d2;
                } else if (radio4.isSelected()) {
                    if (d2 == 0) {
                        throw new ArithmeticException();
                    }
                    totalCalc = d1 / d2;
                } else {
                    throw new IllegalStateException();
                }
                totalCalc *= slider.getValue();

                if (checkbox1.isSelected()) {
                    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "us"));
                    showInfo(String.valueOf(format.format(totalCalc)), "Solution");
                }

                else if (checkbox2.isSelected()) {
                    NumberFormat format = NumberFormat.getNumberInstance();
                    showInfo(String.valueOf(format.format(totalCalc)), "Solution");
                }

                else {
                    showInfo(String.valueOf(totalCalc), "Solution");
                }
            } catch (NumberFormatException ex) {
                showError("Please enter a number");
            } catch (ArithmeticException ex) {
                showError("Division by zero error");
            } catch (IllegalStateException ex) {
                showError("Operation was not selected");
            }
        });

        slider.addChangeListener(e -> sliderValue.setText("Slider value: " + slider.getValue()));
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
        setVisible(true);
    }

    public void showInfo(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Another();
    }
}
