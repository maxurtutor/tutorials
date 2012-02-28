package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Game {
    
    private static Game instance = null;

    protected Game() {
    }

    public static Game getInstance() {
        return instance;
    }

    public static void setInstance(final Game game) {
        instance = game;
    }

    public abstract Maze createMaze();

}
