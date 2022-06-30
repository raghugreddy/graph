package com.graph.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LargestComponentCountTest {

    /*
        largestComponent({
            0: ['8', '1', '5'],
            1: ['0'],
            5: ['0', '8'],
            8: ['0', '5'],
            2: ['3', '4'],
            3: ['2', '4'],
            4: ['3', '2']
            }); // -> 4
    */
    @Test
    public void testGetLargestComponent01() {
        Map<String, List<String>> graph = Map.of(
            "0", List.of("8", "1", "5"),
            "1", List.of("0"),
            "5", List.of("0", "8"),
            "8", List.of("0", "5"),
            "2", List.of("3", "4"),
            "3", List.of("2", "4"),
            "4", List.of("3", "2")
        );

        LargestComponentCount largestComponentCount = new LargestComponentCount();

        int largest = largestComponentCount.getLargestComponent(graph);
        assertEquals(4, largest);
    }

    /*
        largestComponent({
            1: ['2'],
            2: ['1','8'],
            6: ['7'],
            9: ['8'],
            7: ['6', '8'],
            8: ['9', '7', '2']
        }); // -> 6
    */
    @Test
    public void testGetLargestComponent02() {
        Map<String, List<String>> graph = Map.of(
            "1", List.of("2"),
            "2", List.of("1", "8"),
            "6", List.of("7"),
            "9", List.of("8"),
            "7", List.of("6","8"),
            "8", List.of("9", "7", "2")
        );

        LargestComponentCount largestComponentCount = new LargestComponentCount();

        int largest = largestComponentCount.getLargestComponent(graph);
        assertEquals(6, largest);
    }

    /*
        largestComponent({
            3: [],
            4: ['6'],
            6: ['4', '5', '7', '8'],
            8: ['6'],
            7: ['6'],
            5: ['6'],
            1: ['2'],
            2: ['1']
        }); // -> 5
    */

    @Test
    public void testGetLargestComponent03() {
        Map<String, List<String>> graph = Map.of(
            "3", List.of(),
            "4", List.of("6"),
            "6", List.of("4", "5", "7", "8"),
            "8", List.of("6"),
            "7", List.of("6"),
            "5", List.of("6"),
            "1", List.of("2"),
            "2", List.of("1")
        );

        LargestComponentCount largestComponentCount = new LargestComponentCount();

        int largest = largestComponentCount.getLargestComponent(graph);
        assertEquals(5, largest);
    }

    /*
        largestComponent({}); // -> 0
    */
    @Test
    public void testGetLargestComponent04() {
        Map<String, List<String>> graph = Map.of();

        LargestComponentCount largestComponentCount = new LargestComponentCount();

        int largest = largestComponentCount.getLargestComponent(graph);
        assertEquals(0, largest);
    }

    /*
        largestComponent({
            0: ['4','7'],
            1: [],
            2: [],
            3: ['6'],
            4: ['0'],
            6: ['3'],
            7: ['0'],
            8: []
        }); // -> 3
    */
    @Test
    public void testGetLargestComponent05() {
        Map<String, List<String>> graph = Map.of(
            "0", List.of("4", "7"),
            "1", List.of(),
            "2", List.of(),
            "3", List.of("6"),
            "4", List.of("0"),
            "6", List.of("3"),
            "7", List.of("0"),
            "8", List.of()
        );

        LargestComponentCount largestComponentCount = new LargestComponentCount();

        int largest = largestComponentCount.getLargestComponent(graph);
        assertEquals(3, largest);
    }
}
