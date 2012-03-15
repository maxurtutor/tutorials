package org.luxoft.tutor.maze.api;

import org.luxoft.tutor.maze.impl.Position;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/14/12</pre>
 */
public abstract class MazeBuilder<T> {

    public abstract T build();

    public abstract MazeBuilder<T> addRoom(int number, Position at);

    public abstract MazeBuilder<T> bindWithDoor(int number1, int number2);

    public abstract MazeBuilder<Maze> bind(int number1, int number2);
}
