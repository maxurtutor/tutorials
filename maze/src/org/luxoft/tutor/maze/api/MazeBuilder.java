package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class MazeBuilder <T extends Maze> {

    private T maze;

    private MapSiteFactory factory;

    public MazeBuilder() {
        this.maze = makeMaze();
        this.factory = makeFactory();
    }

    public MazeBuilder addRoom(int room1) {
        getRoom(room1);
        return this;
    }

    public MazeBuilder addRoom(int room1, int room2, final Side side) {
        getRoom(room1).setSide(side, getRoom(room2));
        getRoom(room2).setSide(side.oppositeSide(), getRoom(room1));
        return this;
    }

    public MazeBuilder addMaze(int id, final Maze maze) {
        final Cell result = maze.romNo(id);
        assert (result == null);
        maze.setNumber(id);
        maze.addCell(maze);
        return this;
    }

    public MazeBuilder addDoor(final String id, int room1, int room2, final Side side) {
        final Door door = factory.makeDoor(id, getRoom(room1), getRoom(room2));
        getRoom(room1).setSide(side, door);
        getRoom(room2).setSide(side.oppositeSide(), door);
        return this;
    }

    public T build() {
        return maze;
    }

    private Room getRoom(int room) {
        final Cell result = maze.romNo(room);
        assert (result == null || result instanceof Room);
        return (result == null) ? makeRoom(room) : (Room) result;
    }

    private Room makeRoom(int room) {
        final Room result = maze.makeRoom(room);
        for (Side value : Side.values()) {
            result.setSide(value, factory.makeWall());
        }
        return result;
    }

    protected abstract MapSiteFactory makeFactory();

    protected abstract T makeMaze();

}
