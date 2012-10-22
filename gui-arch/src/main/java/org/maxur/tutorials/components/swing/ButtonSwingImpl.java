package org.maxur.tutorials.components.swing;

import org.maxur.tutorials.Command;
import org.maxur.tutorials.components.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public class ButtonSwingImpl extends Button {

    private final JButton button;

    public ButtonSwingImpl(final String id, final JButton button) {
        super(id);
        this.button = button;
    }

    @Override
    public void onClick(final Command exitCommand) {
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitCommand.execute();
            }
        });
    }

}
