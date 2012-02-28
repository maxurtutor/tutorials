package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Room extends MapSite {

    static final public int NORTH = 0;
    static final public int SOUTH = 1;
    static final public int EAST = 2;
    static final public int WEST = 3;

    private final Integer roomNumber;

    private MapSite[] sites = new MapSite[4];

    protected Room(final Integer roomNumber) {
        assert(roomNumber != null);
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public MapSite getSide(int side) {
        return sites[side];
    }

    public void setSide(int side, MapSite site) {
        sites[side] = site;
    }
}
