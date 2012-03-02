package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/2/12</pre>
 */
public class MazeProxy extends Maze {

    private Maze maze = null;

    @Override
    public Room makeRoom(int number) {
        return getMaze().makeRoom(number);
    }

    @Override
    public void enter() {
        getMaze().enter();
    }

    public Maze getMaze() {
        if (maze == null) {
            final MazeLoader loader = Registrar.getInstance().get("MazeLoader");
            maze = loader.load(getNumber());
        }
        return maze;
    }

}
