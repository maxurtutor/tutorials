package org.maxur.tutorials;

import java.awt.*;
import java.util.Observable;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/15/12</pre>
 */
public class PersonPresentationModel extends Observable {

    private final PersonModel model;

    public PersonPresentationModel(final PersonModel model) {
        this.model = model;
    }

    public String getFirstName() {
        return model.getFirstName();
    }

    public void setFirstName(final String firstName) {
        model.setFirstName(firstName);
        setChanged();
        notifyObservers();
    }

    public String getLastName() {
        return model.getLastName();
    }

    public void setLastName(final String lastName) {
        model.setLastName(lastName);
        setChanged();
        notifyObservers();
    }

    public String getFullName() {
        return model.getFullName();
    }

    public boolean check() {
        return model.check();
    }

    public Color getFullNameColor() {
        return model.check() ? Color.GREEN : Color.RED;
    }


}
