package com.graph.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 
 * connected components count
 * Write a function, connectedComponentsCount, 
 * that takes in the adjacency list of an undirected graph. 
 * The function should return the number of connected components within the graph.
*/
public class ConnectedComponentCount {

    public int countConnected(Map<Integer, List<Integer>> graph) {
        int count = 0;

        Set<Integer> visited = new HashSet<>();

        if (graph != null) {
            for (Integer key: graph.keySet()) {
                if (exploreGraph(graph, key, visited) == true)
                    count++;
            }
        }
        

        return count;
    }

    private boolean exploreGraph(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {
        if (visited.contains(node))
            return false;

        visited.add(node);
        if (graph.containsKey(node)) 
            for (Integer neighber: graph.get(node)) 
                exploreGraph(graph, neighber, visited);
        return true;
    }
    
    public static void main(String[] args) {
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
        System.out.println("count: "+ count);
    }
}
