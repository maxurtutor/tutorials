package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class MapSiteFactory {

    private final Map<String, MapSite> sites = new HashMap<String, MapSite>();

    public abstract void init();

    protected void persist(final String id, final MapSite prototype) {
        sites.put(id, prototype);
    }

    public Door makeDoor(final String id, final Room room1, final Room room2) {
        final MapSite prototype = sites.get(id);
        assert (prototype != null && prototype instanceof Door);
        try {
            final Door result = (Door) prototype.clone();
            result.init(room1, room2);
            return result;
        } catch (CloneNotSupportedException ignore) {
            assert false;
            return null;
        }
    }

    public Wall makeWall() {
        final MapSite site = sites.get("wall");
        assert (site != null && site instanceof Wall);
        try {
            return (Wall) site.clone();
        } catch (CloneNotSupportedException ignore) {
            assert false;
            return null;
        }
    }
}
