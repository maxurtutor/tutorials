package org.luxoft.tutor.maze.api;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0 07.03.12
 */
public abstract class Room extends MapSite {

    private final Integer roomNumber;

    private Map<Direction, MapSite> sites = new EnumMap<Direction, MapSite>(Direction.class);

    protected Room(final Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public MapSite getSide(final Direction side) {
        return sites.get(side);
    }

    public void setSide(final Direction side, final MapSite site) {
        sites.put(side, site);
    }

}
