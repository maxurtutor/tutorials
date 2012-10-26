package org.maxur.tutorials;

import org.maxur.tutorials.components.View;

import java.awt.Color;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/15/12</pre>
 */
public class PersonPresenter {

    private final View form;

    private final PersonModel model;

    public PersonPresenter(final PersonModel model, final View form) {
        this.model = model;
        this.form = form;

        this.form.getButton("exitButton").onClick(this::exit);
        this.form.getText("firstNameField").onChange(this::changeFirstName);
        this.form.getText("lastNameField").onChange(this::changeLastName);

        this.form.getText("firstNameField").setValue(model.getFirstName());
        this.form.getText("lastNameField").setValue(model.getLastName());
        updateFullName();
    }

    public void exit() {
        System.exit(0);
    }

    public void changeFirstName() {
        model.setFirstName(form.getText("firstNameField").getValue());
        updateFullName();
    }

    public void changeLastName() {
        model.setLastName(form.getText("lastNameField").getValue());
        updateFullName();
    }

    private void updateFullName() {
        form.getText("fullNameField").setColor(model.check() ? Color.GREEN : Color.RED);
        form.getText("fullNameField").setValue(model.getFullName());
    }

}
