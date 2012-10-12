package org.maxur.tutorials;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {
        final PersonModelSimpleImpl model = new PersonModelSimpleImpl();
        final PersonForm form = new PersonForm(model);
        final PersonController controller = new PersonController(form, model);
        model.addObserver(form);

        final JFrame frame = new JFrame("Registration Form");
        frame.setContentPane(form.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}