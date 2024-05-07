/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *Date: 05/04/2024
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * @author parth
 */
public class PacificAtlanticWaterFlow {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return answer;
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, canReachPacific, i, 0);
            dfs(heights, canReachAtlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, canReachPacific, 0, j);
            dfs(heights, canReachAtlantic, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    answer.add(temp);
                }
            }
        }

        return answer;
    }
    private static int[][] directions = {
            {1, 0}, 
            {-1, 0}, 
            {0, 1}, 
            {0, -1}
    };
    private static boolean isValid(int[][] heights, int row, int column){
        return row < heights.length && row >= 0 && column >= 0 && column < heights[0].length;
    }
    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col])
            return;

        visited[row][col] = true;
        
        for(int k = 0; k < 4;k++){
            int rowdash = row + directions[k][0];
            int coldash = col + directions[k][1];
            
            if(isValid(heights,rowdash,coldash) && visited[rowdash][coldash] == false && heights[rowdash][coldash] >= heights[row][col]){
                dfs(heights,visited,rowdash,coldash);
            }
        }
    }
}
