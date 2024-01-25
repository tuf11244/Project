/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**Date: 01/24/2024
 *https://leetcode.com/problems/spiral-matrix/
 * https://leetcode.com/problems/spiral-matrix-ii/
 * @author parth
 */
public class SpiralMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        spiralOrder(arr);
    }
    public static void spiralOrder(int[][] arr){
        List<Integer> list = new ArrayList<>();

    if (arr == null || arr.length == 0 || arr[0].length == 0) {
        System.out.println("Empty array");
        return;
    }

    int rowStart = 0, rowEnd = arr.length - 1;
    int colStart = 0, colEnd = arr[0].length - 1;

    while (rowStart <= rowEnd && colStart <= colEnd) {
        // Traverse right in the current row
        for (int j = colStart; j <= colEnd; j++) {
            list.add(arr[rowStart][j]);
        }
        rowStart++;

        // Traverse down in the current column
        for (int i = rowStart; i <= rowEnd; i++) {
            list.add(arr[i][colEnd]);
        }
        colEnd--;

        // Traverse left in the current row
        if (rowStart <= rowEnd) {
            for (int j = colEnd; j >= colStart; j--) {
                list.add(arr[rowEnd][j]);
            }
            rowEnd--;
        }

        // Traverse up in the current column
        if (colStart <= colEnd) {
            for (int i = rowEnd; i >= rowStart; i--) {
                list.add(arr[i][colStart]);
            }
            colStart++;
        }
    }

    System.out.println(list);
}
    public static void spiralOrderII(int n){
        int[][] answer = new int[n][n];
        
        
    }
}
