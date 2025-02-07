/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.*;
/**
 *Date: 02/07/2025
 * https://leetcode.com/problems/word-search-ii/
 * Passes 63/65 test cases 
 * @author parth
 */
public class WordSearchII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();

        for (String word : words) {
            
            // Try finding the word in the board
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                        result.add(word);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

   

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // Base cases
        if (index == word.length()) {
            return true; // All characters matched
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        // Mark the cell as visited by temporarily altering its value
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four directions
        boolean found = dfs(board, word, index + 1, row + 1, col) ||
                        dfs(board, word, index + 1, row - 1, col) ||
                        dfs(board, word, index + 1, row, col + 1) ||
                        dfs(board, word, index + 1, row, col - 1);

        // Revert the cell back to its original state
        board[row][col] = temp;

        return found;
    }
}
