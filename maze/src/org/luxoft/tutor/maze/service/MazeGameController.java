package org.luxoft.tutor.maze.service;

import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.Maze;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class MazeGameController {

    public void newGame() {
        final Maze maze = Game.getInstance().createMaze();
    }

}
