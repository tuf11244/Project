/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPPartII;

/**
 *Question 
 * Given a grid of m*n of 0's & 1's. Find the maximum area of triangle

Example

0 1 0 1
0 1 1 0
0 1 1 1
0 1 1 0

Ans = 6
 * @author parth
 */
public class GoogleQuestionMaximumTriangleArea {
    
    public static void main(String[] args) {
        
    }
    
    public static int maxTriangleArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] down = new int[m][n];
        int[][] right = new int[m][n];

        // Fill down matrix: how many 1's downwards from each cell
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    down[i][j] = 1 + (i + 1 < m ? down[i + 1][j] : 0);
                }
            }
        }

        // Fill right matrix: how many 1's to the right from each cell
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                }
            }
        }

        int maxArea = 0;

        // Try forming triangle from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int maxHeight = down[i][j];
                    for (int h = 1; h <= maxHeight; h++) {
                        boolean valid = true;
                        for (int k = 0; k < h; k++) {
                            if (i + k >= m || right[i + k][j] < k + 1) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            int area = h * (h + 1) / 2;
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        return maxArea;
    }
    
    
    
}
