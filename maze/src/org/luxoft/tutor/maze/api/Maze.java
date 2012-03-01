package org.luxoft.tutor.maze.api;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public abstract class Maze extends Cell {

    private SortedMap<Integer, Cell> cells = new TreeMap<Integer, Cell>();

    public Maze(final Integer number) {
        super(number);
    }

    public Maze() {
        super();
    }

    public Cell romNo(int number) {
        return cells.get(number);
    }

    protected void addCell(final Cell cell) {
        cells.put(cell.getNumber(), cell);
    }

    public abstract Room makeRoom(int number);

    @Override
    public void draw() {
        cells.get(cells.firstKey()).draw();
    }

    public void setNumber(int number) {
        super.setNumber(number);
    }
}
