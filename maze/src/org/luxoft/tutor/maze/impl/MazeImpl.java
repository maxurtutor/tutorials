package org.luxoft.tutor.maze.impl;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;

public final class MazeImpl extends Maze {

    public Room makeRoom(final int number) {
        final Room room = new RoomImpl(number);
        addRoom(room);
        return room;
    }
}
