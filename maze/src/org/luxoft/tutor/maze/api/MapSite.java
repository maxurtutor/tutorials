package org.luxoft.tutor.maze.api;

import org.luxoft.tutor.maze.Rectangle;

public abstract class MapSite implements Cloneable {

	public abstract void enter();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void draw(final Rectangle rectangle) {

    }
}
