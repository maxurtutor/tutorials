package org.maxur.tutorials;

import org.maxur.tutorials.components.Page;
import org.maxur.tutorials.components.swing.PageSwingImpl;
import org.maxur.tutorials.components.swing.ViewSwingImpl;
import org.maxur.tutorials.views.PersonForm;

public class Launcher {

    public static void main(String[] args) {

        final ViewSwingImpl view =  new ViewSwingImpl("mainForm", new PersonForm());
        final PersonModel model = new PersonModelSimpleImpl("Ivan", "Ivanov");
        new PersonPresenter(model, view);

        final Page page = new PageSwingImpl(view, "Registration Form");
        page.show();

    }

}