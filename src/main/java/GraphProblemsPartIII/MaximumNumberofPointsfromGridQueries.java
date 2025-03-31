/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date:03/28/2025
 * https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/
 * 
 * @author parth
 */
public class MaximumNumberofPointsfromGridQueries {
    
    public static void main(String[] args) {
        
    }

    public int[][] directions = {
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] answer = new int[queries.length];

        Query[] arr = new Query[queries.length];

        for(int i = 0; i < queries.length; i++){
            arr[i] = new Query(queries[i], i);
        } 
        Arrays.sort(arr);       
        PriorityQueue<GridPoint> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < arr.length; i++){
            Query rem = arr[i];
            int value = rem.val;
            int index = rem.idx;

            // Same Value
            if(i > 0 && arr[i-1].val == value){
                 int prevIndex = arr[i-1].idx;
                 answer[index] = answer[prevIndex];
            } else {
                int count = bfs(pq, grid, visited, value);
                if(i == 0){
                    answer[index] = count;
                } else {
                    int prevIndex = arr[i-1].idx;
                    answer[index] = answer[prevIndex] + count;
                }
            }
        }
        return answer;
    }

    public int bfs(PriorityQueue<GridPoint> pq, int[][] grid, boolean[][] visited, int value){
        if(pq.isEmpty()){
            pq.add(new GridPoint(grid[0][0], 0, 0));
        }
        int count = 0;
        while(!pq.isEmpty()){
            GridPoint rem = pq.poll();

            if(rem.val >= value){
                pq.add(rem);
                break;
            }
            if(visited[rem.row][rem.col]){
                continue;
            }
            count++;
            visited[rem.row][rem.col] = true;

            for(int i = 0; i < 4; i++){
                int newRow = rem.row + directions[i][0];
                int newCol = rem.col + directions[i][1];

                if(isValid(grid, newRow, newCol)){
                    pq.add(new GridPoint(grid[newRow][newCol], newRow, newCol));
                }
            }
        }
        return count;
    }

    public boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

}
class Query implements Comparable<Query>{
    int val;
    int idx;

    public Query(int val, int idx){
        this.val = val;
        this.idx = idx;
    }

    public int compareTo(Query o){
        return this.val - o.val;
    }
}

class GridPoint implements Comparable<GridPoint>{
    int val;
    int row;
    int col;

    public GridPoint(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }

    public int compareTo(GridPoint o){
        return this.val - o.val;
    }
}

