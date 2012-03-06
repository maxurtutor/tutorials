package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.api.Direction;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.impl.DoorImpl;
import org.luxoft.tutor.maze.impl.MazeImpl;
import org.luxoft.tutor.maze.impl.RoomImpl;
import org.luxoft.tutor.maze.impl.WallImpl;

public final class MazeGame {

     public final Maze createMaze() {

        final Maze maze = new MazeImpl();

        final Room r1 = new RoomImpl(1);
        maze.addRoom(r1);

        final Room r2 = new RoomImpl(2);
        maze.addRoom(r2);

        final Door d = new DoorImpl(r1, r2);

        r1.setSide(Direction.NORTH, new WallImpl());
        r1.setSide(Direction.EAST, d);
        r1.setSide(Direction.SOUTH, new WallImpl());
        r1.setSide(Direction.WEST, new WallImpl());

        r2.setSide(Direction.NORTH, new WallImpl());
        r2.setSide(Direction.EAST, new WallImpl());
        r2.setSide(Direction.SOUTH, new WallImpl());
        r2.setSide(Direction.WEST, d);

        return maze;
    }
}