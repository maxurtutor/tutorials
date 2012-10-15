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

    public void setFirstName(final String firstName) {
        model.setFirstName(firstName);
        update();
    }

    public void setLastName(final String lastName) {
        model.setLastName(lastName);
        update();
    }

    private void update() {
        form.setFullNameColor(model.check() ? Color.GREEN : Color.RED);
        form.setFullNameText(model.getFullName());
    }

}
