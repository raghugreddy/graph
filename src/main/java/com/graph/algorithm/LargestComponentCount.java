package com.graph.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * largest component
 * Write a function, largestComponent, that takes in the adjacency list of an undirected graph. 
 * The function should return the size of the largest connected component in the graph.
*/

public class LargestComponentCount {

    public int getLargestComponent(Map<String, List<String>> graph) {
        int largest = 0;

        Set<String> visited = new HashSet<>();

        for (String key: graph.keySet()) {
            int count = exploreGraph(graph, key, visited);

            if (count > largest)
                largest = count;
        }

        return largest;
    }

    private int exploreGraph(Map<String, List<String>> graph, String key, Set<String> visited) {
        int size = 0;

        if (visited.contains(key))
            return 0;

        visited.add(key);
        size = 1;

        for (String neighber: graph.get(key)) {
            size += exploreGraph(graph, neighber, visited);
        }

        return size;
    }

    public static void main(String[] args) {
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
        System.out.println("largest: " + largest);

    }
    
}
