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
        this.form.getButton("exitButton").onClick(new ExitCommand());
        this.form.getText("firstNameField").onChange(new ChangeFirstNameCommand());
        this.form.getText("lastNameField").onChange(new ChangeLastNameCommand());

        this.form.getText("firstNameField").setValue(model.getFirstName());
        this.form.getText("lastNameField").setValue(model.getLastName());
        updateFullName();
    }

    private class ExitCommand implements Command {
        @Override
        public void execute() {
            System.exit(0);
        }
    }

    private class ChangeLastNameCommand implements Command {
        @Override
        public void execute() {
            model.setLastName(form.getText("lastNameField").getValue());
            updateFullName();
        }
    }

    private class ChangeFirstNameCommand implements Command {
        @Override
        public void execute() {
            model.setFirstName(form.getText("firstNameField").getValue());
            updateFullName();
        }
    }

    private void updateFullName() {
        form.getText("fullNameField").setColor(model.check() ? Color.GREEN : Color.RED);
        form.getText("fullNameField").setValue(model.getFullName());
    }

}
