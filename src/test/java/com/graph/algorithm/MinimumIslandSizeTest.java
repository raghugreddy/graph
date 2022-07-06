package com.graph.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MinimumIslandSizeTest {

    /*
        const grid = [
            ['W', 'L', 'W', 'W', 'W'],
            ['W', 'L', 'W', 'W', 'W'],
            ['W', 'W', 'W', 'L', 'W'],
            ['W', 'W', 'L', 'L', 'W'],
            ['L', 'W', 'W', 'L', 'L'],
            ['L', 'L', 'W', 'W', 'W']
        ];

        minimumIsland(grid); // -> 2
    */
    @Test
    public void testGetMinIslandSize01() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("W", "L", "W", "W", "W"),
            Arrays.asList("W", "L", "W", "W", "W"),
            Arrays.asList("W", "W", "W", "L", "W"),
            Arrays.asList("W", "W", "L", "L", "W"),
            Arrays.asList("L", "W", "W", "L", "L"),
            Arrays.asList("L", "L", "W", "W", "W")
        );

        MinimumIslandSize minimumIslandSize = new MinimumIslandSize();
        int size = minimumIslandSize.getMinIslandSize(grid);

        assertEquals(2, size);
    }

    /*
    const grid = [
        ['L', 'W', 'W', 'L', 'W'],
        ['L', 'W', 'W', 'L', 'L'],
        ['W', 'L', 'W', 'L', 'W'],
        ['W', 'W', 'W', 'W', 'W'],
        ['W', 'W', 'L', 'L', 'L'],
    ];

    minimumIsland(grid); // -> 1
    */
    @Test
    public void testGetMinIslandSize02() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("L", "W", "W", "L", "W"),
            Arrays.asList("L", "W", "W", "L", "L"),
            Arrays.asList("W", "L", "W", "L", "W"),
            Arrays.asList("W", "W", "W", "W", "W"),
            Arrays.asList("W", "W", "L", "L", "L")
          );

        MinimumIslandSize minimumIslandSize = new MinimumIslandSize();
        int size = minimumIslandSize.getMinIslandSize(grid);

        assertEquals(1, size);
    }

    /*
    const grid = [
        ['L', 'L', 'L'],
        ['L', 'L', 'L'],
        ['L', 'L', 'L'],
    ];

    minimumIsland(grid); // -> 9
    
    */

    @Test
    public void testGetMinIslandSize03() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("L", "L", "L"),
            Arrays.asList("L", "L", "L"),
            Arrays.asList("L", "L", "L")
        );

        MinimumIslandSize minimumIslandSize = new MinimumIslandSize();
        int size = minimumIslandSize.getMinIslandSize(grid);

        assertEquals(9, size);
    }

    /*
    const grid = [
        ['W', 'W'],
        ['L', 'L'],
        ['W', 'W'],
        ['W', 'L']
    ];

    minimumIsland(grid); // -> 1
     */
    @Test
    public void testGetMinIslandSize04() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("W", "W"),
            Arrays.asList("L", "L"),
            Arrays.asList("W", "W"),
            Arrays.asList("W", "L")
          );

        MinimumIslandSize minimumIslandSize = new MinimumIslandSize();
        int size = minimumIslandSize.getMinIslandSize(grid);

        assertEquals(1, size);
    }

    @Test
    public void testGetMinIslandSize05() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("W", "W"),
            Arrays.asList("W", "W"),
            Arrays.asList("W", "W"),
            Arrays.asList("W", "W")
          );

        MinimumIslandSize minimumIslandSize = new MinimumIslandSize();
        int size = minimumIslandSize.getMinIslandSize(grid);

        assertEquals(0, size);
    }
}
