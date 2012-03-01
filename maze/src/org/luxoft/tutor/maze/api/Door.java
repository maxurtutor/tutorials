package org.luxoft.tutor.maze.api;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Door extends MapSite {

    private boolean open = false;

    private Cell cell1;

    private Cell cell2;

    protected Door() {
    }

    protected Door(final Cell cell1, final Cell cell2) {
        init(cell1, cell2);
    }

    public boolean isOpen() {
        return open;
    }

    public void open(boolean open) {
        this.open = open;
    }

    public Cell otherSideFrom(final Cell room) {
        assert (null != room);
        if (cell1.equals(room)) {
            return cell2;
        } else if (cell2.equals(room)) {
            return cell1;
        } else {
            return null;
        }
    }

    public void init(final Cell cell1, final Cell room2) {
        assert (null != cell1 && null != room2);
        this.cell1 = cell1;
        this.cell2 = room2;
    }
}
