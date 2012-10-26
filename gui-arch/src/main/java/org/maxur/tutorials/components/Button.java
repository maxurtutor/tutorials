package org.maxur.tutorials.components;


import org.maxur.tutorials.Command;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public abstract class Button extends Component {

    public Button(final String id) {
        super(id);
    }

    public abstract void onClick(Command command);
}
