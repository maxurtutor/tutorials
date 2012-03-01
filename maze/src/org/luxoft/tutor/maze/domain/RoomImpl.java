package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Rectangle;
import org.luxoft.tutor.maze.api.Room;
import org.luxoft.tutor.maze.api.Side;

public class RoomImpl extends Room {

    public RoomImpl(final Integer number) {
		super(number);
	}

	@Override
    public void enter() {
		// TODO Auto-generated method stub
	}

    @Override
    public void draw() {
        for (Side value : Side.values()) {
            getSide(value).draw(getRectangle(value));
        }
    }

    private Rectangle getRectangle(final Side value) {
        // TODO Auto-generated method stub
        return null;
    }
}
