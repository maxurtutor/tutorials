package org.luxoft.tutor.maze.api;

public enum Side {

    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3);

    final private int id;

    private Side(int id) {
        this.id = id;
    }

    public int id() {
        return this.id;
    }

    public Side oppositeSide() {
        switch (this) {
            case EAST: return WEST;
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            default: assert false: "Unknown side";
                return null;
        }
    }

}
