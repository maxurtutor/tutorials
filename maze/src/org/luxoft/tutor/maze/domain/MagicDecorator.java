package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.MapSite;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>3/1/12</pre>
 */
public class MagicDecorator extends Door {

    private final MapSite site;

    public MagicDecorator(MapSite site) {
        super();
        this.site = site;
    }

    @Override
    public void enter() {
        site.enter();
    }

    @Override
    public String getType() {
        return "magic" + site.getType();
    }
}
