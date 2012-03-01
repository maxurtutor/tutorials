package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;

public class MazeImpl extends Maze {

    public MazeImpl(final Integer number) {
        super(number);
    }

    public MazeImpl() {
        super();
    }

    @Override
    public Room makeRoom(final int number) {
        final Room room = new RoomImpl(number);
        addCell(room);
        return room;
    }

    @Override
    public void enter() {
        //Todo
    }
}
