package org.luxoft.tutor.maze.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class MapSiteFactory {

    private final Map<String, MapSite> sites = new HashMap<String, MapSite>();

    public abstract void init();

    protected void persist(final String id, final MapSite prototype) {
        sites.put(id, prototype);
    }

    public Wall makeWall() {
        final MapSite site = sites.get("wall");
        assert (site != null && site instanceof Wall);
        return (Wall) site;
    }

    public MapSite getMapSite(final String type) {
        try {
            return (MapSite) sites.get(type).clone();
        } catch (CloneNotSupportedException e) {
            assert false;
            return null;
        }
    }

}
