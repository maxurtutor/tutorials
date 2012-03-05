package org.luxoft.tutor.maze.api;

public enum Side {

    NORTH {
        @Override
        public Side opposite() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Side opposite() {
            return NORTH;
        }
    },
    EAST {
        @Override
        public Side opposite() {
            return WEST;
        }
    },
    WEST {
        @Override
        public Side opposite() {
            return EAST;
        }
    };

    public abstract Side opposite();
}
