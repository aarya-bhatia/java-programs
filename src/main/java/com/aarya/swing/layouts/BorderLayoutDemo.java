package com.aarya.swing.layouts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class BorderLayoutDemo {

    static class Gui extends JFrame {
        public Gui() {
            this.setResizable(false);
            this.setTitle("My Gui");
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel l1 = new JLabel("Number 1");
            JLabel l2 = new JLabel("Number 2");
            JTextField num1 = new JTextField(20);
            JTextField num2 = new JTextField(20);

            JPanel content = new JPanel();

            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

            p.add(l1);
            p.add(num1);

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));

            p2.add(l2);
            p2.add(num2);

            Box box = Box.createVerticalBox();

            box.add(p);
            box.add(p2);

            Box action = Box.createHorizontalBox();

            action.add(Box.createHorizontalGlue());

            JButton submit = new JButton("Submit");

            action.add(submit);

            box.add(action);

            box.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

            content.add(box);

            Container root = this.getContentPane();

            DefaultListModel<Integer> listModel = new DefaultListModel<>();
            JList<Integer> list = new JList<>(listModel);
            JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            list.setVisibleRowCount(4);
            list.setFixedCellHeight(30);
            list.setFixedCellWidth(150);
            list.setPreferredSize(new Dimension(200, 200));
            list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

            listModel.addElement(0);

            JPanel listPanel = new JPanel();

            listPanel.add(scroller, BorderLayout.WEST);

            Box buttons = Box.createVerticalBox();

            JButton del = new JButton("del");

            del.addActionListener(e -> {
                if (e.getSource() == del) {
                    Integer sel = list.getSelectedValue();
                    listModel.removeElement(sel);
                }
            });

            buttons.add(del);

            listPanel.add(buttons, BorderLayout.EAST);

            root.add(new JLabel("Please enter your numbers here"), BorderLayout.NORTH);

            root.add(listPanel, BorderLayout.SOUTH);

            root.add(content, BorderLayout.CENTER);

            submit.addActionListener(e -> {
                try {
                    Integer i1 = Integer.parseInt(num1.getText());
                    Integer i2 = Integer.parseInt(num2.getText());
                    listModel.addElement(Integer.sum(i1, i2));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(box, "Enter only numbers");
                }

            });

            this.pack();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Gui gui = new Gui();
                gui.setVisible(true);
            }
        });
    }
}
