package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.MazeDirector;
import org.luxoft.tutor.maze.impl.MazeDirectorImpl;

public final class MazeGame {

    private final MazeDirector director = new MazeDirectorImpl();

    public final Maze createMaze() {
        return director.createMaze();
    }

}