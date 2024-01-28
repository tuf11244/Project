/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Date: 01/28/2024
 * @author parth
 */
public class RemoveDuplicatesfromSortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //Arrays.sort(nums);

        for(int i =0; i < nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        int[] expected = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            expected[i] = list.get(i);
        }
        for(int i = 0; i < expected.length;i++){
            nums[i] = expected[i];
        }
        return expected.length;
    }
}
