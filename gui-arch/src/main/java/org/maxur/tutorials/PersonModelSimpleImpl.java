package org.maxur.tutorials;

import java.util.Observable;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/10/12</pre>
 */
public class PersonModelSimpleImpl extends Observable implements PersonModel {

   String firstName = "";

   String lastName = "";

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
        setChanged();
        notifyObservers();
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
        setChanged();
        notifyObservers();
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean check() {
        return getFullName().matches("^([A-Z][a-z]*(\\s))+[A-Z][a-z]*$");
    }

}
