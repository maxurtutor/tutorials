package org.luxoft.tutor.maze;

import org.junit.Assert;
import org.junit.Test;
import org.luxoft.tutor.maze.domain.Door;
import org.luxoft.tutor.maze.domain.Maze;
import org.luxoft.tutor.maze.domain.Room;
import org.luxoft.tutor.maze.domain.Wall;

public class TestMaze {

    @Test
    public void testMazeBuild() throws Exception {
        final Maze maze = createMaze();
        final Room r1 = maze.romNo(1);
        final Room r2 = maze.romNo(2);
        final Door d = (Door) r2.getSide(Room.WEST);
        Assert.assertEquals(r1, d.otherSideFrom(r2));
    }

    private Maze createMaze() {
        final Maze maze = new Maze();

        final Room room1 = maze.makeRoom(1);
        final Room room2 = maze.makeRoom(2);

        final Door door = new Door(room1, room2);

        room1.setSide(Room.NORTH, new Wall());
        room1.setSide(Room.EAST, door);
        room1.setSide(Room.SOUTH, new Wall());
        room1.setSide(Room.WEST, new Wall());

        room2.setSide(Room.NORTH, new Wall());
        room2.setSide(Room.EAST, new Wall());
        room2.setSide(Room.SOUTH, new Wall());
        room2.setSide(Room.WEST, door);
        return maze;
    }

}
