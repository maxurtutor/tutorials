package org.maxur.tutorials.components.swing;

import org.maxur.tutorials.components.Button;
import org.maxur.tutorials.components.View;
import org.maxur.tutorials.components.Text;

import javax.swing.*;
import java.lang.reflect.Field;


/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public class ViewSwingImpl extends View {

    private final SwingForm form;

    public ViewSwingImpl(final String id, final SwingForm form) {
        super(id);
        this.form = form;
        autocreateComponents();
    }

    private void autocreateComponents() {
        final Field[] fields = form.getClass().getDeclaredFields();
        for (final Field field : fields) {
            try {
                switch (field.getType().toString()) {
                    case "class javax.swing.JButton":
                        field.setAccessible(true);
                        add(button(field.getName(), (JButton) field.get(form)));
                        continue;
                    case "class javax.swing.JTextField":
                        field.setAccessible(true);
                        add(text(field.getName(), (JTextField) field.get(form)));
                        continue;
                    default:
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }

        }
    }

    private static Button button(final String id, final JButton button) {
        return new ButtonSwingImpl(id, button);
    }

    private static Text text(final String id, final JTextField textField) {
        return new TextSwingImpl(id, textField);
    }

    public JPanel getMainPanel() {
        return form.getMainPanel();
    }
}
