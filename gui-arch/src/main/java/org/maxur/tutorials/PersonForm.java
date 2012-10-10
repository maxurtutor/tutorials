package org.maxur.tutorials;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/9/12</pre>
 */
public class PersonForm implements Observer {

    private JPanel mainPanel;
    private JButton exitButton;
    private JButton saveButton;
    private JTextField firstNameField;
    private JTextField fullNameField;
    private JTextField lastNameField;

    private final PersonModel model;

    public PersonForm(final PersonModelSimpleImpl model) {

        this.model = model;

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        firstNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                PersonForm.this.model.setFirstName(firstNameField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                PersonForm.this.model.setFirstName(firstNameField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                PersonForm.this.model.setFirstName(firstNameField.getText());
            }
        });

        lastNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                PersonForm.this.model.setLastName(lastNameField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                PersonForm.this.model.setLastName(lastNameField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                PersonForm.this.model.setLastName(lastNameField.getText());
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void update(Observable o, Object arg) {
        final PersonModel model = (PersonModel) o;
        fullNameField.setForeground(model.check() ? Color.GREEN : Color.RED);
        fullNameField.setText(model.getFullName());
    }
}
