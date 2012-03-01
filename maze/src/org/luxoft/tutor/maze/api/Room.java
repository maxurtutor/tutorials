package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Room extends Cell {

    protected Room(final Integer roomNumber) {
        super(roomNumber);
    }

    @Override
    public void draw() {
        for (Side value : Side.values()) {
            getSide(value).draw(getRectangle(value));
        }
    }

    private Rectangle getRectangle(final Side value) {
        // TODO Auto-generated method stub
        return null;
    }
}
