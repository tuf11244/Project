/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 *https://practice.geeksforgeeks.org/problems/steps-by-knight5927/
 * 10/29/2023
 * @author parth
 */
public class MinimumStepsForKnighttoReachTarget {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] knights = {4, 5}; // Starting position of the knight
        int[] target = {1, 1}; // Target position
        int N = 6; // Size of the chessboard (8x8 in this case)

        int steps = minStep(knights, target, N);
        System.out.println("Minimum steps required: " + steps);
    }
    public static int minStep(int[] knights, int[] target, int N){
        int answer = 0; //how many steps it would take 
        int n = N;
        int tx = target[0] - 1; //Subtracting 1 because its of 1 based Indexing
        int ty = target[1] - 1; //Subtractin 1 because its of 1 based Indexing
        
        if(knights[0] - 1 == tx && knights[1] -1 == ty){ //Case when the postion of knight is same as the target so no need to move
            return 0;
        }
        boolean visited[][] = new boolean[n][n];
        
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(knights[0]-1,knights[1] - 1)); //Subtracting 1 because its of 1 based Indexing
        visited[knights[0] - 1][knights[1] - 1] = true ;//becuase we are already starting from this position so its visited
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer = answer + 1; 
            while(size!= 0){
            Pair current = queue.remove();
            int xx = current.x;
            int yy = current.y;
            int[] ax = {1,1,-1,-1,2,-2,2,-2};
            int[] ay = {2,-2,2,-2,1,1,-1,-1};
            for(int i = 0 ;i < 8; i++){
                int newPositionX = xx + ax[i];
                int newPositionY = yy + ax[i];
                if(newPositionX == tx && newPositionY == ty){
                    return answer;
                }
                if(isValid(newPositionX, newPositionY, n) && !visited[newPositionX][newPositionY]){
                    visited[newPositionX][newPositionY] = true;
                    queue.offer(new Pair(newPositionX, newPositionY));
                }
            }
            size = size - 1;            
        }
        }       
        return answer;
    }
    public static boolean isValid(int row, int column, int N){
        if(row >= 0 && row < N && column >= 0 && column < N){
            return true;
        }
        return false;
    }
    
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
