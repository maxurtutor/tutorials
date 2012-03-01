package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.GraphicsEngine;
import org.luxoft.tutor.maze.api.MapSiteImpl;
import org.luxoft.tutor.maze.api.Rectangle;
import org.luxoft.tutor.maze.api.Registrar;

public class MapSiteImageImpl extends MapSiteImpl {

    @Override
    public void draw(final String type, final Rectangle rectangle) {
        final GraphicsEngine graphicsEngine = Registrar.getInstance().get("GraphicsEngine");
        if ("magicDoor".equals(type)) {
            graphicsEngine.drawImage(rectangle, "magicDoor.jpg");
        }
    }
}