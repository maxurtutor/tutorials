package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.Maze;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class GameImpl extends Game {

    static {
        Game.setInstance(new GameImpl());    // TODO
    }

    protected GameImpl() {
    }

    public Maze createMaze() {
        return null;  //TODO
    }

}
