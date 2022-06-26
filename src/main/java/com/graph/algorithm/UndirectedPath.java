package com.graph.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Write a function, undirectedPath that takes in an array of edges for undirected graph
 * and to nodes (nideA, nodeB). The function should return whether or not there exists 
 * a path between nodeA and nodeB.
*/
public class UndirectedPath {

    /* build the Graph based on edges */
    private Map<String, List<String>> buildGraph(List<String[]> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] edge : edges){
            if (graph.containsKey(edge[0]))
                graph.get(edge[0]).add( edge[1]);
            else {
                List<String> neighberList = new ArrayList<>();
                neighberList.add(edge[1]);
                graph.put(edge[0], neighberList);
            }
                
            
            if (graph.containsKey(edge[1]))
                graph.get(edge[1]).add( edge[0]);
            else {
                List<String> neighberList = new ArrayList<>();
                neighberList.add(edge[0]);
                graph.put(edge[1], neighberList);
            }
            
        }
        return graph;  
    }

    /* reccursive depthFirst search algorithm to find the path if exists */
    /* Set data structure 'visited' used to check cyclic loop */

    private boolean hasPathDepthFirst(Map<String, List<String>> graph, String src, String dest, Set<String> visited) {
        if (visited.contains(src))
            return false;
        if (src.equalsIgnoreCase(dest)) 
            return true;

        visited.add(src);
        if (graph.containsKey(src)) {
            for (String neighber: graph.get(src)) {
                if (hasPathDepthFirst(graph, neighber, dest, visited))
                    return true;
            }
        }

        return false;
    }

    /* integrated method takes edges as input and test the 'hasPath' between src and dest */
    public  boolean hasPathDepthFirst(List<String[]> edges, String src, String dest){
        Map<String, List<String>> graph =  buildGraph(edges);
        Set<String> visited = new HashSet<>();

        return hasPathDepthFirst(graph, src, dest, visited);
    }

    public static void main(String[] args) {
        List<String[]> edges = List.of(
            new String[] {"i", "j"},
            new String[] {"k", "i"},
            new String[] {"m", "k"},
            new String[] {"k", "l"},
            new String[] {"o", "n"}
        );

        UndirectedPath undirectedPath = new UndirectedPath();
        System.out.println(undirectedPath.buildGraph(edges));

        boolean hasPath = undirectedPath.hasPathDepthFirst(edges, "j", "m");

        System.out.println("hasPath :" + hasPath);

    }
    
}
