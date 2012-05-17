package org.luxoft.tutor.maze.api;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/12</pre>
 */
public class Maze extends Cell {

    private SortedMap<Integer, Cell> cells = new TreeMap<Integer, Cell>();

    public Cell romNo(int number) {
        return cells.get(number);
    }

    protected void addCell(final Cell cell) {
        cells.put(cell.getNumber(), cell);
    }

    @Override
    public void draw() {
        cells.get(cells.firstKey()).draw();
    }

    @Override
    public boolean isRoom() {
        return false;
    }

    @Override
    public void enter(final Player player) {
        getFirstRoom().enter(player);
    }


    public void setNumber(int number) {
        super.setNumber(number);
    }

    public Room getFirstRoom() {
        for (Cell cell : cells.values()) {
            if (cell.isRoom()) {
                return (Room) cell;
            }
        }
        return null;
    }

}
