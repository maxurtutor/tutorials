package org.maxur.tutorials.components;


import org.maxur.tutorials.Command;

import java.awt.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public abstract class Text extends Component {

    public Text(final String id) {
        super(id);
    }

    public abstract void onChange(Command command);

    public abstract void setValue(String value);

    public abstract void setColor(Color color);

    public abstract String getValue();
}
