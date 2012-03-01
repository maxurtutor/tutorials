package org.luxoft.tutor.maze.api;

import org.luxoft.tutor.maze.domain.MapSiteImageImpl;

public abstract class MapSite implements Cloneable {

    private final MapSiteImpl mapSiteImpl = new MapSiteImageImpl();

    public abstract void enter();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void draw(final Rectangle rectangle) {
        mapSiteImpl.draw(getType(), rectangle);
    }

    protected String getType() {
        return "unknown";
    }
}
