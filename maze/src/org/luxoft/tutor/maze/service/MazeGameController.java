package org.luxoft.tutor.maze.service;

import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.domain.GameImpl;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class MazeGameController {

    private final Game game = new GameImpl(); //TODO

    public void newGame() {
        final Maze maze = game.createMaze();
    }

}
