/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 *https://www.geeksforgeeks.org/tug-of-war/
 * 11/28/2023
 * @author parth
 */
public class TugofWar {
    public static int minDifference = Integer.MAX_VALUE;
     public static String answer = "";
    
    public static void main(String args[]) {
       int[] arr = {3,4,5,-3,100,1,89,54,23,20};
       ArrayList<Integer> set1 = new ArrayList<>();
       ArrayList<Integer> set2 = new ArrayList<>();
       int sumset1 = 0;
       int sumset2 = 0;
       int pointer = 0;
       
      
       tugofWar(arr,pointer,set1,set2,sumset1,sumset2);
       
        System.out.println(answer);
    
    }
    public static void tugofWar(int[] arr, int pointer, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumset1, int sumset2){
        
        //BaseCase 
        if(pointer == arr.length){
         int absoluteDiff = Math.abs(sumset1-sumset2);
         if(absoluteDiff < minDifference){
             minDifference = absoluteDiff;
             answer = set1 + " " + set2;
             return;
         }
    }
        if(set1.size() < (arr.length+1)/2){
            set1.add(arr[pointer]);
          tugofWar(arr,pointer+1,set1,set2,sumset1+arr[pointer],sumset2);
            set1.remove((set1.size()-1));
        }
        if(set2.size() < (arr.length+1)/2){
            set2.add(arr[pointer]);
          tugofWar(arr,pointer+1,set1,set2,sumset1,sumset2+arr[pointer]);
            set2.remove((set2.size()-1));
        }
    }
   
    
    
}
