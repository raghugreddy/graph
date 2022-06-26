package com.graph.algorithm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UndirectedPathTest {
    private List<String[]> edges1;
    private List<String[]> edges2;
    private List<String[]> edges3;

    @Before
    public void initEdges(){
        /*
            const edges1 = [
                ['i', 'j'],
                ['k', 'i'],
                ['m', 'k'],
                ['k', 'l'],
                ['o', 'n']
            ];
        */
        edges1 = List.of(
            new String[] {"i", "j"},
            new String[] {"k", "i"},
            new String[] {"m", "k"},
            new String[] {"k", "l"},
            new String[] {"o", "n"}
        );

        /*
            const edges2 = [
                ['b', 'a'],
                ['c', 'a'],
                ['b', 'c'],
                ['q', 'r'],
                ['q', 's'],
                ['q', 'u'],
                ['q', 't'],
            ];
        */
        edges2 = List.of(
            new String[] {"b", "a"},
            new String[] {"c", "a"},
            new String[] {"b", "c"},
            new String[] {"q", "r"},
            new String[] {"q", "s"},
            new String[] {"q", "u"},
            new String[] {"q", "t"}
        );
        /*
            const edges = [
                ['s', 'r'],
                ['t', 'q'],
                ['q', 'r'],
            ];
        */
        edges3 = List.of(
            new String[] {"s", "r"},
            new String[] {"t", "q"},
            new String[] {"q", "r"}
        );
    }
    
    @Test
    public void testHasPathDepthFirst_00() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges1, "j", "m"));
    }

    @Test
    public void testHasPathDepthFirst_01() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges1, "m", "j"));
    }

    @Test
    public void testHasPathDepthFirst_02() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges1, "l", "j"));
    }

    @Test
    public void testHasPathDepthFirst_03() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertFalse(undirectedPath.hasPathDepthFirst(edges1, "k", "o"));
    }

    @Test
    public void testHasPathDepthFirst_04() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertFalse(undirectedPath.hasPathDepthFirst(edges1, "i", "o"));
    }

    @Test
    public void testHasPathDepthFirst_05() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges2, "a", "b"));
    }

    @Test
    public void testHasPathDepthFirst_06() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges2, "a", "c"));
    }

    @Test
    public void testHasPathDepthFirst_07() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges2, "r", "t"));
    }

    @Test
    public void testHasPathDepthFirst_08() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertFalse(undirectedPath.hasPathDepthFirst(edges2, "r", "b"));
    }

    @Test
    public void testHasPathDepthFirst_09() {
        UndirectedPath undirectedPath = new UndirectedPath();
        assertTrue(undirectedPath.hasPathDepthFirst(edges3, "r", "t"));
    }
}
