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
public class PersonForm {

    private JPanel mainPanel;
    private JButton exitButton;
    private JButton saveButton;
    private JTextField firstNameField;
    private JTextField fullNameField;
    private JTextField lastNameField;

    public PersonForm() {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        firstNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChangeAnyName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChangeAnyName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChangeAnyName();
            }
        });

        lastNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChangeAnyName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChangeAnyName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChangeAnyName();
            }
        });

    }

    private void onChangeAnyName() {
        final String fullName = firstNameField.getText() + " " + lastNameField.getText();
        fullNameField.setForeground(check(fullName) ? Color.GREEN : Color.RED);
        fullNameField.setText(fullName);
    }

    private boolean check(final String fullName) {
        return fullName.matches("^([A-Z][a-z]*(\\s))+[A-Z][a-z]*$");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setContentPane(new PersonForm().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
