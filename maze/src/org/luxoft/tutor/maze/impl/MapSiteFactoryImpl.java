package org.luxoft.tutor.maze.impl;

import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.api.Wall;

public class MapSiteFactoryImpl extends MapSiteFactory {

    @Override
    public Maze makeMaze() {
        return new MazeImpl();
    }

    @Override
    public Wall makeWall() {
        return new WallImpl();
    }

    @Override
    public Door makeDoor(final Room r1, final Room r2) {
        return new DoorImpl(r1, r2);
    }

    @Override
    public Room makeRoom(final int number) {
        return new RoomImpl(number);
    }

}