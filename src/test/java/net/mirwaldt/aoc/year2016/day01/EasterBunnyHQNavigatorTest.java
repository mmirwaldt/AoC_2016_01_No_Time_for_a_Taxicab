package net.mirwaldt.aoc.year2016.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EasterBunnyHQNavigatorTest {
    private final EasterBunnyHQNavigator easterBunnyHQNavigator = new DefaultEasterBunnyHQNavigator();

    @Test
    void test_shortestDistance_1() {
        easterBunnyHQNavigator.goRight(2);
        easterBunnyHQNavigator.goLeft(3);
        assertEquals(5, easterBunnyHQNavigator.getShortestDistance());
    }

    @Test
    void test_shortestDistance_2() {
        easterBunnyHQNavigator.goRight(2);
        easterBunnyHQNavigator.goRight(2);
        easterBunnyHQNavigator.goRight(2);
        assertEquals(2, easterBunnyHQNavigator.getShortestDistance());
    }

    @Test
    void test_shortestDistance_3() {
        easterBunnyHQNavigator.goRight(5);
        easterBunnyHQNavigator.goLeft(5);
        easterBunnyHQNavigator.goRight(5);
        easterBunnyHQNavigator.goRight(3);
        assertEquals(12, easterBunnyHQNavigator.getShortestDistance());
    }

    @Test
    void test_shortestDistanceToFirstCircle() {
        easterBunnyHQNavigator.goRight(8);
        easterBunnyHQNavigator.goRight(4);
        easterBunnyHQNavigator.goRight(4);
        easterBunnyHQNavigator.goRight(8);
        assertEquals(4, easterBunnyHQNavigator.getShortestDistanceToFirstCircle());
    }
}
