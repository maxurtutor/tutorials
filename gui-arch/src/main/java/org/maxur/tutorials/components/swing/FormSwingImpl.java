package org.maxur.tutorials.components.swing;

import org.maxur.tutorials.components.Button;
import org.maxur.tutorials.components.Form;
import org.maxur.tutorials.components.Text;

import javax.swing.*;


/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public class FormSwingImpl extends Form {

    public FormSwingImpl(final String id) {
        super(id);
    }

    protected static Button button(final String id, final JButton button) {
        return new ButtonSwingImpl(id, button);
    }

    protected static Text text(final String id, final JTextField textField) {
        return new TextSwingImpl(id, textField);
    }


}
