package org.luxoft.tutor.maze.api;

import org.luxoft.tutor.maze.domain.MazeImpl;

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

    public MazeBuilder addRoom(int room1, int room2, Side side) {
        getRoom(room1).setSide(side, getRoom(room2));
        getRoom(room2).setSide(side.oppositeSide(), getRoom(room1));
        return this;
    }

    public MazeBuilder addDoor(final String id, int room1, int room2, Side side) {
        final Door door = factory.makeDoor(id, getRoom(room1), getRoom(room2));
        getRoom(room1).setSide(side, door);
        getRoom(room2).setSide(side.oppositeSide(), door);
        return this;
    }

    public Maze build() {
        return maze;
    }

    private Room getRoom(int room) {
        final Room result = maze.romNo(room);
        return (result == null) ? makeRoom(room) : result;
    }

    private Room makeRoom(int room) {
        final Room result = maze.makeRoom(room);
        for (Side value : Side.values()) {
            result.setSide(value, factory.makeWall());
        }
        return result;
    }

    protected abstract MapSiteFactory makeFactory();

    protected abstract MazeImpl makeMaze();
}
