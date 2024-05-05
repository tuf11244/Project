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

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        int m = heights.length;
        int n = heights[0].length;

        if (visited[i][j])
            return;

        visited[i][j] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj] && heights[ni][nj] >= heights[i][j]) {
                dfs(heights, visited, ni, nj);
            }
        }
    }
}
