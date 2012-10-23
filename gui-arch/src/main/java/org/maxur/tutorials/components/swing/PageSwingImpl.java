package org.maxur.tutorials.components.swing;

import org.maxur.tutorials.components.Page;

import javax.swing.*;

public class PageSwingImpl implements Page {

    private final JFrame frame;

    public PageSwingImpl(final ViewSwingImpl view, final String title) {
        frame = new JFrame(title);
        frame.setContentPane(view.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
    }

    @Override
    public void show() {
        this.frame.setVisible(true);
    }

}