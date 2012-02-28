package org.luxoft.tutor.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.domain.DoorImpl;
import org.luxoft.tutor.maze.domain.MazeImpl;
import org.luxoft.tutor.maze.domain.WallImpl;

public class TestMaze {

    @Before
    public void setUp() {
        final Game game = new Game() {

            public Maze createMaze() {
                final Maze maze = new MazeImpl();

                final Room room1 = maze.makeRoom(1);
                final Room room2 = maze.makeRoom(2);

                final Door door = new DoorImpl(room1, room2);

                room1.setSide(Room.NORTH, new WallImpl());
                room1.setSide(Room.EAST, door);
                room1.setSide(Room.SOUTH, new WallImpl());
                room1.setSide(Room.WEST, new WallImpl());

                room2.setSide(Room.NORTH, new WallImpl());
                room2.setSide(Room.EAST, new WallImpl());
                room2.setSide(Room.SOUTH, new WallImpl());
                room2.setSide(Room.WEST, door);
                return maze;
            }
        };
        Game.setInstance(game);
    }

    @Test
    public void testMazeBuild() throws Exception {
        final Maze maze = Game.getInstance().createMaze();
        final Room r1 = maze.romNo(1);
        final Room r2 = maze.romNo(2);
        final Door d = (Door) r2.getSide(Room.WEST);
        Assert.assertEquals(r1, d.otherSideFrom(r2));
    }


}
