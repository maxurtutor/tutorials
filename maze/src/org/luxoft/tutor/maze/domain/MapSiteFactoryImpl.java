package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.MazeProxy;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class MapSiteFactoryImpl extends MapSiteFactory {

    static private final MapSiteFactory instance = new MapSiteFactoryImpl();

    private MapSiteFactoryImpl() {
        init();
    }

    @Override
    public void init() {
        persist("room", new RoomImpl());
        persist("door", new DoorImpl());
        persist("wall", new WallImpl());

        persist("magicDoor", new MagicDecorator(new DoorImpl()));
        persist("maze", new MazeProxy());
    }

    public static MapSiteFactory getInstance() {
        return instance;
    }

}
