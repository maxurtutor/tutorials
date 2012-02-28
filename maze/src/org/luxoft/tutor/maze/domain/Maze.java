package org.luxoft.tutor.maze.domain;

import java.util.HashMap;
import java.util.Map;

public class Maze {

	private Map<Integer, Room> rooms;

	public Maze() {
		super();
		this.rooms = new HashMap<Integer, Room>();
	}

	public Room romNo(int number) {
		return rooms.get(number);
	}

    private void addRoom(Room room) {
		rooms.put(room.getRoomNumber(), room);
	}

    public Room makeRoom(final int number) {
        Room room = new Room(number);
        addRoom(room);
        return room;
    }

}
