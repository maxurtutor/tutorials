package org.maxur.tutorials;

import java.awt.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/15/12</pre>
 */
public class PersonApplicationModel {

    private final PersonForm form;

    private final PersonModel model;

    public PersonApplicationModel(final PersonForm form, final PersonModel model) {
        this.form = form;
        this.model = model;
    }

    public void onChangeLastName() {
        model.setLastName(form.getLastNameField().getText());
        updateFullName();
    }

    public void onChangeFirstName() {
        model.setFirstName(form.getFirstNameField().getText());
        updateFullName();
    }

    private void updateFullName() {
        form.setFullNameColor(model.check() ? Color.GREEN : Color.RED);
        form.setFullNameText(model.getFullName());
    }

    void onExit() {
        System.exit(0);
    }
}
