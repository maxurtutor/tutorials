package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/2/12</pre>
 */
public class MazeProxy extends Maze {

    private Maze maze = null;

    @Override
    public void enter(final Player player) {
        getMaze().enter(player);
    }

    public Maze getMaze() {
        if (maze == null) {
            final MazeDirector loader = Registrar.getInstance().get("MazeDirector");
            maze = loader.load(getNumber());
        }
        return maze;
    }

}
