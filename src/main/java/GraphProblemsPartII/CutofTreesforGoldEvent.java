/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/30/2024
 *https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * @author parth
 */
public class CutofTreesforGoldEvent {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        l1.add(4);
        
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(0);
        l2.add(5);
        
        List<Integer> l3 = new ArrayList<>();
        l3.add(8);
        l3.add(7);
        l3.add(6);
        
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(l1);
        forest.add(l2);
        forest.add(l3);
        
        System.out.println(cutOffTree(forest));
    }
    
    /**
     * Function to find the minimum steps required to cut off all trees in increasing order of their height.
     * @param forest The forest grid represented as a list of lists of integers.
     * @return The minimum steps required to cut off all trees or -1 if not possible.
     */
    public static int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int rows = forest.size();
        int cols = forest.get(0).size();

        // Collect all tree positions with their heights and sort by height
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (forest.get(i).get(j) > 1) {
                    //1. Value 
                    //2. row Index
                    //3 . col Index
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        //We are sorting by values 
        Collections.sort(trees, (a, b) -> a[0] - b[0]);

        int startX = 0, startY = 0;
        int totalSteps = 0;

        // Traverse each tree in sorted order of height
        for (int[] tree : trees) {
            // Find the shortest path to the current tree
            int steps = bfs(forest, startX, startY, tree[1], tree[2]);
            if (steps == -1) {
                return -1; // If a tree is unreachable, return -1
            }
            totalSteps += steps; // Accumulate steps
            startX = tree[1]; // Move the start position to the current tree's position
            startY = tree[2];
        }
        return totalSteps; // Return the total steps required
     
    }
    
       /**
     * Perform BFS to find the shortest path from (startX, startY) to (targetX, targetY).
     * @param forest The forest grid.
     * @param startX The starting X position.
     * @param startY The starting Y position.
     * @param targetX The target X position.
     * @param targetY The target Y position.
     * @return The number of steps required to reach the target position, or -1 if unreachable.
     */
    private static int bfs(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY) {
        int rows = forest.size();
        int cols = forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // If we reach the target position, return the number of steps
            if (x == targetX && y == targetY) {
                return steps;
            }

            // Explore all 4 possible directions (right, down, left, up)
            for (int i = 0; i < 4;i++){ 
                int rowdash = x + directions[i][0];
                int coldash = y + directions[i][1];
                // Check if the new position is within bounds, not visited, and not a blocked cell
                if (isValid(forest,rowdash,coldash) && visited[rowdash][coldash] == false && forest.get(rowdash).get(coldash) != 0) {
                    visited[rowdash][coldash] = true;
                    queue.add(new int[]{rowdash, coldash, steps + 1});
                }
            }
        }
        return -1; // Return -1 if the target position is unreachable
    }
    
    public static boolean isValid(List<List<Integer>> forest, int row, int col){
        return row >= 0 && row < forest.size() && col >= 0 && col < forest.get(row).size();
    }
    
    public static int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
}


