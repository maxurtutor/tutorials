package org.luxoft.tutor.maze;

import java.util.EnumMap;
import java.util.Map;

public final class Room extends MapSite {

	private Integer roomNumber;

    private Map<Direction, MapSite> sites = new EnumMap<Direction, MapSite>(Direction.class);

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Room(final int number) {
		super();
		this.roomNumber = number;
	}

	public MapSite getSide(final Direction side) {
		return sites.get(side);
	}

	public void setSide(final Direction side, final MapSite site) {
		sites.put(side, site);
	}

    public void enter() {
        // TODO Auto-generated method stub
    }


}
