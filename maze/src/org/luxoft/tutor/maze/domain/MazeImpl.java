package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;

public class MazeImpl extends Maze {

    MazeImpl() {
		super();
    }

    @Override
    public Room makeRoom(final int number) {
        final Room room = new RoomImpl(number);
        addRoom(room);
        return room;
    }

}
