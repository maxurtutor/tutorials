package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class MazeBuilder <T extends Maze> {

    private T maze;

    private MapSiteFactory factory;

    public MazeBuilder() {
        this.maze = makeMaze();
        this.factory = makeFactory();
    }

    public T build() {
        return maze;
    }

    public MazeBuilder addRoom(final String type, int id) {
        maze.addCell(makeRoom(type, id));
        return this;
    }

    public MazeBuilder addMaze(final String type, int id) {
        final Cell result = this.maze.romNo(id);
        assert (result == null);
        final MapSite site = factory.getMapSite(type);
        assert (site != null && site instanceof Maze);
        final Maze cell = (Maze) site;
        cell.setNumber(id);
        this.maze.addCell(cell);
        return this;
    }

    public MazeBuilder addDoor(final String type, int room1, final Side side, int room2) {
        final Cell cell1 = maze.romNo(room1);
        final Cell cell2 = maze.romNo(room2);
        final Door door = makeDoor(type, cell1, cell2);
        cell1.setSide(side, door);
        cell2.setSide(side.opposite(), door);
        return this;
    }


    public MazeBuilder bindRoom(int room1, final Side side, int room2) {
        getRoom(room1).setSide(side, getRoom(room2));
        getRoom(room2).setSide(side.opposite(), getRoom(room1));
        return this;
    }

    public Door makeDoor(final String type, final Cell room1, final Cell room2) {
        final MapSite site = factory.getMapSite(type);
        assert (site != null && site instanceof Door);
        final Door result = (Door) site;
        result.init(room1, room2);
        return result;
    }

    private Room getRoom(int room) {
        final Cell site = maze.romNo(room);
        assert (site != null && site instanceof Room);
        return (Room) site;
    }

    private Room makeRoom(final String type, int id) {
        final MapSite site = factory.getMapSite(type);
        assert (site != null && site instanceof Room);
        final Room cell = (Room) site;
        cell.setNumber(id);
        for (Side value : Side.values()) {
            cell.setSide(value, factory.makeWall());
        }
        return cell;
    }

    protected abstract MapSiteFactory makeFactory();

    protected abstract T makeMaze();

}
