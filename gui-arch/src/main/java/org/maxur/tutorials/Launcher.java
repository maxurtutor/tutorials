package org.maxur.tutorials;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {

        final PersonForm form =  new PersonForm();
        final PersonModel model = new PersonModelSimpleImpl("Ivan", "Ivanov");
        new PersonPresenter(model, form);

        final JFrame frame = new JFrame("Registration Form");
        frame.setContentPane(form.getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}