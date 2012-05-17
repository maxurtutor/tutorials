package org.luxoft.tutor.maze.service;

import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.Side;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class MazeGameController {

    private Game game;

    public void newGame() {
        game = Game.getInstance();
        game.registerPlayer("x");
        game.start();
    }

    public void move(String playerId, Side side) {
        game.move(playerId, side);
    }

}
