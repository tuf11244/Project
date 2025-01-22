/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date:01/21/2025
 * https://leetcode.com/problems/map-of-highest-peak/
 * @author parth
 */
public class MapofHighestPeak {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[][] highestPeak(int[][] isWater) {

        Queue<Peak> queue = new LinkedList<>();
        int[][] arr = new int[isWater.length][isWater[0].length];

        boolean[][] visited = new boolean[isWater.length][isWater[0].length];

        for(int i = 0; i < isWater.length;i++){
            for(int j = 0;j < isWater[0].length;j++){

                if(isWater[i][j] == 1){ //water cell
                    queue.add(new Peak(i,j,0));
                    arr[i][j] = 0; //assing it zero in return matrix;
                    visited[i][j] = true;
                }
            }
        }

                while(!queue.isEmpty()){
                        Peak rem = queue.poll();

                        for(int i = 0; i < 4;i++){
                            int newRow = rem.row + direction[i][0];
                            int newCol = rem.col + direction[i][1];

                            if(isValid(newRow,newCol,isWater) && visited[newRow][newCol] == false){
                                arr[newRow][newCol] = rem.level + 1;
                                queue.add(new Peak(newRow,newCol, rem.level+1));
                                visited[newRow][newCol] = true;
                            }
                        }
                    
                }

        return arr;
    }

    public int[][] direction = {
        {0,1},
        {-1,0},
        {0,-1},
        {1,0}
    };

    public boolean isValid(int row, int col, int[][] isWater){
        return row >= 0 && row < isWater.length && col >= 0 && col < isWater[0].length;
    }
}
class Peak{
    int row;
    int col;
    int level;

    public Peak(int row, int col, int level){
        this.row = row;
        this.col = col;
        this.level = level;
    }
}
