package org.luxoft.tutor.maze;

import java.util.HashMap;
import java.util.Map;

public final class Maze {

	private Map<Integer, Room> rooms;

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
