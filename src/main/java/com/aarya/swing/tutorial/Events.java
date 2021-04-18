package com.aarya.swing.tutorial;

import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Events {

    public static void main(String[] args) {

        JFrame frame = new JFrame("About events");

        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(true);

        frame.setLocationRelativeTo(null);

        frame.add(createPanel());

        frame.addWindowListener(new MyWindowListener());

        frame.setVisible(true);

    }

    public static JPanel createPanel() {

        JPanel p = new JPanel();

        JButton b1 = new JButton("clicks");

        JTextArea a = new JTextArea(15, 20);

        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        a.setEditable(false);

        b1.addActionListener(new ButtonListener(b1, a));

        a.addKeyListener(new MyKeyListener(a));

        p.add(b1);

        p.add(new JScrollPane(a));

        JTextField l = new JTextField("hi", 10);
        l.requestFocus();
        p.add(l);

        a.addMouseListener(new MyMouseListener(a));

        return p;
    }
}

class ButtonListener implements ActionListener {

    JButton button1;
    JTextArea a;
    int count = 1;

    public ButtonListener(JButton b, JTextArea a) {
        button1 = b;
        this.a = a;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.button1) {
            a.append("Clicks: " + count++ + "\n");
        }
    }

}

class MyKeyListener implements KeyListener {

    JTextArea a;

    public MyKeyListener(JTextArea a) {
        this.a = a;
    }

    public void keyPressed(KeyEvent e) {
        a.append("key hit: " + e.getKeyChar() + "\n");
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

}

class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window activated");

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("window deactivated");

    }

}

class MyMouseListener implements MouseListener {

    JTextArea area;

    public MyMouseListener(JTextArea jta) {
        area = jta;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        area.append("\nmouse position:" + e.getX() + ", " + e.getY());
        area.append("\nmouse  screen positon: " + e.getXOnScreen() + ", " + e.getYOnScreen());
        area.append("\nmouse button: " + e.getButton());
        area.append("\nmouse clicks: " + e.getClickCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}