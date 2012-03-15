package org.luxoft.tutor.maze.api;

public enum Direction {
    NORTH {
        @Override
        public Direction opposite() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Direction opposite() {
            return NORTH;
        }
    },
    EAST {
        @Override
        public Direction opposite() {
            return EAST;
        }
    },
    WEST {
        @Override
        public Direction opposite() {
            return WEST;
        }
    };

    public abstract Direction opposite();
}