package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.api.Direction;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.impl.DoorImpl;
import org.luxoft.tutor.maze.impl.MazeImpl;
import org.luxoft.tutor.maze.impl.WallImpl;

public final class MazeGame {

    public final Maze createMaze() {

        final Maze maze = makeMaze();

        final Room r1 = maze.makeRoom(1);
        final Room r2 = maze.makeRoom(2);

        final Door d = makeDoor(r1, r2);

        r1.setSide(Direction.NORTH, makeWall());
        r1.setSide(Direction.EAST, d);
        r1.setSide(Direction.SOUTH, makeWall());
        r1.setSide(Direction.WEST, makeWall());

        r2.setSide(Direction.NORTH, makeWall());
        r2.setSide(Direction.EAST, makeWall());
        r2.setSide(Direction.SOUTH, makeWall());
        r2.setSide(Direction.WEST, d);

        return maze;
    }

    private MazeImpl makeMaze() {
        return new MazeImpl();
    }

    private WallImpl makeWall() {
        return new WallImpl();
    }

    private DoorImpl makeDoor(final Room r1, final Room r2) {
        return new DoorImpl(r1, r2);
    }

}