package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Room extends MapSite {

    private final Integer roomNumber;

    private Map<Side, MapSite> sites = new HashMap<Side, MapSite>(4);

    protected Room(final Integer roomNumber) {
        assert(roomNumber != null);
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public MapSite getSide(final Side side) {
        return sites.get(side);
    }

    public void setSide(final Side side, final MapSite site) {
        sites.put(side, site);
    }

    public abstract void draw();
}
