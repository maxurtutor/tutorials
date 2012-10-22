package org.maxur.tutorials;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/10/12</pre>
 */
public class PersonModelSimpleImpl implements PersonModel {

    private String firstName = "";

    private String lastName = "";

    public PersonModelSimpleImpl(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(final String firstName) {
        this.firstName = firstName.trim();
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(final String lastName) {
        this.lastName = lastName.trim();
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
