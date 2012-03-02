package org.luxoft.tutor.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luxoft.tutor.maze.api.Cell;
import org.luxoft.tutor.maze.api.Door;
import org.luxoft.tutor.maze.api.Game;
import org.luxoft.tutor.maze.api.GraphicsEngine;
import org.luxoft.tutor.maze.api.Maze;
import org.luxoft.tutor.maze.api.MazeLoader;
import org.luxoft.tutor.maze.api.Rectangle;
import org.luxoft.tutor.maze.api.Registrar;
import org.luxoft.tutor.maze.api.Side;
import org.luxoft.tutor.maze.api.Wall;
import org.luxoft.tutor.maze.domain.MapSiteImageImpl;
import org.luxoft.tutor.maze.domain.MazeLoaderImpl;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestMaze {

    @Mock
    private GraphicsEngine graphicsEngine;

    @Spy
    private MazeLoaderImpl loader = new MazeLoaderImpl();

    @Before
    public void setUp() {
        final Game game = new Game() {

            public Maze createMaze() {
                final MazeLoader loader = Registrar.getInstance().get("MazeLoader");
                return loader.load(0);
            }
        };
        Registrar.getInstance().persist("GraphicsEngine", graphicsEngine);
        Registrar.getInstance().persist("MapSiteImpl", new MapSiteImageImpl());
        Registrar.getInstance().persist("MazeLoader", loader);
        Game.setInstance(game);
    }

    @Test
    public void testMazeBuild() throws Exception {
        final Maze maze = Game.getInstance().createMaze();
        final Cell r1 = maze.romNo(1);
        final Cell r2 = maze.romNo(2);
        final Door d = r2.getSide(Side.WEST);
        Assert.assertEquals(r1, d.otherSideFrom(r2));
    }

    @Test
    public void testMazeDraw() throws Exception {
        final Maze maze = Game.getInstance().createMaze();
        maze.draw();
        verify(graphicsEngine).drawImage((Rectangle) anyObject(), eq("magicDoor.jpg"));
    }

    @Test
    public void testWallAsFlyweight() throws Exception {
        final Maze maze = Game.getInstance().createMaze();
        final Cell r1 = maze.romNo(1);
        final Wall w1 = r1.getSide(Side.SOUTH);
        final Wall w2 = r1.getSide(Side.WEST);
        Assert.assertSame(w1, w2);
    }

    @Test
    public void testMazeAsProxy() throws Exception {
        final Maze maze = Game.getInstance().createMaze();
        verify(loader).load(0);
        maze.romNo(3).enter();
        verify(loader).load(3);
    }

}
