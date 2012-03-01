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

    public Cell(final Integer number) {
        assert(number != null);
        this.number = number;
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    protected Cell() {
        this.number = null;
    }

    public Integer getNumber() {
        return number;
    }

    public MapSite getSide(final Side side) {
        return sites.get(side);
    }

    public void setSide(final Side side, final MapSite site) {
        sites.put(side, site);
    }

    public abstract void draw();

}
