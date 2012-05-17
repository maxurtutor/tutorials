package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/1/12</pre>
 */
public abstract class Cell extends MapSite {

    protected  Integer number;

    private Map<Side, MapSite> sites = new HashMap<Side, MapSite>(4);

    protected void setNumber(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @SuppressWarnings("unchecked")
    public <T extends MapSite> T getSide(final Side side) {
        try {
            return (T) sites.get(side);
        } catch (ClassCastException e) {
            throw new AssertionError(e);
        }
    }

    public void setSide(final Side side, final MapSite site) {
        sites.put(side, site);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        final Cell result = (Cell) super.clone();
        result.sites = new HashMap<Side, MapSite>(4);
        return result;
    }

    public abstract void draw();

    public abstract boolean isRoom();
}
