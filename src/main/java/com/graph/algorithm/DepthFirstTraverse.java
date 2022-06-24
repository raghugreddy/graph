package com.graph.algorithm;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepthFirstTraverse {
    private Stack<String> stack;

    public DepthFirstTraverse() {
        stack = new Stack<>();
    }

    /* Iterate method for Depth first Traverse */
    public void depthFistTraverse(Map<String, String[]> graph, String node){
        stack.push(node);

        while(stack.size() > 0) {
            String current = stack.pop();
            System.out.println(current);

            if (graph.containsKey(current)) {
                for (int i = 0; i < graph.get(current).length; i++) {
                    stack.push(graph.get(current)[i] );
                }
            }
        }
    }

    /* Reccursive method for Depth First Taraverse */
    public void depthFirstRecTraverse(Map<String, String[]> graph, String node) {
        System.out.println(node);
        if (graph.containsKey(node)) {
            String nieghbers[] = graph.get(node);
            for (int i = 0; i < nieghbers.length; i++ )
                depthFirstRecTraverse(graph,  nieghbers[i]);

        }

    }

    public static void main(String[] args) {
        Map<String, String[]> graph = Map.of(
            "A", new String[] {"C", "B"},
            "B", new String[] {"D"},
            "C", new String[] {"E"},
            "D", new String[] {"F"},
            "E", new String[] {},
            "F", new String[] {}

        );

        System.out.println(graph);
        DepthFirstTraverse depthFirst = new DepthFirstTraverse();
        depthFirst.depthFistTraverse(graph, "A");

        Map<String, String[]> graph2 = Collections.unmodifiableMap(Stream.of(
            new SimpleEntry<>("A", new String[] {"C", "B"}),
            new SimpleEntry<>("B", new String[] {"D"}),
            new SimpleEntry<>("C", new String[] {"E"}),
            new SimpleEntry<>("D", new String[] {"F"}),
            new SimpleEntry<>("E", new String[] {}),
            new SimpleEntry<>("F", new String[] {}))
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
        
        System.out.println(graph2);
        depthFirst.depthFirstRecTraverse(graph2, "A");  
    }
}
