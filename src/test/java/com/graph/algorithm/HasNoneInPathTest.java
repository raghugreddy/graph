package com.graph.algorithm;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HasNoneInPathTest {
    private Map<String, List<String>> graph;
    private Map<String, List<String>> graph2;

    @Before
    public void initGraph(){
        /*
        const graph = {
            f: ['g', 'i'],
            g: ['h'],
            h: [],
            i: ['g', 'k'],
            j: ['i'],
            k: []
        };
        */
        graph = Map.ofEntries(
            entry("f", List.of("g", "i")),
            entry("g", List.of("h")),
            entry("h", Collections.emptyList()),
            entry("i", List.of("g", "k")),
            entry("j", List.of("i")),
            entry("k", Collections.emptyList())
        );

        /*
        const graph = {
            v: ['x', 'w'],
            w: [],
            x: [],
            y: ['z'],
            z: [],  
            };
        */
        graph2 = Map.ofEntries(
            entry("v", List.of("x", "w")),
            entry("w", Collections.emptyList()),
            entry("x", Collections.emptyList()),
            entry("y", List.of("z")),
            entry("z", Collections.emptyList())
        );
    }
    
    @Test
    public void testHasPathDepthFirst00() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertTrue(hasNoneInPath.hasPathDepthFirst(graph, "f", "k"));

    }

    @Test
    public void testHasPathDepthFirst01() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertFalse(hasNoneInPath.hasPathDepthFirst(graph, "f", "j"));

    }

    @Test
    public void testHasPathDepthFirst02() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertTrue(hasNoneInPath.hasPathDepthFirst(graph, "i", "h"));

    }

    @Test
    public void testHasPathDepthFirst03() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertTrue(hasNoneInPath.hasPathDepthFirst(graph2, "v", "w"));

    }

    @Test
    public void testHasPathDepthFirst04() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertFalse(hasNoneInPath.hasPathDepthFirst(graph2, "v", "z"));

    }

    @Test
    public void testHasPathBreadthFirst00() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertTrue(hasNoneInPath.hasPathBreadthFirst(graph, "f", "k"));

    }

    @Test
    public void testHasPathBreadthFirst01() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertFalse(hasNoneInPath.hasPathBreadthFirst(graph, "f", "j"));

    }

    @Test
    public void testHasPathBreadthFirst02() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertTrue(hasNoneInPath.hasPathBreadthFirst(graph, "i", "h"));

    }

    @Test
    public void testHasPathBreadthFirst03() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertTrue(hasNoneInPath.hasPathBreadthFirst(graph2, "v", "w"));

    }

    @Test
    public void testHasPathBreadthFirst04() {
        HasNoneInPath hasNoneInPath = new HasNoneInPath();
        assertFalse(hasNoneInPath.hasPathBreadthFirst(graph2, "v", "z"));

    }
}
