package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Rectangle;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Room;

public class DoorImpl extends Door {

    public DoorImpl(final Room room1, final Room room2) {
		super(room1, room2);
	}

    public DoorImpl() {

    }

    @Override
    public void enter() {
		// TODO Auto-generated method stub
	}

    @Override
    public void draw(final Rectangle rectangle) {

    }

}
