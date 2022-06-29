package com.graph.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ConnectedComponentCountTest {
    @Test
    public void testCountConnected01() {
        Map<Integer, List<Integer>> graph = Map.of(
            0, List.of(8,1,5),
            1, List.of(0),
            5, List.of(0,8),
            8, List.of(0,5),
            2, List.of(3,4),
            3, List.of(2,4),
            4, List.of(3,2)
        );

        ConnectedComponentCount connectedComponentCount = new ConnectedComponentCount();
        int count = connectedComponentCount.countConnected(graph);
        assertEquals(2, count);
    }
    /*
        connectedComponentsCount({
            1: [2],
            2: [1,8],
            6: [7],
            9: [8],
            7: [6, 8],
            8: [9, 7, 2]
        }); // -> 1
    */

    @Test
    public void testCountConnected02() {
        Map<Integer, List<Integer>> graph = Map.of(
            1, List.of(2),
            2, List.of(1, 8),
            6, List.of(7),
            9, List.of(8),
            7, List.of(6,8),
            8, List.of(9,7,2)
        );

        ConnectedComponentCount connectedComponentCount = new ConnectedComponentCount();
        int count = connectedComponentCount.countConnected(graph);
        assertEquals(1, count);
    }
    /*
        connectedComponentsCount({
            3: [],
            4: [6],
            6: [4, 5, 7, 8],
            8: [6],
            7: [6],
            5: [6],
            1: [2],
            2: [1]
        }); // -> 3
    */
    @Test
    public void testCountConnected03() {
        Map<Integer, List<Integer>> graph = Map.of(
            3, Collections.emptyList(),
            4, List.of(6),
            6, List.of(4,5,7,8),
            8, List.of(6),
            7, List.of(6),
            5, List.of(6),
            1, List.of(2),
            2, List.of(1)
        );

        ConnectedComponentCount connectedComponentCount = new ConnectedComponentCount();
        int count = connectedComponentCount.countConnected(graph);
        assertEquals(3, count);
    }

    /*
        connectedComponentsCount({}); // -> 0
    */
    @Test
    public void testCountConnected04() {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        ConnectedComponentCount connectedComponentCount = new ConnectedComponentCount();
        int count = connectedComponentCount.countConnected(graph);
        assertEquals(0, count);
    }

    /*
    connectedComponentsCount({
        0: [4,7],
        1: [],
        2: [],
        3: [6],
        4: [0],
        6: [3],
        7: [0],
        8: []
        }); // -> 5
    */

    @Test
    public void testCountConnected05() {
        Map<Integer, List<Integer>> graph = Map.of(
            0, List.of(4,7),
            1, Collections.emptyList(),
            2, Collections.emptyList(),
            3, List.of(6),
            4, List.of(0),
            6, List.of(3),
            7, List.of(0),
            8, Collections.emptyList()
        );

        ConnectedComponentCount connectedComponentCount = new ConnectedComponentCount();
        int count = connectedComponentCount.countConnected(graph);
        assertEquals(5, count);
    }


}
