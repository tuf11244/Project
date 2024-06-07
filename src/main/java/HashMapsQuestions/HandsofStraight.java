/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 06/06/2024
 * https://leetcode.com/problems/hand-of-straights/
 * @author parth
 */
public class HandsofStraight {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] hand = {1,2,3,6,2,3,4,7,8};
        System.out.println(isNStraightHand(hand,3));
    }
    
    public static boolean isNStraightHand(int[] hand, int groupSize) {
     if(hand.length % groupSize != 0){
         return false;
     }
     
     TreeMap<Integer,Integer> tm = new TreeMap<>();
     for (int card : hand) {
            tm.put(card, tm.getOrDefault(card, 0) + 1);
       }
        System.out.println(tm);
     while (!tm.isEmpty()) {
            int curr = tm.firstKey();
            System.out.println(curr);
            for (int i = 0; i < groupSize; i++) {
                if (!tm.containsKey(curr + i)) {
                    return false;
                }

                tm.put(curr + i, tm.get(curr + i) - 1);
                if (tm.get(curr + i) == 0) {
                    tm.remove(curr + i);
                }
            }
        }
        return true;
     
      
    }
    
   
}
