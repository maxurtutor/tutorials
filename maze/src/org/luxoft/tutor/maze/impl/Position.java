package org.luxoft.tutor.maze.impl;

import org.luxoft.tutor.maze.api.Direction;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/14/12</pre>
 */
public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position at(int x, int y) {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction directionTo(final Position position) {
        final Position shift = shift(position);
        if (shift.getX() == 1) {
            return Direction.EAST;
        } else if (shift.getX() == -1) {
            return Direction.WEST;
        } else if (shift.getY() == 1) {
            return Direction.NORTH;
        } else if (shift.getY() == -1) {
            return Direction.SOUTH;
        } else {
            assert false;
            return null;
        }
    }

    private Position shift(final Position position) {
        int shiftX = getX() - position.getX();
        int shiftY = getY() - position.getY();
        return new Position(shiftX, shiftY);
    }
}
