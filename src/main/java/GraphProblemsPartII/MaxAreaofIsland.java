/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/27/2024
 * https://leetcode.com/problems/max-area-of-island/
 * @author parth
 */
public class MaxAreaofIsland {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class Solution {
    public static StringBuilder psf;
    public int maxAreaOfIsland(int[][] grid) {
        List<String> list = new ArrayList<>();
        for(int i =0; i < grid.length;i++){
            for(int j =0; j < grid[i].length;j++){
                if(grid[i][j] ==1 ){
                    psf = new StringBuilder();
                    psf.append("x");

                    dfs(grid,i,j,psf);

                    list.add(psf.toString());
                }
            }
        }

       String longest = "x";
       for(int i = 0; i < list.size();i++){
         if(list.get(i).length() > longest.length()){
            longest = list.get(i);
         }
       }
       if(longest.equals("x")){
        return 0;
       }
        int count =0;
       for(int  i  = 0; i < longest.length();i++){
          char ch = longest.charAt(i);
          if(ch == 'R' || ch == 'U' || ch == 'L' || ch == 'D'){
            count++;
          }
       }

        return count +1 ;
    }

    public void dfs(int[][] grid, int row, int column, StringBuilder psf){

        grid[row][column] = 0; //mark it visited 

        if(row-1 >= 0 && grid[row-1][column] == 1){
            psf.append("U");
            dfs(grid,row-1,column,psf);
        }
        if(row+1 < grid.length && grid[row+1][column] == 1){
            psf.append("D");
            dfs(grid,row+1,column,psf);
        }

        if(column-1 >= 0 && grid[row][column-1] == 1){
            psf.append("L");
            dfs(grid,row,column-1,psf);
        }
        if(column+1 < grid[row].length && grid[row][column+1] == 1){
            psf.append("R");
            dfs(grid,row,column+1,psf);
        }

        psf.append("z"); //marks the end of exploration; 
    }
}