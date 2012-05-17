package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Room extends Cell {

    @Override
    public void draw() {
        for (Side side : Side.values()) {
            getSide(side).draw(getRectangle(side));
        }
    }

    private Rectangle getRectangle(final Side value) {
        // TODO Auto-generated method stub
        return null;
    }

    public void move(final Player player, final Side side) {
        getSide(side).enter(player);
    }
}
