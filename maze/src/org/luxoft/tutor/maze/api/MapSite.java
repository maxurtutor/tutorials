package org.luxoft.tutor.maze.api;

public abstract class MapSite implements Cloneable {

	public abstract void enter();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
