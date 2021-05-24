package net.mirwaldt.aoc.year2016.day01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        final EasterBunnyHQNavigator easterBunnyHQNavigator = new DefaultEasterBunnyHQNavigator();
        final String line = Files.readString(Path.of("input"), StandardCharsets.US_ASCII);
        final String[] tokens = line.split(",");
        for (String token : tokens) {
            final String trimmedToken = token.trim();
            if(trimmedToken.startsWith("L")) {
                easterBunnyHQNavigator.goLeft(parseIntFromToken(trimmedToken));
            } else if(trimmedToken.startsWith("R")) {
                easterBunnyHQNavigator.goRight(parseIntFromToken(trimmedToken));
            } else {
                throw new AssertionError();
            }
        }
        System.out.println(easterBunnyHQNavigator.getShortestDistance()); // result: 146
        System.out.println(easterBunnyHQNavigator.getShortestDistanceToFirstCircle()); // result: 131
    }

    private static int parseIntFromToken(String trimmedToken) {
        return Integer.parseInt(trimmedToken.substring(1));
    }
}
