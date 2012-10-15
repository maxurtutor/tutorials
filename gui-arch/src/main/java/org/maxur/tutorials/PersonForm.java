package org.maxur.tutorials;

import javax.swing.*;
import java.awt.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/9/12</pre>
 */
public class PersonForm  {

    private JPanel mainPanel;
    private JButton exitButton;
    private JButton saveButton;
    private JTextField firstNameField;
    private JTextField fullNameField;
    private JTextField lastNameField;

    public PersonForm() {
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    void setFullNameText(final String value) {
        fullNameField.setText(value);
    }

    void setFullNameColor(final Color color) {
        fullNameField.setForeground(color);
    }
}
