package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/14/12</pre>
 */
public abstract class MapSiteFactory {
    public abstract Maze makeMaze();

    public abstract Wall makeWall();

    public abstract Door makeDoor(Room r1, Room r2);

    public abstract Room makeRoom(int number);
}
