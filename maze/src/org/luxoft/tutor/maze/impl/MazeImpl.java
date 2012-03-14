package org.luxoft.tutor.maze.impl;

import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;

public final class MazeImpl extends Maze {

    private final MapSiteFactory mapSiteFactory = new MapSiteFactoryImpl();

    public Room makeRoom(final int number) {
        final Room room = mapSiteFactory.makeRoom(number);
        addRoom(room);
        return room;
    }
}
