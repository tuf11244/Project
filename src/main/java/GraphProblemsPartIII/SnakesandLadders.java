/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *
 * @author parth
 */
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/snakes-and-ladders/description/
public class SnakesandLadders {
    public static void main(String[] args){
        
    }
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<BoardPosition> queue = new LinkedList<>();
        queue.add(new BoardPosition(1, 0));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(1); // Mark start as visited

        while (!queue.isEmpty()) {
            BoardPosition rem = queue.poll();

            if (rem.val == n * n) {
                return rem.diceRoll;
            }

            for (int i = rem.val + 1; i <= Math.min(rem.val + 6, n * n); i++) {
                int[] coordinates = getCoordinates(i, n);
                int row = coordinates[0];
                int col = coordinates[1];
                int destination = (board[row][col] == -1) ? i : board[row][col];

                if (!visited.contains(destination)) {
                    visited.add(destination);
                    queue.add(new BoardPosition(destination, rem.diceRoll + 1));
                }
            }
        }
        return -1;
    }

    public int[] getCoordinates(int num, int n) {
        int row = (num - 1) / n;
        int col;
        if (row % 2 == 0) {
            col = (num - 1) % n;
        } else {
            col = n - 1 - (num - 1) % n;
        }
        row = n - 1 - row;
        return new int[]{row, col};
    }
}

class BoardPosition {
    int val;
    int diceRoll;
    
    public BoardPosition(int val, int diceRoll) {
        this.val = val;
        this.diceRoll = diceRoll;
    }
}