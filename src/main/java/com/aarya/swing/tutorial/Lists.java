package com.aarya.swing.tutorial;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Lists extends JFrame {

    JPanel panel = new JPanel();

    DefaultListModel<String> showsListModel = createListModel(new String[] { "Breaking Bad", "Naruto", "Sherlock",
            "Grey's Anatomy", "You", "Peaky Blinders", "Sabrina" });
    DefaultListModel<String> watchListModel = createListModel(new String[] { "Test" });
    JList<String> showsList = createList(showsListModel);
    JList<String> watchList = createList(watchListModel);

    public Lists(String title) {
        init(title);
        panel.add(createScroller(showsList));
        panel.add(createScroller(watchList));

        setSelectionChangeListener();

        add(panel);
        setVisible(true);
    }

    public JScrollPane createScroller(JList<String> list) {
        return new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public DefaultListModel<String> createListModel(String[] values) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String value : values) {
            model.addElement(value);
        }
        return model;
    }

    public JList<String> createList(DefaultListModel<String> model) {
        JList<String> list = new JList<>();
        list.setModel(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(4);
        list.setFixedCellHeight(30);
        list.setFixedCellWidth(150);
        return list;
    }

    public void init(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Lists("Tut 25");
    }

    private void setSelectionChangeListener() {
        showsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                watchListModel.addAll(showsList.getSelectedValuesList());
                for (String show : showsList.getSelectedValuesList()) {
                    showsListModel.removeElement(show);
                }
            }
        });

        watchList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                showsListModel.addAll(watchList.getSelectedValuesList());
                for (String show : watchList.getSelectedValuesList()) {
                    watchListModel.removeElement(show);
                }
            }
        });
    }

}
