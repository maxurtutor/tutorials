package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.MazeDirector;
import org.luxoft.tutor.maze.api.Side;

public class MazeLoaderImpl extends MazeDirector {

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
                .addRoom("room" ,1)
                .addRoom("room" ,2)
                .addDoor("door", 1, Side.EAST, 2)
                .addMaze("maze" ,3)
                .addDoor("magicDoor", 1, Side.NORTH, 3)
                .build();
    }

    private Maze load3() {
        return new MazeBuilderImpl()
                .addRoom("room" ,11)
                .addRoom("room" ,12)
                .addDoor("door", 11, Side.EAST, 12)
                .build();
    }
}