/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date: 11/22/2024
 *https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 * @author parth
 */
public class FlipColumnsforMaxEqualRows {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
     public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i = 0; i < matrix.length;i++){
              
              StringBuilder notFlipped = new StringBuilder();
              StringBuilder flipped = new StringBuilder();
            for(int j = 0; j < matrix[0].length;j++){
                notFlipped.append(matrix[i][j]);
                flipped.append(matrix[i][j] == 0 ? 1 : 0);

            }

            hm.put(flipped.toString(),hm.getOrDefault(flipped.toString(),0)+1);
            hm.put(notFlipped.toString(),hm.getOrDefault(notFlipped.toString(),0)+1);
        }
        
        int max  = 0;

        for(String key : hm.keySet()){
            max = Math.max(max,hm.get(key));
        }

        return max;
    }

}
