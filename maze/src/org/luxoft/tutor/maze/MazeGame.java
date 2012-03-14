package org.luxoft.tutor.maze;

import org.luxoft.tutor.maze.api.Direction;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.impl.MapSiteFactoryImpl;

public final class MazeGame {

    private final MapSiteFactory mapSiteFactory = new MapSiteFactoryImpl();

    public final Maze createMaze() {

        final Maze maze = mapSiteFactory.makeMaze();

        final Room r1 = maze.makeRoom(1);
        final Room r2 = maze.makeRoom(2);

        final Door d = mapSiteFactory.makeDoor(r1, r2);

        r1.setSide(Direction.NORTH, mapSiteFactory.makeWall());
        r1.setSide(Direction.EAST, d);
        r1.setSide(Direction.SOUTH, mapSiteFactory.makeWall());
        r1.setSide(Direction.WEST, mapSiteFactory.makeWall());

        r2.setSide(Direction.NORTH, mapSiteFactory.makeWall());
        r2.setSide(Direction.EAST, mapSiteFactory.makeWall());
        r2.setSide(Direction.SOUTH, mapSiteFactory.makeWall());
        r2.setSide(Direction.WEST, d);

        return maze;
    }

}