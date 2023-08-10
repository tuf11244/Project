/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MazeandBacktracking;

import java.util.Arrays;

/**
 *
 * @author parth
 */
public class BackTracking08102023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         boolean[][] board = {
           {true, true, true},
           {true, true, true},
           {true, true, true},
       };
         int[][] path = new int[board.length][board[0].length];
       //backtracking("",board,0,0);
         backtrackingPaths("",board,0,0,path,1);
        // TODO code application logic here
    }
    
    public static void backtracking(String processed,boolean[][] maze, int row, int column){
        if(row == maze.length -1 && column == maze[0].length-1){
            System.out.println(processed);
            return;
        }
        if(maze[row][column] == false){
            return;
        }
        //I will set all the places visited to false;
        maze[row][column] = false;
        
        if(row < maze.length - 1){
            backtracking(processed + 'D',maze,row+1,column);
        }
        if(column < maze[0].length - 1){
            backtracking(processed + 'R',maze, row, column+1);
        }
        if(row > 0){
           backtracking(processed + 'U',maze, row-1, column); 
        }
        if(column > 0){
            backtracking(processed + 'L', maze,row,column-1);
        }
        //this line is where function will be over, after getting out, make sure you undo your changes as well
        maze[row][column]= true;
    }
    
    //Print the Paths : i.e. print the numbers  i.e recursion levels
    public static void backtrackingPaths(String processed,boolean[][] maze, int row, int column,int[][] path,int steps){
        if(row == maze.length -1 && column == maze[0].length-1){
            path[row][column] = steps;
            for(int[]arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println("");
            return;
        }
        if(maze[row][column] == false){
            return;
        }
        //I will set all the places visited to false;
        maze[row][column] = false;
        path[row][column] = steps;
        
        if(row < maze.length - 1){
            backtrackingPaths(processed + 'D',maze,row+1,column,path,steps+1);
        }
        if(column < maze[0].length - 1){
            backtrackingPaths(processed + 'R',maze, row, column+1,path,steps+1);
        }
        if(row > 0){
           backtrackingPaths(processed + 'U',maze, row-1, column,path,steps+1); 
        }
        if(column > 0){
            backtrackingPaths(processed + 'L', maze,row,column-1,path,steps+1);
        }
        //this line is where function will be over, after getting out, make sure you undo your changes as well
        maze[row][column]= true;
        path[row][column] = 0;
        
    }
}
