package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Game {

    private static Game instance = null;

    private Map<String, Player> players = new HashMap<String, Player>();

    private Maze maze;

    private final GameLauncherService gameLauncher = new GameLauncherService();

    protected Game() {
    }

    public static Game getInstance() {
        return instance;
    }

    public static void setInstance(final Game game) {
        instance = game;
    }

    public void move(final String playerId, final Side side) {
        this.players.get(playerId).moveTo(side);
    }

    public void start() {
        this.maze = createMaze();
        startGame();
    }

    private void startGame() {
        for (Player player : this.players.values()) {
            this.gameLauncher.setStartPosition(this.maze, player);
        }
    }

    public void registerPlayer(final String playerId) {
        this.players.put(playerId, makePlayer(playerId));
    }

    public Player getPlayer(final String playerId) {
        return this.players.get(playerId);
    }

    public Maze createMaze() {
        final MazeDirector loader = Registrar.getInstance().get("MazeDirector");
        return loader.load(0);
    }

    public  Maze getMaze() {
        return maze;
    }

    protected abstract Player makePlayer(final String playerId);

}
