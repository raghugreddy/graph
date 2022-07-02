package com.graph.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
* shortest path
* Write a function, shortestPath, that takes in an array of edges for an undirected graph 
* and two nodes (nodeA, nodeB). The function should return the length of the shortest path 
* between A and B. Consider the length as the number of edges in the path, 
* not the number of nodes. If there is no path between A and B, then return -1.
*/
public class ShortestPathGraph {
    public int getShortestPathLength(List<String[]> edges, String nodeA, String nodeB) {
        int length = 0;

        // build graph based on edges
        Map<String, List<String>> graph = buildGraph(edges);
        Set<String> visited =  new HashSet<>();
        // explore graph to find the shortest destance
        length = exploreGraph(graph, nodeA, nodeB, visited);

        return length;
    }

    /* using Breadth First Search */
    private int exploreGraph(Map<String, List<String>> graph, String nodeA, String nodeB, Set<String> visited) {
        // define a data structure to hold a node and its distance from nodeA.
        record Node(String node, int distance){

        };

        // to use breadth first search algorithm, define a queue and add the starting nodeA to queue
        // set the distance of the starting node to zero. and we will increment by +1
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(nodeA, 0));

        // add the nodeA to visited Set. this will use to prevent revisiting already visired node. 
        visited.add(nodeA);

        // start processing the queue until it has no node to visit
        while (queue.peek()!= null) {
            Node element = queue.poll();

            // if the current element of the queue is equal to destination nodeB, then return the distanse
            if (element.node().equalsIgnoreCase(nodeB))
                return element.distance();

            // add all the currwnt node neighbers to queue incrementing distance as current node distance + 1
            for (String neighber: graph.get(element.node())) {
                // add to the queue if it is not already visited
                if (!visited.contains(neighber)) {
                    queue.offer(new Node(neighber, element.distance()+1));
                    visited.add(neighber);
                }
                    
            }
        }

        return -1;
    }

    // method to build graph using given edges
    private Map<String, List<String>> buildGraph(List<String[]> edges) {
        return edges.stream().map(s -> Map.of(s[0], s[1], s[1], s[0]))
            .flatMap(m -> m.entrySet().stream())
            .collect(Collectors.toMap(
                e -> e.getKey(), 
                v -> new ArrayList<>(Arrays.asList(v.getValue())),
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }));
    }
    public static void main(String[] args) {
        /* const edges = [
            ['w', 'x'],
            ['x', 'y'],
            ['z', 'y'],
            ['z', 'v'],
            ['w', 'v']
        ];
        */

        List<String[]> edges = List.of(
            new String[] {"w", "x"},
            new String[] {"x", "y"},
            new String[] {"z", "y"},
            new String[] {"z", "v"},
            new String[] {"w", "v"}
        );

        Map<String, List<String>> graph = edges.stream().map(s -> Map.of(s[0], s[1],
                    s[1], s[0])).flatMap(m -> m.entrySet().stream())
                    .collect(
                        Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        System.out.println("graph: "+ graph);

        ShortestPathGraph shortestPathGraph = new ShortestPathGraph();

        System.out.println("grapg2: " + shortestPathGraph.buildGraph(edges));

        int length = shortestPathGraph.getShortestPathLength(edges, "w", "z");

        System.out.println("Length : "+ length);
    }
}
