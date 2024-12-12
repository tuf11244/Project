/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date:09/08/2024
 * https://leetcode.com/problems/spiral-matrix-iv/
 * @author parth
 */
public class SpiralMatrixIV {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
 
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];

        // Initialize the matrix with -1
        for (int[] row : answer) {
            Arrays.fill(row, -1);
        }

        int rowStart = 0, rowEnd = m - 1;
        int colStart = 0, colEnd = n - 1;

        ListNode temp = head;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse right in the current row
            for (int j = colStart; j <= colEnd && temp != null; j++) {
                answer[rowStart][j] = temp.val;
                temp = temp.next;
            }
            rowStart++;

            // Traverse down in the current column
            for (int i = rowStart; i <= rowEnd && temp != null; i++) {
                answer[i][colEnd] = temp.val;
                temp = temp.next;
            }
            colEnd--;

            // Traverse left in the current row
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart && temp != null; j--) {
                    answer[rowEnd][j] = temp.val;
                    temp = temp.next;
                }
                rowEnd--;
            }

            // Traverse up in the current column
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart && temp != null; i--) {
                    answer[i][colStart] = temp.val;
                    temp = temp.next;
                }
                colStart++;
            }
        }

        return answer;
    }
}
}
