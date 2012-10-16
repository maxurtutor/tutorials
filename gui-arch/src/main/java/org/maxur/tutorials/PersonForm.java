package org.maxur.tutorials;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    void addCommandOnButtonClick(final Command exitCommand, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitCommand.execute();
            }
        });
    }

    void addCommandOnChangeFieldValue(final Command command, final JTextField field) {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                command.execute();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                command.execute();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                command.execute();
            }
        });
    }
}
