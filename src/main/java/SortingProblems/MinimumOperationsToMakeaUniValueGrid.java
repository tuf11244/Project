/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *DateL 03/25/2025
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 * @author parth
 */
public class MinimumOperationsToMakeaUniValueGrid {
    public static void main(String[] args) {
        
    }
    
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> remainder = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                list.add(grid[i][j]);
                remainder.add(grid[i][j] % x);
            }
        }

        if (remainder.size() > 1) {
            return -1;  // If different remainders exist, it's impossible
        }

        if (list.size() == 1) {
            return 0;  // If there's only one element, no operations needed
        }

        Collections.sort(list);
        return getMinimumMoves(list, x);
    }

    public int getMinimumMoves(List<Integer> list, int x) {
        int moves = 0;
        int mid = list.get(list.size() / 2);  // The median is the best choice

        for (int num : list) {
            moves += Math.abs(num - mid) / x;  // Difference divided by `x`
        }

        return moves;
    }

}
