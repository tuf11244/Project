/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 01/16/2025
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * Solved it bymyself
 * @author parth
 */
public class MinimumCosttoMakeatleastOneValidPathinaGrid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minCost(int[][] grid) {

        PriorityQueue<Cost> pq = new PriorityQueue<>();
        pq.add(new Cost(0, 0, 0));

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while (!pq.isEmpty()) {

            Cost rem = pq.poll();

            if (!isValid(rem.row, rem.col, grid)) {
                continue;
            }

            if (rem.row == grid.length - 1 && rem.col == grid[0].length - 1) {
                return rem.cost;
            }
            if (visited[rem.row][rem.col]) {
                continue;
            }
            visited[rem.row][rem.col] = true;

            if (grid[rem.row][rem.col] == 1) {
                pq.add(new Cost(rem.row, rem.col + 1, rem.cost));
                pq.add(new Cost(rem.row, rem.col - 1, rem.cost + 1));
                pq.add(new Cost(rem.row + 1, rem.col, rem.cost + 1));
                pq.add(new Cost(rem.row - 1, rem.col, rem.cost + 1));

            } else if (grid[rem.row][rem.col] == 2) {
                pq.add(new Cost(rem.row, rem.col + 1, rem.cost + 1));
                pq.add(new Cost(rem.row, rem.col - 1, rem.cost));
                pq.add(new Cost(rem.row + 1, rem.col, rem.cost + 1));
                pq.add(new Cost(rem.row - 1, rem.col, rem.cost + 1));

            } else if (grid[rem.row][rem.col] == 3) {
                pq.add(new Cost(rem.row, rem.col + 1, rem.cost + 1));
                pq.add(new Cost(rem.row, rem.col - 1, rem.cost + 1));
                pq.add(new Cost(rem.row + 1, rem.col, rem.cost));
                pq.add(new Cost(rem.row - 1, rem.col, rem.cost + 1));

            } else { // grid[rem.row][rem.col] == 4
                pq.add(new Cost(rem.row, rem.col + 1, rem.cost + 1));
                pq.add(new Cost(rem.row, rem.col - 1, rem.cost + 1));
                pq.add(new Cost(rem.row + 1, rem.col, rem.cost + 1));
                pq.add(new Cost(rem.row - 1, rem.col, rem.cost));
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}

class Cost implements Comparable<Cost> {
    int row;
    int col;
    int cost;

    public Cost(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    public int compareTo(Cost o) {
        return this.cost - o.cost;
    }
}

