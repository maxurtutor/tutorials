package org.maxur.tutorials.views;

import org.maxur.tutorials.components.swing.SwingForm;

import javax.swing.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/9/12</pre>
 */
public class PersonForm implements SwingForm {

    @SuppressWarnings("UnusedDeclaration")
    private JPanel mainPanel;
    @SuppressWarnings("UnusedDeclaration")
    private JButton exitButton;
    @SuppressWarnings("UnusedDeclaration")
    private JButton saveButton;
    @SuppressWarnings("UnusedDeclaration")
    private JTextField firstNameField;
    @SuppressWarnings("UnusedDeclaration")
    private JTextField fullNameField;
    @SuppressWarnings("UnusedDeclaration")
    private JTextField lastNameField;

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

}
