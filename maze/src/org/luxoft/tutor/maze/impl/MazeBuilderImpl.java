package org.luxoft.tutor.maze.impl;

import org.luxoft.tutor.maze.api.Direction;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.MazeBuilder;
import org.luxoft.tutor.maze.api.Room;

import java.util.HashMap;

public class MazeBuilderImpl extends MazeBuilder<Maze> {

    private final MapSiteFactory factory = new MapSiteFactoryImpl();
    
    private final HashMap<Integer, Position> positions = new HashMap<Integer, Position>(); 

    private final Maze maze;

    public MazeBuilderImpl() {
        maze = factory.makeMaze();
    }

    @Override
    public Maze build() {
        return maze;
    }

    @Override
    public MazeBuilder<Maze> addRoom(final int number, final Position position) {
        final Room room = factory.makeRoom(number);
        maze.addRoom(room);
        for (Direction direction: Direction.values()) {
            room.setSide(direction, factory.makeWall());
        }
        positions.put(number, position);
        return this;
    }

    @Override
    public MazeBuilder<Maze> bindWithDoor(int number1, int number2) {
        final Room r1 = maze.romNo(number1);
        final Room r2 = maze.romNo(number2);
        final Door door = factory.makeDoor(r1, r2);
        final Position pos1 = positions.get(number1);
        final Position pos2 = positions.get(number2);
        final Direction side = pos1.directionTo(pos2);
        r1.setSide(side, door);
        r2.setSide(side.opposite(), door);
        return this;
    }

    @Override
    public MazeBuilder<Maze> bind(int number1, int number2) {
        final Room r1 = maze.romNo(number1);
        final Room r2 = maze.romNo(number2);
        final Position pos1 = positions.get(number1);
        final Position pos2 = positions.get(number2);
        final Direction side = pos1.directionTo(pos2);
        r1.setSide(side, r2);
        r2.setSide(side.opposite(), r1);
        return this;
    }


}