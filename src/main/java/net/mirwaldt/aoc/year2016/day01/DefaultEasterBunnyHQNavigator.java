package net.mirwaldt.aoc.year2016.day01;

import java.util.BitSet;

import static java.lang.Math.abs;
import static net.mirwaldt.aoc.year2016.day01.Direction.UP;

public class DefaultEasterBunnyHQNavigator implements EasterBunnyHQNavigator {
    public final static int SIDE = 1000;
    public final static int CENTER_OFFSET = SIDE * SIDE;
    public final static int NO_CIRCLE_YET = SIDE + 1;
    private int x, y;
    private Direction direction = UP;
    private int visitedX = SIDE + 1, visitedY = SIDE + 1;
    private BitSet visited = new BitSet(2 * SIDE * 2 * SIDE);

    @Override
    public void goLeft(int steps) {
        direction = direction.turnLeft();
        go(steps);
    }

    @Override
    public void goRight(int steps) {
        direction = direction.turnRight();
        go(steps);
    }

    @Override
    public int getShortestDistance() {
        return abs(x) + abs(y);
    }

    @Override
    public int getShortestDistanceToFirstCircle() {
        if (visitedX == NO_CIRCLE_YET) {
            throw new RuntimeException("No circle yet.");
        } else {
            return abs(visitedX) + abs(visitedY);
        }
    }

    private void go(int steps) {
        if (visitedX == NO_CIRCLE_YET) {
            if(direction.dx() != 0) {
                for (int ix = 0; ix < steps; ix++) {
                    x += direction.dx();
                    if (isVisited(x, y)) {
                        visitedX = x;
                        visitedY = y;
                    } else {
                        setVisited(x, y);
                    }
                }
            }
            if(direction.dy() != 0) {
                for (int iy = 0; iy < steps; iy++) {
                    y += direction.dy();
                    if (isVisited(x, y)) {
                        visitedX = x;
                        visitedY = y;
                    } else {
                        setVisited(x, y);
                    }
                }
            }
        } else {
            x += direction.dx() * steps;
            y += direction.dy() * steps;
        }
    }

    private boolean isVisited(int x, int y) {
        return visited.get(CENTER_OFFSET + y * SIDE + x);
    }

    private void setVisited(int x, int y) {
        visited.set(CENTER_OFFSET + y * SIDE + x);
    }
}
