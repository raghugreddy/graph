package com.graph.algorithm;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static java.util.Map.entry;

import java.util.ArrayDeque;

/* Algorithm to find has path
Write a function, hasPath, that takes in an object representing 
the adjacency list of a directed acyclic graph and two nodes (src, dst). 

The function should return a boolean indicating whether or not there 
exists a directed path between the source and destination nodes.
*/

public class HasNoneInPath {
    
    /* Using Depth First Search */
    public boolean hasPathDepthFirst(Map<String, List<String>> graph, String source, String destination) {
        if (source.equalsIgnoreCase(destination))
            return true;

        if (graph.containsKey(source)) {
            for (String neighber : graph.get(source)){
                if (hasPathDepthFirst(graph, neighber, destination) == true)
                    return true;
            }
        }

        return false;
    }

    /* Using Breadth First Search */
    public boolean hasPathBreadthFirst(Map<String, List<String>> graph, String source, String destination) {

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(source);

        while (queue.peek() != null ){
            String current = queue.poll();
            if (current.equalsIgnoreCase(destination))
                return true;

            if (graph.containsKey(current)) {
                for (String neighber : graph.get(current))
                    queue.offer(neighber);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.ofEntries(
            entry("f", List.of("g", "i")),
            entry("g", List.of("h")),
            entry("h", Collections.emptyList()),
            entry("i", List.of("g", "k")),
            entry("j", List.of("i")),
            entry("k", Collections.emptyList())
        );

        HasNoneInPath hasPath = new HasNoneInPath();
        System.out.println(hasPath.hasPathDepthFirst(graph, "f", "k"));
    }
}
