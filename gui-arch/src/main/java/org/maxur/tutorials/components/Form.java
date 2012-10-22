package org.maxur.tutorials.components;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>10/16/12</pre>
 */
public class Form extends Component {

    private Map<String, Component> components = new HashMap<String, Component>();

    public Form(final String id) {
        super(id);
    }

    protected void add(final Component component) {
        components.put(component.getId(), component);
    }

    public Button getButton(final String id) {
        return (Button) components.get(id);
    }

    public Text getText(final String id) {
        return (Text) components.get(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends Component> T get(final String id) {
        return (T) components.get(id);
    }
}
