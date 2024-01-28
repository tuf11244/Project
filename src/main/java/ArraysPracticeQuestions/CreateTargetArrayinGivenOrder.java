/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.com/problems/create-target-array-in-the-given-order/
 * Date: 01/28/2024
 * @author parth
 */
public class CreateTargetArrayinGivenOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] createTargetArray(int[] nums, int[] index) {
         List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            list.add(index[i],nums[i]);
        }
        int[] target = new int[list.size()];
        for(int j = 0; j < list.size();j++){
            target[j] = list.get(j);
        }
        return target;

    }

}
