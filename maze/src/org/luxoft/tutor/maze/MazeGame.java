package org.luxoft.tutor.maze;

public final class MazeGame {

     public final Maze createMaze() {

        final Maze maze = new Maze();

        final Room r1 = new Room(1);
        maze.addRoom(r1);

        final Room r2 = new Room(2);
        maze.addRoom(r2);

        final Door d = new Door(r1, r2);

        r1.setSide(Direction.NORTH, new Wall());
        r1.setSide(Direction.EAST, d);
        r1.setSide(Direction.SOUTH, new Wall());
        r1.setSide(Direction.WEST, new Wall());

        r2.setSide(Direction.NORTH, new Wall());
        r2.setSide(Direction.EAST, new Wall());
        r2.setSide(Direction.SOUTH, new Wall());
        r2.setSide(Direction.WEST, d);

        return maze;
    }
}