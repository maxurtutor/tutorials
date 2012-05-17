package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Player;
import org.luxoft.tutor.maze.api.Room;

public class RoomImpl extends Room {

    public RoomImpl() {
		super();
	}

    @Override
    public boolean isRoom() {
        return true;
    }

    @Override
    public void enter(final Player player) {
		player.setCurrentPosition(this);
	}

}
