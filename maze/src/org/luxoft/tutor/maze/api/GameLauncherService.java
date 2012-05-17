package org.luxoft.tutor.maze.api;

public class GameLauncherService {

    public GameLauncherService() {
    }

    void setStartPosition(final Maze maze, final Player player) {
        player.setCurrentPosition(maze.getFirstRoom());
    }

}