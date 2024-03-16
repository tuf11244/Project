/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashSet;

/**
 *
 * @author parth
 */
public class PairswithEqualSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean pairsWithEqualSum(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length;i++){
            for(int j = i+1 ; j < arr.length;j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)){
                    return true;
                }else{
                    set.add(sum);
                }
            }
        }
        return false;
    }
}
