/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *https://leetcode.com/problems/unique-paths-iii/
 * Date: 11/14/2023
 * @author parth
 */
public class UniquePathsIII {

    public static boolean visited[][];
    public static void main(String args[]) {
        int[][] grid = {
            {1,0,0,0},
            {0,0,0,0},
            {0,0,2,-1}
        };
        visited = new boolean[grid.length][grid[0].length];
        System.out.println(uniquePathsIII(grid));
    }
    public static int uniquePathsIII(int[][] grid){
        int emptycells = 0;
        int row = 0;
        int column = 0;
        for(int i = 0; i < grid.length ;i++){
            for(int j = 0; j < grid[0].length;j++){
               if(grid[i][j] == 0){
                  emptycells = emptycells + 1;
               }
               else if(grid[i][j] == 1){
                  row = i;
                  column = j;
               }
            }
        }
         return uniquePathHelper(grid,row,column,emptycells);
    }
    public static boolean isValid(int[][] grid, int row, int column){
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
    private static int uniquePathHelper(int[][] grid, int row, int column, int emptycells) {
            if (!isValid(grid,row,column)|| grid[row][column] == -1 || visited[row][column]){
                return 0;
            }
               
            if (grid[row][column] == 2)
                if(emptycells == -1){
                    return 1;
                }else{
                    return 0;
                }
            //grid[row][column] = -1;
            visited[row][column] = true;
            emptycells = emptycells - 1;
            int totalPaths = uniquePathHelper(grid, row + 1, column, emptycells) +
                    uniquePathHelper(grid, row, column + 1, emptycells) +
                    uniquePathHelper(grid, row - 1, column, emptycells) +
                    uniquePathHelper(grid, row, column - 1, emptycells);

           // grid[row][column] = 0; // backtrack
           visited[row][column] = false;
            emptycells = emptycells +1;

            return totalPaths;
        }
    }
   

