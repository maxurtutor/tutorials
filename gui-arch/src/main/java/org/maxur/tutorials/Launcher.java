package org.maxur.tutorials;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {

        final PersonPresenter presenter = new PersonPresenter(new PersonModelSimpleImpl());
        final PersonForm form = presenter.getView();

        final JFrame frame = new JFrame("Registration Form");
        frame.setContentPane(form.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}