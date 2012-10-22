package org.maxur.tutorials.components.swing;

import org.maxur.tutorials.Command;
import org.maxur.tutorials.components.Text;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public class TextSwingImpl extends Text {

    private final JTextField text;

    public TextSwingImpl(final String id, final JTextField text) {
        super(id);
        this.text = text;
    }

    @Override
    public void onChange(final Command command) {
        this.text.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                command.execute();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                command.execute();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                command.execute();
            }
        });
    }

    @Override
    public void setValue(final String value) {
        text.setText(value);
    }

    @Override
    public void setColor(final Color color) {
        text.setForeground(color);
    }

    @Override
    public String getValue() {
        return text.getText();
    }
}
