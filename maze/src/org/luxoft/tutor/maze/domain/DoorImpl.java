package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Player;

public class DoorImpl extends Door {

    @Override
    public void enter(final Player player) {
	    super.otherSideFrom(player.getCurrentPosition()).enter(player);
	}

}
