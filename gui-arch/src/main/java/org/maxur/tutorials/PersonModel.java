package org.maxur.tutorials;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/10/12</pre>
 */
public interface PersonModel {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getFullName();

    boolean check();
}
