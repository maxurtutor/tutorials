package org.luxoft.tutor.maze.domain;

public class Room extends MapSite {

	private Integer roomNumber;

	static public int NORTH = 0;
	static public int SOUTH = 1;
	static public int EAST = 2;
	static public int WEST = 3;

	private MapSite[] sites = new MapSite[4];

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Room(int number) {
		super();
		this.roomNumber = number;
	}

	public void enter() {
		// TODO Auto-generated method stub
	}

	public MapSite getSide(int side) {
		return sites[side];
	}

	public void setSide(int side, MapSite site) {
		sites[side] = site;
	}
}
