package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.GraphicsEngine;
import org.luxoft.tutor.maze.Rectangle;
import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.Registrar;

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
        persist("door", new DoorImpl());
        persist("magicDoor", new DoorImpl() {
            @Override
            public void draw(Rectangle rectangle) {
                GraphicsEngine graphicsEngine = Registrar.getInstance().get("GraphicsEngine");
                graphicsEngine.drawImage(rectangle, "magicDoor.jpg");
            }
        });
        persist("wall", new WallImpl());
    }

    public static MapSiteFactory getInstance() {
        return instance;
    }

}
