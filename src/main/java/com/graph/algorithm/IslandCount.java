package com.graph.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
island count
Write a function, islandCount, that takes in a grid containing Ws and Ls. 
W represents water and L represents land. 
The function should return the number of islands on the grid.
An island is a vertically or horizontally connected region of land.
*/

public class IslandCount {
    public int getIslandCount(List<List<String>> grid){
        int count = 0;
        // set to maintain already visited grid cells
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < grid.size(); i++)
            for (int j = 0; j < grid.get(i).size(); j++){
                // explore the grid cells
                if (exploreIsland(grid, i, j, visited))
                    count++;
            }
        
        return count;
    }

    // reccurssivly explore for  connected "L" lands
    private boolean exploreIsland(List<List<String>> grid, int rowIdx, int colIdx, Set<String> visited) {
        
        // check row and column index are inbound
        boolean rowInbound = (rowIdx>=0 && rowIdx < grid.size()) ? true : false;
        boolean colInbound = (rowInbound && colIdx>=0 && colIdx<grid.get(rowIdx).size()) ? true : false;

        //System.out.println("rowIdx: " + rowIdx + ", colIdx: " +colIdx + " , rowInbound: " + rowInbound + " , colInbound: "+ colInbound);

        // return false if the row and column index are not inbound
        if (!(rowInbound && colInbound) )
            return false;

        // return if the row and column index combination of grid already visited.
        String key = rowIdx +","+colIdx;
        if (visited.contains(key))
            return false;

        // add the row and column index combination to visited set.
        visited.add(key);
        //System.out.println("key: " + key);

        // return if the value is "W" water
        if (grid.get(rowIdx).get(colIdx).equalsIgnoreCase("W") )
            return false;
        
        // explore returssivly for the adjecent row, columns 
        exploreIsland(grid, rowIdx+1, colIdx, visited);
        exploreIsland(grid, rowIdx-1, colIdx, visited);
        exploreIsland(grid, rowIdx, colIdx-1, visited);
        exploreIsland(grid, rowIdx, colIdx+1, visited);

        return true;
    }
    public static void main(String[] args) {
        /*
        grid = [
            ['W', 'L', 'W', 'W', 'W'],
            ['W', 'L', 'W', 'W', 'W'],
            ['W', 'W', 'W', 'L', 'W'],
            ['W', 'W', 'L', 'L', 'W'],
            ['L', 'W', 'W', 'L', 'L'],
            ['L', 'L', 'W', 'W', 'W'],
        ];
        */
        IslandCount islandCount = new IslandCount();
        List<List<String>> grid = List.of(
            List.of("W", "L", "W", "W", "W"),
            List.of("W", "L", "W", "W", "W"),
            List.of("W", "W", "W", "L", "W"),
            List.of("W", "W", "L", "L", "W"),
            List.of("L", "W", "W", "L", "L"),
            List.of("L", "L", "W", "W", "W")
        );

        int count = islandCount.getIslandCount(grid);

        System.out.println("Count: " + count);
    }
}
