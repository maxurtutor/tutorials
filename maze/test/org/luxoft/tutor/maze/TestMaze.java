package org.luxoft.tutor.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.domain.DoorFactory;
import org.luxoft.tutor.maze.domain.DoorImpl;
import org.luxoft.tutor.maze.domain.MazeBuilderImpl;

public class TestMaze {

    @Before
    public void setUp() {
        DoorFactory.getInstance().persist("door", new DoorImpl());
        DoorFactory.getInstance().persist("magicDoor", new DoorImpl() {});
        final Game game = new Game() {

            public Maze createMaze() {
                return new MazeBuilderImpl()
                        .addRoom(1)
                        .addRoom(2)
                        .addDoor("door", 1, 2, Room.EAST)
                        .addRoom(3)
                        .addDoor("magicDoor", 1, 3, Room.NORTH)
                        .build();
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
