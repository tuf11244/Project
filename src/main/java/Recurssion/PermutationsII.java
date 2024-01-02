/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Date: 01/01/2024
 * https://leetcode.com/problems/permutations-ii/
 * @author parth
 */
public class PermutationsII {

   
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        generatepermute(answer,nums,used,temp);

        return answer;
    }
    public static void generatepermute(List<List<Integer>> answer, int[] nums, boolean[] used, List<Integer> temp) {
        if (temp.size() == nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            generatepermute(answer, nums, used, temp);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
    
}
