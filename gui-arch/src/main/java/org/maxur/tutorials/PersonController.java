package org.maxur.tutorials;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonController {

    private final PersonForm form;

    private final PersonApplicationModel model;

    public PersonController(final PersonForm form, final PersonApplicationModel model) {
        this.form = form;
        this.model = model;
        init();
    }

    private void init() {
        form.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.onExit();
            }
        });

        form.getFirstNameField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.onChangeFirstName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.onChangeFirstName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.onChangeFirstName();
            }
        });

        form.getLastNameField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.onChangeLastName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.onChangeLastName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.onChangeLastName();
            }
        });
    }


}