/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MazeandBacktracking;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class MazeProblem08092023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //System.out.println(countPaths(3,4));
       // printPaths("",3,4);
       // System.out.println(printPathsList("",10,10).size());
       // System.out.println(printPathsListDiagonal("",3,3));
       boolean[][] board = {
           {true, true, true},
           {true, false, true},
           {true, true, true},
       };
       printPathswithRestrictions(" ",board,0,0);
        // TODO code application logic here
    }
    //Condition: Person can move only right and down
    public static int countPaths(int row, int column){
        if(row == 1 || column == 1){
            return 1;
        }
        int left = countPaths(row-1,column);
        int right = countPaths(row, column-1);
        return left+right;
    }
    
    //Printing paths : Condition : Person can move only right and down
    public static void printPaths(String processed, int row, int column){
        if(row == 1 && column == 1){
            System.out.println(processed);
        }
        if(row > 1){
            printPaths(processed + 'D',row-1,column);
        }
        if(column > 1){
            printPaths(processed + 'R', row, column-1);
        }
    }
    
    //Printing Paths (Adding them in ArrayLists): Condition : Person can move only right and down
    public static ArrayList<String> printPathsList(String processed,int row,int column){
        if(row == 1 && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
       ArrayList<String> answer = new ArrayList<>();
        if(row > 1){
          answer.addAll(printPathsList(processed + 'D',row-1,column));
        }
        if(column > 1){
          answer.addAll(printPathsList(processed + 'R',row,column-1));
        }
        return answer;
    }
    
    //Printing Paths (Adding them in ArrayLists) : Condition : Person can move right,down, and diagonal 
     public static ArrayList<String> printPathsListDiagonal(String processed,int row,int column){
        if(row == 1 && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
       ArrayList<String> answer = new ArrayList<>();
        if(row > 1 && column > 1){
          answer.addAll(printPathsListDiagonal(processed + 'D',row -1, column -1)); //For diagonal
        }
        if(row > 1){
          answer.addAll(printPathsListDiagonal(processed + 'V',row-1,column));
        }
        if(column > 1){
          answer.addAll(printPathsListDiagonal(processed + 'H',row,column-1));
        }
        return answer;
    }
     
   //Printing Paths : Condition : There are restrictions and the maze is starting from 0,0
    public static void printPathswithRestrictions(String processed,boolean[][] maze, int row, int column){
        if(row == maze.length -1 && column == maze[0].length-1){
            System.out.println(processed);
            return;
        }
        if(maze[row][column] == false){
            return;
        }
        if(row < maze.length - 1){
            printPathswithRestrictions(processed + 'D',maze,row+1,column);
        }
        if(column < maze[0].length - 1){
            printPathswithRestrictions(processed + 'R',maze, row, column+1);
        }
    }
}
