package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Maze {

    private Map<Integer, Room> rooms = new HashMap<Integer, Room>();

    public Maze() {
        super();
    }

    public Room romNo(int number) {
        return rooms.get(number);
    }

    protected void addRoom(final Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public abstract Room makeRoom(int number);
}
