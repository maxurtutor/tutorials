package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0 07.03.12
 */
public abstract class Maze {

    protected Map<Integer, Room> rooms;

    public Maze() {
        super();
        this.rooms = new HashMap<Integer, Room>();
    }

    public Room romNo(final int number) {
        return rooms.get(number);
    }

    public void addRoom(final Room room) {
        rooms.put(room.getRoomNumber(), room);
    }
}
