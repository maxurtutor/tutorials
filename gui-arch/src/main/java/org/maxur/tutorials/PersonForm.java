package org.maxur.tutorials;

import org.maxur.tutorials.components.swing.FormSwingImpl;

import javax.swing.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/9/12</pre>
 */
public class PersonForm extends FormSwingImpl {

    private JPanel mainPanel;
    private JButton exitButton;
    private JButton saveButton;
    private JTextField firstNameField;
    private JTextField fullNameField;
    private JTextField lastNameField;

    public PersonForm() {
        super("mainForm");
        add(button("exitButton", exitButton));
        add(button("saveButton", saveButton));
        add(text("firstNameField", firstNameField));
        add(text("lastNameField", lastNameField));
        add(text("fullNameField", fullNameField));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
