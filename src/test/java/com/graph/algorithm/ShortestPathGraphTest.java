package com.graph.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ShortestPathGraphTest {

    /* const edges = [
            ['w', 'x'],
            ['x', 'y'],
            ['z', 'y'],
            ['z', 'v'],
            ['w', 'v']
        ];

        shortestPath(edges, 'w', 'z'); // -> 2
        shortestPath(edges, 'y', 'x'); // -> 1
        */
    @Test
    public void testGetShortestPathLength01() {
        List<String[]> edges = List.of(
            new String[] {"w", "x"},
            new String[] {"x", "y"},
            new String[] {"z", "y"},
            new String[] {"z", "v"},
            new String[] {"w", "v"}
        );

        ShortestPathGraph shortestPathGraph = new ShortestPathGraph();

        int length = shortestPathGraph.getShortestPathLength(edges, "w", "z");

        assertEquals(2, length);

        int length2 = shortestPathGraph.getShortestPathLength(edges, "y", "x");

        assertEquals(1, length2);
    }

    /*
        const edges = [
            ['a', 'c'],
            ['a', 'b'],
            ['c', 'b'],
            ['c', 'd'],
            ['b', 'd'],
            ['e', 'd'],
            ['g', 'f']
        ];

        shortestPath(edges, 'a', 'e'); // -> 3
        shortestPath(edges, 'e', 'c'); // -> 2
        shortestPath(edges, 'b', 'g'); // -> -1
    */
    @Test
    public void testGetShortestPathLength02() {
        List<String[]> edges = List.of(
            new String[] {"a", "c"},
            new String[] {"a", "b"},
            new String[] {"c", "b"},
            new String[] {"c", "d"},
            new String[] {"b", "d"},
            new String[] {"e", "d"},
            new String[] {"g", "f"}
        );

        ShortestPathGraph shortestPathGraph = new ShortestPathGraph();

        int length = shortestPathGraph.getShortestPathLength(edges, "a", "e");

        assertEquals(3, length);

        int length2 = shortestPathGraph.getShortestPathLength(edges, "e", "c");

        assertEquals(2, length2);

        int length3 = shortestPathGraph.getShortestPathLength(edges, "b", "g");

        assertEquals(-1, length3);
    }

    /*
        const edges = [
            ['c', 'n'],
            ['c', 'e'],
            ['c', 's'],
            ['c', 'w'],
            ['w', 'e'],
        ];

        shortestPath(edges, 'w', 'e'); // -> 1
        shortestPath(edges, 'n', 'e'); // -> 2
    */

    @Test
    public void testGetShortestPathLength03() {
        List<String[]> edges = List.of(
            new String[] {"c", "n"},
            new String[] {"c", "e"},
            new String[] {"c", "s"},
            new String[] {"c", "w"},
            new String[] {"w", "e"}
        );

        ShortestPathGraph shortestPathGraph = new ShortestPathGraph();

        int length = shortestPathGraph.getShortestPathLength(edges, "w", "e");

        assertEquals(1, length);

        int length2 = shortestPathGraph.getShortestPathLength(edges, "n", "e");

        assertEquals(2, length2);

    }

    /*
        const edges = [
            ['m', 'n'],
            ['n', 'o'],
            ['o', 'p'],
            ['p', 'q'],
            ['t', 'o'],
            ['r', 'q'],
            ['r', 's']
        ];

        shortestPath(edges, 'm', 's'); // -> 6
    */

    @Test
    public void testGetShortestPathLength04() {
        List<String[]> edges = List.of(
            new String[] {"m", "n"},
            new String[] {"n", "o"},
            new String[] {"o", "p"},
            new String[] {"p", "q"},
            new String[] {"t", "o"},
            new String[] {"r", "q"},
            new String[] {"r", "s"}
        );

        ShortestPathGraph shortestPathGraph = new ShortestPathGraph();

        int length = shortestPathGraph.getShortestPathLength(edges, "m", "s");

        assertEquals(6, length);

    }

}
