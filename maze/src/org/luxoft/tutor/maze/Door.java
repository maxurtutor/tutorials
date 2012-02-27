package org.luxoft.tutor.maze;

public class Door extends MapSite {

	private boolean open = false;
	private Room room1 = null;
	private Room room2 = null;

	public Door(Room room1, Room room2) {
		super();
		assert(null != room1 && null != room2);
		this.room1 = room1;
		this.room2 = room2;
	}

	public boolean isOpen() {
		return open;
	}

	public void enter() {
		// TODO Auto-generated method stub
	}

	public void open(boolean open) {
		this.open = open;
	}

	public Room otherSideFrom(Room room) {
        assert(null != room);
		if (room1.equals(room)) {
			return room2;
		} else if (room2.equals(room)) {
			return room1;
		} else {
			return null;
		}
	}
}
