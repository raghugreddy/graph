package com.graph.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class IslandCountTest {

    /*
    const grid = [
        ['W', 'L', 'W', 'W', 'W'],
        ['W', 'L', 'W', 'W', 'W'],
        ['W', 'W', 'W', 'L', 'W'],
        ['W', 'W', 'L', 'L', 'W'],
        ['L', 'W', 'W', 'L', 'L'],
        ['L', 'L', 'W', 'W', 'W'],
    ];

    islandCount(grid); // -> 3
    */
    @Test
    public void testGetIslandCount01() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("W", "L", "W", "W", "W"),
            Arrays.asList("W", "L", "W", "W", "W"),
            Arrays.asList("W", "W", "W", "L", "W"),
            Arrays.asList("W", "W", "L", "L", "W"),
            Arrays.asList("L", "W", "W", "L", "L"),
            Arrays.asList("L", "L", "W", "W", "W")
        );

        IslandCount islandCount = new IslandCount();
        int count = islandCount.getIslandCount(grid);

        assertEquals(3, count);
    }

    /*
        const grid = [
            ['L', 'W', 'W', 'L', 'W'],
            ['L', 'W', 'W', 'L', 'L'],
            ['W', 'L', 'W', 'L', 'W'],
            ['W', 'W', 'W', 'W', 'W'],
            ['W', 'W', 'L', 'L', 'L'],
        ];

        islandCount(grid); // -> 4
    */

    @Test
    public void testGetIslandCount02() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("L", "W", "W", "L", "W"),
            Arrays.asList("L", "W", "W", "L", "L"),
            Arrays.asList("W", "L", "W", "L", "W"),
            Arrays.asList("W", "W", "W", "W", "W"),
            Arrays.asList("W", "W", "L", "L", "L")
        );

        IslandCount islandCount = new IslandCount();
        int count = islandCount.getIslandCount(grid);

        assertEquals(4, count);
    }

    /*
        const grid = [
            ['L', 'L', 'L'],
            ['L', 'L', 'L'],
            ['L', 'L', 'L'],
        ];

        islandCount(grid); // -> 1
    */

    @Test
    public void testGetIslandCount03() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("L", "L", "L"),
            Arrays.asList("L", "L", "L"),
            Arrays.asList("L", "L", "L")
        );

        IslandCount islandCount = new IslandCount();
        int count = islandCount.getIslandCount(grid);

        assertEquals(1, count);
    }

    /*
        const grid = [
            ['W', 'W'],
            ['W', 'W'],
            ['W', 'W'],
        ];

        islandCount(grid); // -> 0
    */

    @Test
    public void testGetIslandCount04() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("W", "W"),
            Arrays.asList("W", "W"),
            Arrays.asList("W", "W")
        );

        IslandCount islandCount = new IslandCount();
        int count = islandCount.getIslandCount(grid);

        assertEquals(0, count);
    }

}
