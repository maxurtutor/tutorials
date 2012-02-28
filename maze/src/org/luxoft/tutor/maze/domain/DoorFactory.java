package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class DoorFactory {

    static private final DoorFactory instance = new DoorFactory();

    private final Map<String, Door> prototypes = new HashMap<String, Door>();
    
    public void persist(final String id, final Door prototype) {
        prototypes.put(id, prototype);
    }

    public Door make(final String id, final Room room1, final Room room2) {
        final Door prototype = prototypes.get(id);
        assert(prototype != null);
        try {
            final Door result = (Door) prototype.clone();
            result.init(room1, room2);
            return result;
        } catch (CloneNotSupportedException ignore) {
            assert false;
            return null;
        }
    }

    public static DoorFactory getInstance() {
        return instance;
    }
}
