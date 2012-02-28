package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.maze.api.MapSiteFactory;
import org.luxoft.tutor.maze.api.MazeBuilder;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class MazeBuilderImpl extends MazeBuilder {

    @Override
    protected MapSiteFactory makeFactory() {
        return MapSiteFactoryImpl.getInstance();
    }

    @Override
    protected MazeImpl makeMaze() {
        return new MazeImpl();
    }

}
