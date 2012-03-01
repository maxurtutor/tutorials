package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/1/12</pre>
 */
public class Registrar {

    final private static Registrar instance = new Registrar();

    final private Map<String, Object> beans = new HashMap<String, Object>();

    private Registrar() {
    }

    public static Registrar getInstance() {
        return instance;
    }

    public void persist(final String id, final Object bean) {
        beans.put(id, bean);                
    }

    @SuppressWarnings("unchecked")
    public <T> T get(final String id) {
        return (T) beans.get(id);
    }
}
