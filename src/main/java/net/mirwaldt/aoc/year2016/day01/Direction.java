package net.mirwaldt.aoc.year2016.day01;

public enum Direction {
    UP(0, +1), RIGHT(+1, 0), DOWN(0, -1), LEFT(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case RIGHT:
                return UP;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
        }
        throw new AssertionError();
    }

    Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
        }
        throw new AssertionError();
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}
