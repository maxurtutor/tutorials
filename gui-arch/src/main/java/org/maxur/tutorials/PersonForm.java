package org.maxur.tutorials;

import javax.swing.*;
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

    private final PersonPresentationModel model;

    public PersonForm(final PersonPresentationModel model) {
        this.model = model;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void update(Observable o, Object arg) {
        getFullNameField().setForeground(model.getFullNameColor());
        getFullNameField().setText(model.getFullName());
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

    public JTextField getFullNameField() {
        return fullNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

}
