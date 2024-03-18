/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashSet;

/**
 * https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332
 *03/16/2024
 * @author parth
 */
public class CountPairSuminMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int countPairs(int mat1[][], int mat2[][], int n, int x) {
       HashSet<Integer> set = new HashSet<>();
       
       for(int i =0; i < mat1.length;i++){
           for(int j = 0; j < mat1[0].length;j++){
               set.add(mat1[i][j]);
           }
       }
       int count = 0;
       for(int i = 0; i < mat2.length;i++){
           for(int j =0; j < mat2[0].length;j++){
               if(set.contains(x-mat2[i][j])){
                   count++;
               }
           }
       }
       return count;
    }
}
