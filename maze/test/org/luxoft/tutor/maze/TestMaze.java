package org.luxoft.tutor.maze;

import org.junit.Before;
import org.junit.Test;
import org.luxoft.tutor.maze.api.Direction;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.impl.DoorImpl;
import org.luxoft.tutor.maze.impl.WallImpl;

import static org.junit.Assert.*;

public class TestMaze {

    private final MazeGame mazeGame = new MazeGame();

    private Maze maze;

    @Before
    public void setUp() throws Exception {
        maze = mazeGame.createMaze();
    }

    @Test
    public void shouldBeBuildRoom1() throws Exception {
        assertEquals(new Integer(1), maze.romNo(1).getRoomNumber());
    }

    @Test
    public void shouldBeBuildRoom2() throws Exception {
        assertEquals(new Integer(2), maze.romNo(2).getRoomNumber());
    }

    @Test
    public void shouldBeBuildWall() throws Exception {
        assertTrue(maze.romNo(1).getSide(Direction.WEST) instanceof WallImpl);
    }


    @Test
    public void shouldBeBuildDoor() throws Exception {
        assertTrue(maze.romNo(1).getSide(Direction.EAST) instanceof DoorImpl);
    }

    @Test
    public void shouldBeBuildDoorBetweenRoom1AndRoom2() throws Exception {
        assertEquals(new Integer(2),
                ((Door) maze.romNo(1).getSide(Direction.EAST)).otherSideFrom(maze.romNo(1)).getRoomNumber());
    }

}
