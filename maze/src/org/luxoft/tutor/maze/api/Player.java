package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>5/17/12</pre>
 */
public class Player {

    private Room position;

    private int health;

    public void setCurrentPosition(final Room room) {
        position = room;
    }

    public void moveTo(final Side side) {
        position.move(this, side);
    }

    public Room getCurrentPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }
}
