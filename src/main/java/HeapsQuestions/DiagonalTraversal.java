/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 02/25/2025
 * https://leetcode.com/problems/diagonal-traverse/
 * @author parth
 */
public class DiagonalTraversal {
    
    public static void main(String[] args){
        
    }
    public int[] findDiagonalOrder(int[][] mat) {
        
        List<List<Integer>> elements = new ArrayList<>();

        int rowEnd = mat.length;
        int colEnd = mat[0].length;
        int rowStart = 0;
        int colStart = 0;

        while(colStart < colEnd){
            
            List<Integer> temp = new ArrayList<>();

            int i = rowStart; 
            int j = colStart;

            while(isValid(i,j,mat)){
                temp.add(mat[i][j]);
                i--;
                j++;
            }

            elements.add(temp);
            rowStart++;

            if(rowStart == rowEnd){
                colStart++;
                rowStart--;
            }
  
        }

    int[] answer = new int[rowEnd * colEnd];
    int idx = 0;

    for(int i = 0;i < elements.size();i++){
         List<Integer> temp = elements.get(i);

         if(i % 2 == 0){
            for(int j = 0; j < temp.size();j++){
                answer[idx] = temp.get(j);
                idx++;
            }

         }else{
            Collections.reverse(temp);
            for(int j = 0; j < temp.size();j++){
                answer[idx]= temp.get(j);
                idx++;
            }
         }
    }

    return answer;
}

    public boolean isValid(int row, int col, int[][] mat){
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }
    
}
