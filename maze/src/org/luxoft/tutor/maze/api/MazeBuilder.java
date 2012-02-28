package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class MazeBuilder {

    public abstract MazeBuilder addRoom(int room1);

    public abstract MazeBuilder addRoom(int room1, int room2, int side);

    public abstract MazeBuilder addDoor(int room1, int room2, int side);

    public abstract Maze build();
}
