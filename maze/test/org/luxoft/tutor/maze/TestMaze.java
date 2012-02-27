package org.luxoft.tutor.maze;

import org.junit.Assert;
import org.junit.Test;

public class TestMaze {

    @Test
    public void testMazeBuild() throws Exception {
        Maze maze = new Maze();
        Room r1 = new Room(1);
        maze.addRoom(r1);
        Room r2 = new Room(2);
        maze.addRoom(r2);
        Door d = new Door(r1, r2);

        r1.setSide(Room.NORTH, new Wall());
        r1.setSide(Room.EAST, d);
        r1.setSide(Room.SOUTH, new Wall());
        r1.setSide(Room.WEST, new Wall());

        r2.setSide(Room.NORTH, new Wall());
        r2.setSide(Room.EAST, new Wall());
        r2.setSide(Room.SOUTH, new Wall());
        r2.setSide(Room.WEST, d);

        Assert.assertEquals(maze.romNo(1), d.otherSideFrom(r2));
    }

}
