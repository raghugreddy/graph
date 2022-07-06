package com.graph.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
minimum island
Write a function, minimumIsland, that takes in a grid containing Ws and Ls. 
W represents water and L represents land. 
The function should return the size of the smallest island. 
An island is a vertically or horizontally connected region of land.

You may assume that the grid contains at least one island.
*/
public class MinimumIslandSize {
    public int getMinIslandSize(List<List<String>> grid) {
        int minSize = -1;
        // set to maintain already visited grid cells
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < grid.size(); row++)
            for (int col = 0; col < grid.get(row).size(); col++){
                // explore the grid cells
                int size = exploreIsland(grid, row, col, visited);
                if (size >0) {
                    if (minSize == -1 || size < minSize)
                        minSize = size;
                }
                
            }

        return (minSize == -1) ? 0 : minSize;
    }


   
    private int exploreIsland(List<List<String>> grid, int rowIdx, int colIdx, Set<String> visited) {
         // check row and column index are inbound
         boolean rowInbound = (rowIdx>=0 && rowIdx < grid.size()) ? true : false;
         boolean colInbound = (rowInbound && colIdx>=0 && colIdx<grid.get(rowIdx).size()) ? true : false;
 
         //System.out.println("rowIdx: " + rowIdx + ", colIdx: " +colIdx + " , rowInbound: " + rowInbound + " , colInbound: "+ colInbound);
 
         // return false if the row and column index are not inbound
         if (!(rowInbound && colInbound) )
             return 0;
 
         // return if the value is "W" water
         if (grid.get(rowIdx).get(colIdx).equalsIgnoreCase("W") )
             return 0;
 
         // return if the row and column index combination of grid already visited.
         String key = rowIdx +","+colIdx;
         if (visited.contains(key))
             return 0;
 
         // add the row and column index combination to visited set.
         visited.add(key);
         //System.out.println("key: " + key);
 
         int size = 1;
         // explore returssivly for the adjecent row, columns 
         size += exploreIsland(grid, rowIdx+1, colIdx, visited);
         size += exploreIsland(grid, rowIdx-1, colIdx, visited);
         size += exploreIsland(grid, rowIdx, colIdx-1, visited);
         size += exploreIsland(grid, rowIdx, colIdx+1, visited);
 
        return size;
    }

    public static void main(String[] args) {

        List<List<String>> grid = Arrays.asList(
            Arrays.asList("W", "L", "W", "W", "W"),
            Arrays.asList("W", "L", "W", "W", "W"),
            Arrays.asList("W", "W", "W", "L", "W"),
            Arrays.asList("W", "W", "L", "L", "W"),
            Arrays.asList("L", "W", "W", "L", "L"),
            Arrays.asList("L", "L", "W", "W", "W")
        );

        MinimumIslandSize minimumIslandSize = new MinimumIslandSize();
        int size = minimumIslandSize.getMinIslandSize(grid);

        System.out.println("minSize: " + size);
    
    }
}
