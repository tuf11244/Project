/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 01/26/2024
 * https://leetcode.com/problems/spiral-matrix-iii/
 * Source: BinaryMagic 
 * @author parth
 */
public class SpiralMatrxiIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
      int[][] ans = new int[rows * cols][2];
        ans[0] = new int[]{r, c};

        int size = rows * cols;
        int len = 1;
        int x = r, y = c;
        int index = 1;

        while (index < size) {
            for (int j = 1; j <= len; j++) {
                if (isValid(x, y + j, rows, cols))
                    ans[index] = new int[]{x, y + j};
                    index++;
            }
            y = y + len; // going right;

            for (int j = 1; j <= len; j++) {
                if (isValid(x + j, y, rows, cols))
                    ans[index++] = new int[]{x + j, y};
            }
            x += len; // going down;
            len++;    // increasing length after down in over;

            for (int j = 1; j <= len; j++) {
                if (isValid(x, y - j, rows, cols))
                    ans[index++] = new int[]{x, y - j};
            }
            y -= len; // going left;

            for (int j = 1; j <= len; j++) {
                if (isValid(x - j, y, rows, cols))
                    ans[index++] = new int[]{x - j, y};
            }
            x -= len; // going up;
            len++;
        }

        return ans;  
    }

      public static boolean isValid(int i, int j, int rows, int columns) {
        return i >= 0 && i < rows && j >= 0 && j < columns;
    }
}
