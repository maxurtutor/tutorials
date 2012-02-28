package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Door extends MapSite {

    private boolean open = false;

    protected final Room room1;

    protected final Room room2;

    protected Door(final Room room1, final Room room2) {
        assert (null != room1 && null != room2);
        this.room1 = room1;
        this.room2 = room2;
    }

    public boolean isOpen() {
        return open;
    }

    public void open(boolean open) {
        this.open = open;
    }

    public Room otherSideFrom(final Room room) {
        assert (null != room);
        if (room1.equals(room)) {
            return room2;
        } else if (room2.equals(room)) {
            return room1;
        } else {
            return null;
        }
    }
}
