package org.luxoft.tutor.maze.api;

import org.luxoft.tutor.maze.domain.MazeImpl;

import static org.luxoft.tutor.maze.api.Room.EAST;
import static org.luxoft.tutor.maze.api.Room.NORTH;
import static org.luxoft.tutor.maze.api.Room.SOUTH;
import static org.luxoft.tutor.maze.api.Room.WEST;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class MazeBuilder {

    private Maze maze;

    private MapSiteFactory factory;

    public MazeBuilder() {
        this.maze = makeMaze();
        this.factory = makeFactory();
    }

    public MazeBuilder addRoom(int room1) {
        getRoom(room1);
        return this;
    }

    public MazeBuilder addRoom(int room1, int room2, int side) {
        getRoom(room1).setSide(side, getRoom(room2));
        getRoom(room2).setSide(oppositeSide(side), getRoom(room1));
        return this;
    }

    public MazeBuilder addDoor(final String id, int room1, int room2, int side) {
        final Door door = factory.makeDoor(id, getRoom(room1), getRoom(room2));
        getRoom(room1).setSide(side, door);
        getRoom(room2).setSide(oppositeSide(side), door);
        return this;
    }

    public Maze build() {
        return maze;
    }

    private int oppositeSide(int side) {
        switch (side) {
            case EAST:
                return WEST;
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            default:
                assert false : "Unknown side";
                return -1;
        }
    }

    private Room getRoom(int room) {
        final Room result = maze.romNo(room);
        return (result == null) ? makeRoom(room) : result;
    }

    private Room makeRoom(int room) {
        final Room result = maze.makeRoom(room);
        result.setSide(EAST, factory.makeWall());
        result.setSide(NORTH, factory.makeWall());
        result.setSide(SOUTH, factory.makeWall());
        result.setSide(WEST, factory.makeWall());
        return result;
    }

    protected abstract MapSiteFactory makeFactory();

    protected abstract MazeImpl makeMaze();
}
