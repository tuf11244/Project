/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 * Date: 05/14/2024
 *https://leetcode.com/problems/number-of-islands-ii/
 * @author parth
 */
public class NumberofIslandsII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] positions = {
            {0,0},
            {0,1},
            {1,2},
            {2,1}
        };
        List<Integer> answer = numofIslandsII(3,3,positions);
        
        System.out.println(answer);
    }
    public static int[][] directions = {
        {1,0},
        {0,-1},
        {-1,0},
        {0,1}
    };
    public static List<Integer> numofIslandsII(int m, int n, int[][] positions){
        List<Integer> answer = new ArrayList<>();
        //m = number of rows;
        //n = number of columns
        int[] parent = new int[m*n];
        int[] rank = new int[m*n];
        Arrays.fill(parent, -1);
        
        int count = 0;
        for(int i = 0; i < positions.length;i++){
            int row = positions[i][0];
            int col = positions[i][1];
            
            int cellnum = row * n + col; //very import 
            //we are converting a 2d array position to single parent array 
            if(parent[cellnum]!= -1){ //means it has been accounted for or duplicate point 
               answer.add(count);
               continue;
            }
            parent[cellnum] = cellnum; //means this point is visited for the first time 
            rank[cellnum] = 1;
            count++; //we increase the count
            
            //Check for the adjacent neighbours 
            for(int k = 0; k < 4;k++){
                int rowdash = row + directions[k][0];
                int coldash = col + directions[k][1];
                
                int celldash = rowdash * n + coldash;
                
                if(!isValid(m,n, rowdash,coldash) || parent[celldash] == -1){
                    //if parent[celldash] is -1 that means in our array its still 0 
                    //that means it has not been intialized yet
                    continue;
                }
                
                int lx = find(cellnum,parent);
                int ly = find(celldash,parent);
                
                //if lx == ly means they are part of the same components 
                //so no need to merge them 
                
                
                if(lx != ly){
                    //this loop means we are merging the islands 
                    //so we have to decrease the count
                    if(rank[lx] > rank[ly]){
                        parent[ly] = lx;
                    }
                    else if(rank[lx] < rank[ly]){
                        parent[lx] = ly;
                    }else{
                        parent[lx] = ly;
                        rank[ly]++;
                    }
                    
                  count--;  //decrease the count because 2 islands are getting merged 
                }
                
            }
            answer.add(count);
            
        }
        return answer;
    }
    
    public static boolean isValid(int rows, int columns, int i, int j){
        return i  >= 0 && i < rows && j >= 0 && j < columns;
    }
    
    public static int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x],parent);
        parent[x] = temp;
        return temp;
    }
}
