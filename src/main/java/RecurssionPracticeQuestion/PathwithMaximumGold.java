/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

//https://leetcode.com/problems/path-with-maximum-gold/
public class PathwithMaximumGold {
    static boolean[][] visited;
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[][] grid = {
            {1,0,7},
            {2,0,6},
            {3,4,5},
            {0,3,0},
            {9,0,20}
        };
      visited = new boolean[grid.length][grid[0].length];
        System.out.println(getMaximumGold(grid));
        
    }
    public static int getMaximumGold(int[][] grid){
        int sum = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    sum = Math.max(sum, findMaxSum(grid, i, j));
                }
            }
        }
        return sum;
    }
    public static boolean isValid(int[][] grid, int row, int column){
        return row >= 0 && column >=0 && column < grid[0].length && row < grid.length;
    }
    public static int findMaxSum(int[][] grid, int row, int column) {
        if (!isValid(grid, row, column) || grid[row][column] == 0 || visited[row][column]) {
            return 0;
        }

        visited[row][column] = true;

        int sum = grid[row][column];

        sum += Math.max(findMaxSum(grid, row + 1, column),
                        Math.max(findMaxSum(grid, row, column + 1),
                                 Math.max(findMaxSum(grid, row - 1, column),
                                          findMaxSum(grid, row, column - 1))));

        visited[row][column] = false; // Backtrack

        return sum;
    }
}
