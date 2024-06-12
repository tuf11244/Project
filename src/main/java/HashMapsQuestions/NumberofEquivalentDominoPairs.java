/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 06/12/2024
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 * @author parth
 */
public class NumberofEquivalentDominoPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] dominoes = {
            {1,2},
            {2,1},
            {5,6},
            {3,4}
    };
        System.out.println(numEquivDominoPairs(dominoes));
    }
     public static int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int[] domino : dominoes){
            Arrays.sort(domino);
            String key = domino[0] + "#" + domino[1];
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
         System.out.println(hm);
         
         int pairs = 0;
         for(String key : hm.keySet()){
             int count = 0;
             if(hm.get(key) > 1){
                 count = (hm.get(key) * (hm.get(key) - 1))/2;
                 pairs = pairs + count;
             }
         }
         
         return pairs;
    }
}

    

