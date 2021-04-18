package com.aarya.swing.tutorial;

import javax.swing.*;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

public class Spinners extends JFrame {

    public Spinners() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel thePanel = new JPanel();

        /* shows numbers 1 to 9 */
        JSpinner s1 = new JSpinner();

        /* current value, min, max, step */
        JSpinner s2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        String[] days = "Mon Tue Wed Thur Fri Sat Sun".split("\\s+");

        /* cycles through items in an array */
        JSpinner s3 = new JSpinner(new SpinnerListModel(days));
        Dimension d = new Dimension(s3.getPreferredSize());
        d.setSize(80, d.getHeight());
        s3.setPreferredSize(d);

        /* date spinner */
        JSpinner s4 = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(s4, "dd/mm/yy");
        s4.setEditor(dateEditor);

        thePanel.add(s1);
        thePanel.add(s2);
        thePanel.add(s3);
        thePanel.add(s4);

        add(thePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Spinners();
    }
}
