/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date: 03/20/2024
 * https://leetcode.com/problems/4sum-ii/
 * @author parth
 */
public class FourSumII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public  static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int count = 0;
    //Create a frequency Map of the combinations of nums1 and nums2
    HashMap<Integer,Integer> hm = new HashMap<>();

    for(int x : nums1){
        for(int y : nums2){
            hm.put(x+y,hm.getOrDefault(x+y,0)+1);
        }
    }

    int target = 0;
    /* You were given 4 arrays A,B,C,D, for the first 2 arrays you created a frequency map 
        now using the combination of the next 2 arrays which are C and D you have to search if 
        target - CD[j] value exists in our hashmap

        AB[i] + CD[j] = target 
        AB[i] = target - CD[j];
    */
    for(int x : nums3){
        for(int y : nums4){
            if(hm.containsKey(target - (x + y))){
                //We have to get the frequency since we are asked to return the count of tuples 
                //which equal to 0
                count = count + hm.get(target-(x+y));
            }
        }
    }
    return count;
    }
}
