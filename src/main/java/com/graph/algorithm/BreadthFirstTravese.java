package com.graph.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class  BreadthFirstTravese {
    Queue<String> queue;

    public BreadthFirstTravese() {
        queue = new ArrayDeque<>() ;
    }

    public void breadthFirstTravese(Map<String, List<String>> graph, String node) {
        queue.offer(node);
        
        while (queue.peek() != null) {
            String current = queue.poll();
            System.out.println(current);
            if (graph.containsKey(current)){
                for(String neighber: graph.get(current))
                    queue.offer(neighber);
            }
        }
    }
    
    public static void main(String[] args) {
        BreadthFirstTravese breadth = new BreadthFirstTravese();

        Map<String, List<String>> graph = Map.of(
            "A", List.of("C", "B"),
            "B", List.of("D"),
            "C", List.of("E"),
            "D", List.of("F"),
            "E", Collections.emptyList() ,
            "F", Collections.emptyList() 
        );
        
        breadth.breadthFirstTravese( graph, "A");
        
        Map<String, List<String> > graph2 = Map.ofEntries(
            Map.entry("A", Arrays.asList("C", "B")),
            Map.entry("B", Arrays.asList("D")),
            Map.entry("C", Arrays.asList("E")),
            Map.entry("D", Arrays.asList("F")),
            Map.entry("E", Collections.emptyList()),
            Map.entry("F", Collections.emptyList())
            ) ;
   
    }
}
