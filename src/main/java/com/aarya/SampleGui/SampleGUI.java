package com.aarya.SampleGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SampleGUI extends JFrame {

    JLabel nameLabel = new JLabel("Name");
    JLabel streetLabel = new JLabel("Street");
    JLabel stateLabel = new JLabel("State");
    JLabel dateLabel = new JLabel("Date");
    JLabel ageLabel = new JLabel("Age: 18");
    JTextField nameText, streetText;
    Box nameBox;
    Box genderBox;
    ButtonGroup genderGroup;
    JRadioButton maleButton, femaleButton;
    JCheckBox morningCheckBox, afternoonCheckBox, eveningCheckBox;
    JTextArea textArea;
    JScrollPane textPane;
    String[] states = { "IL", "OH", "LA", "NY" };
    JComboBox<String> stateBox;
    JSpinner dateSpinner;
    JSlider ageSlider;
    JButton submitButton = new JButton("Done");

    public SampleGUI() {
        this.setSize(new Dimension(400, 400));
        this.setTitle("Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFont(new Font("Helvetica", Font.PLAIN, 18));
        this.setBackground(Color.GRAY);
        this.initComp();
        this.addListeners();
        this.createLayout();
    }

    public void initComp() {
        nameBox = Box.createVerticalBox();
        nameText = new JTextField(10);
        streetText = new JTextField(10);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        maleButton.setSelected(true);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        genderBox = Box.createHorizontalBox();
        genderBox.add(maleButton);
        genderBox.add(femaleButton);
        genderBox.setBorder(BorderFactory.createTitledBorder("Sex"));

        stateBox = new JComboBox<>(states);

        dateSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));

        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/mm/yy"));

        ageSlider = new JSlider(1, 99, 18);
    }

    public void addListeners() {
        ageSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() == ageSlider) {
                    ageLabel.setText("Age: " + ageSlider.getValue());
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";

                message += "Name: " + nameText.getText() + "\n";
                message += "Street: " + streetText.getText() + "\n";
                if (genderGroup.getSelection() == maleButton) {
                    message += "Gender: Male" + "\n";
                } else {
                    message += "Gender: Female" + "\n";
                }
                message += "Age: " + ageSlider.getValue() + "\n";
                message += "State: " + stateBox.getSelectedItem() + "\n";
                message += "Appointment Date: " + dateSpinner.getValue() + "\n";
                message += "Time: ";
                if (morningCheckBox.isSelected()) {
                    message += " Morning ";
                }
                if (afternoonCheckBox.isSelected()) {
                    message += " Afternoon ";
                }
                if (eveningCheckBox.isSelected()) {
                    message += " Evening ";
                }
                message += "\nComments: " + textArea.getText();
                JOptionPane.showMessageDialog(SampleGUI.this, message, "Info", JOptionPane.INFORMATION_MESSAGE);

            }

        });
    }

    /** A vertical box layout is used to place components under each other */
    public void createLayout() {
        Box b = Box.createVerticalBox();
        int gap = 15; // gap between rows

        Box row1 = Box.createHorizontalBox();
        row1.add(nameLabel);
        row1.add(Box.createGlue());
        row1.add(nameText);

        Box row2 = Box.createHorizontalBox();
        row2.add(streetLabel);
        row2.add(Box.createGlue());
        row2.add(streetText);

        b.add(Box.createVerticalStrut(gap));
        b.add(row1);
        b.add(Box.createVerticalStrut(gap));
        b.add(row2);
        b.add(Box.createVerticalStrut(gap));

        /* Flow layout row */
        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

        statePanel.add(stateLabel);
        statePanel.add(stateBox);
        statePanel.add(dateLabel);
        statePanel.add(dateSpinner);
        statePanel.add(ageLabel);
        statePanel.add(ageSlider);

        b.add(statePanel);
        b.add(Box.createVerticalStrut(gap));

        /* Check boxes */
        Box row = Box.createHorizontalBox();

        row.add(genderBox);

        Box optionBox = Box.createHorizontalBox();

        morningCheckBox = new JCheckBox("Morning");
        afternoonCheckBox = new JCheckBox("Afternoon");
        eveningCheckBox = new JCheckBox("Evening");

        optionBox.add(morningCheckBox);
        optionBox.add(afternoonCheckBox);
        optionBox.add(eveningCheckBox);

        optionBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));

        row.add(Box.createHorizontalStrut(10));
        row.add(optionBox);

        b.add(row);
        b.add(Box.createVerticalStrut(gap));

        /* Text area */
        textArea = new JTextArea(10, 40);
        textArea.setText("Tell us about you");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        b.add(textPane);
        b.add(Box.createVerticalStrut(gap));

        b.add(submitButton);
        b.add(Box.createVerticalStrut(gap));

        b.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));

        this.add(b);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SampleGUI();
            }
        });
    }

}
