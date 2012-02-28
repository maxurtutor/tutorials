package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.MazeBuilder;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;

import static org.luxoft.tutor.maze.api.Room.*;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class MazeBuilderImpl extends MazeBuilder {

    private final Maze maze;

    public MazeBuilderImpl() {
        this.maze = new MazeImpl();
    }

    @Override
    public MazeBuilder addRoom(int room1) {
        getRoom(room1);
        return this;
    }

    @Override
    public MazeBuilder addRoom(int room1, int room2, int side) {
        getRoom(room1).setSide(side, getRoom(room2));
        getRoom(room2).setSide(oppositeSide(side), getRoom(room1));
        return this;
    }

    @Override
    public MazeBuilder addDoor(int room1, int room2, int side) {
        final DoorImpl door = new DoorImpl(getRoom(room1), getRoom(room2));
        getRoom(room1).setSide(side, door);
        getRoom(room2).setSide(oppositeSide(side), door);
        return this;
    }

    @Override
    public Maze build() {
        return this.maze;
    }

    private int oppositeSide(int side) {
        switch (side) {
            case EAST: return WEST;
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            default: assert false: "Unknown side";
                return -1;
        }
    }

    private Room getRoom(int room) {
        final Room result = this.maze.romNo(room);
        return (result == null) ? makeRoom(room) : result;
    }

    private Room makeRoom(int room) {
        final Room result = this.maze.makeRoom(room);
        result.setSide(EAST, makeWall());
        result.setSide(NORTH, makeWall());
        result.setSide(SOUTH, makeWall());
        result.setSide(WEST, makeWall());
        return result;
    }

    private WallImpl makeWall() {
        return new WallImpl();
    }

}
