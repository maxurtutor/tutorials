package org.maxur.tutorials;

import java.awt.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/15/12</pre>
 */
public class PersonPresenter {

    private final PersonForm form;

    private final PersonModel model;

    public PersonPresenter(final PersonModel model) {
        this.model = model;
        this.form = new PersonForm();
        this.form.addCommandOnButtonClick(new ExitCommand(), this.form.getExitButton());
        this.form.addCommandOnChangeFieldValue(new ChangeFirstNameCommand(), this.form.getFirstNameField());
        this.form.addCommandOnChangeFieldValue(new ChangeLastNameCommand(), this.form.getLastNameField());
    }

    private void updateFullName() {
        form.setFullNameColor(model.check() ? Color.GREEN : Color.RED);
        form.setFullNameText(model.getFullName());
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
            model.setLastName(form.getLastNameField().getText());
            updateFullName();
        }
    }

    private class ChangeFirstNameCommand implements Command {
        @Override
        public void execute() {
            model.setFirstName(form.getFirstNameField().getText());
            updateFullName();
        }
    }

    public PersonForm getView() {
        return this.form;
    }
}
