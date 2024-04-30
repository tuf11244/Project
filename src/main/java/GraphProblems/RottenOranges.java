/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;
/**
 * Date: 04/29/2024
 *https://leetcode.com/problems/rotting-oranges/
 * @author parth
 */
public class RottenOranges {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("Hello World");
            int[][] grid = {
		    {0,1,1},
		    {1,2,1},
		    {0,0,0}
		};
		
	int ans = rottenOranges(grid);
	System.out.println(ans);
	for(int[] arr : grid){
             System.out.println(Arrays.toString(arr));
	}
    }
    
    public static int direction[][] = {
	 {0,1},
        {1,0},
        {0,-1},
        {-1,0}
	};
    
    public static int rottenOranges(int[][] grid){
	    int freshoranges = 0;
	    Queue<qpair> queue = new LinkedList<>();
	    for(int i = 0; i < grid.length;i++){
	        for(int j = 0 ; j  < grid[0].length;j++){
	            if(grid[i][j] == 2){
	                queue.add(new qpair(i,j,0));
	            } else if(grid[i][j] == 1){
                            freshoranges++;
	            }
	        }
	    }
            
            if(freshoranges == 0){
                return 0;
            }
	    
	    while(!queue.isEmpty()){
	        qpair rem = queue.poll();
                
	        boolean allfreshOj = true;
	        for(int i = 0; i < grid.length;i++){
                    for(int j = 0; j < grid[0].length;j++){
                        if(grid[i][j] == 1){
                            allfreshOj = false;
                        }
                    }
                }
                if(allfreshOj){
                    if(queue.isEmpty()){
                        return rem.time;
                    }else{
                        while(queue.size()!=1){
                            queue.poll();
                        }
                        if(queue.size() == 1){
                            qpair p = queue.poll();
                            return p.time;
                        }
                    }
                   
                }
	        
	        
	        for(int i = 0; i < 4; i++){
	            int rowdash = rem.row + direction[i][0];
	            int coldash = rem.column + direction[i][1];
	            if(isValid(grid,rowdash,coldash) && grid[rowdash][coldash] == 1){
	                queue.add(new qpair(rowdash,coldash,rem.time + 1));
	                grid[rowdash][coldash] = 2;
	            }
	        }
	    }
	    
	 return -1; 
	}
	
	public static boolean isValid(int[][] grid, int row, int column){
	    return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
	}
	
}

class qpair{
    int row;
    int column;
    int time;
    
    public qpair(int row, int column, int time){
        this.row = row;
        this.column = column;
        this.time = time;
    }

    @Override
    public String toString() {
        return "qpair{" + "row=" + row + ", column=" + column + ", time=" + time + '}';
    }
    
    
}
