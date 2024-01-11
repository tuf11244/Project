/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Date: 01/10/2024
 *https://leetcode.com/problems/intersection-of-two-arrays/
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * @author parth
 */
public class IntersectionofTwoArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      int num1[] = {4,9,5};
      int num2[] = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(num1,num2)));
    }
    public static int[] intersection(int[] num1, int[] num2){
    //    Arrays.sort(num1);
    //    Arrays.sort(num2);
        ArrayList<Integer> list = new ArrayList<>();
        
        
        int[] smallArray = (num1.length > num2.length) ? num2 : num1;
        boolean flag1 = (smallArray == num2);
        boolean flag2 = (smallArray == num1);
        for(int i = 0; i < smallArray.length;i++){
            if(flag1){
                for(int num : num1){
                    if(num == smallArray[i] && !list.contains(smallArray[i])){
                        list.add(smallArray[i]);
                    }
                }
            }
            if(flag2){
                 for(int num : num2){
                    if(num == smallArray[i] && !list.contains(smallArray[i])){
                        list.add(smallArray[i]);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int j = 0; j < list.size();j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
    
    
    //Better Code 
    public static int[] intersectionOptimized(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < num1.length && j < num2.length) {
            if (num1[i] == num2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != num1[i]) {
                    list.add(num1[i]);
                }
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] answer = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            answer[k] = list.get(k);
        }

        return answer;
    }

}
