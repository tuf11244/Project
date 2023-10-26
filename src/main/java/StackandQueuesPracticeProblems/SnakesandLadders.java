/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

/**
 *
 * @author parth
 */
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/snakes-and-ladders/description/
public class SnakesandLadders {
    public static void main(String[] args){
        System.out.println("hello,world !");
            // Example test case
        int[][] board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };

        int result = snakesAndLadders(board);
        System.out.println("Minimum number of moves: " + result);
    }
    
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // Start from cell 1
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return moves; // Reached the destination
                }

                // Roll the dice from 1 to 6
                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next > n * n) {
                        break; // If the next cell is outside the board, skip
                    }

                    int[] coordinates = getCoordinates(next, n);
                    int row = coordinates[0];
                    int col = coordinates[1];

                    // If the cell has a snake or ladder, go to the destination cell
                    int value = board[row][col] == -1 ? next : board[row][col];

                    if (!visited[value]) {
                        queue.offer(value);
                        visited[value] = true;
                    }
                }
            }
            moves++;
        }

        return -1; // No way to reach the destination
    }

    // Helper function to convert cell number to coordinates
    private static int[] getCoordinates(int num, int n) {
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
