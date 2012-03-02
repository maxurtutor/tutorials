package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.MazeLoader;
import org.luxoft.tutor.maze.api.Side;

public class MazeLoaderImpl extends MazeLoader {

    @Override
    public Maze load(int id) {
        switch (id) {
            case 0:
                return load0();
            case 3:
                return load3();
            default:
                return null;
        }
    }

    private Maze load0() {
        return new MazeBuilderImpl()
                .addRoom(1)
                .addRoom(2)
                .addDoor("door", 1, 2, Side.EAST)
                .addMaze(3)
                .addDoor("magicDoor", 1, 3, Side.NORTH)
                .build();
    }

    private Maze load3() {
        return new MazeBuilderImpl()
                .addRoom(11)
                .addRoom(12)
                .addDoor("door", 11, 12, Side.EAST)
                .build();
    }
}