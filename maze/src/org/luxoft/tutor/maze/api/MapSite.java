package org.luxoft.tutor.maze.api;

public abstract class MapSite implements Cloneable {

    private final MapSiteImpl mapSiteImpl = Registrar.getInstance().get("MapSiteImpl");

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void draw(final Rectangle rectangle) {
        mapSiteImpl.draw(getType(), rectangle);
    }

    public String getType() {
        return "unknown";
    }

    public abstract void enter(final Player player);
}
