package org.luxoft.tutor.maze.impl;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.MazeBuilder;
import org.luxoft.tutor.maze.api.MazeDirector;

public class MazeDirectorImpl implements MazeDirector {

    public final Maze createMaze() {
        return makeBuilder()
                .addRoom(1, Position.at(2, 1))
                .addRoom(2, Position.at(1, 1))
                .bindWithDoor(1, 2)
                .build();
    }

    private MazeBuilder<Maze> makeBuilder() {
        return new MazeBuilderImpl();
    }

}