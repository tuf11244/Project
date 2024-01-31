/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Same logic as Add to Array Form of Integer question 
 * Date: 01/27/2024
 *https://leetcode.com/problems/plus-one/
 * @author parth
 */
public class PlusOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = {1,2,3};
        int[] result = plusOne(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] plusOne(int[] digits) {
       int k =1;
        List<Integer> list = new ArrayList<>();
        for(int i = digits.length-1; i >= 0 || k > 0;i--){
            if(i >= 0){
                list.add(0,(digits[i] + k)%10);
                k = (digits[i] + k)/10;
            }else{
                list.add(0,k%10);
                k = k/10;
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
