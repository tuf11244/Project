/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 03/09/2025
 * https://leetcode.com/problems/alternating-groups-ii/
 * @author parth
 */
public class AlternatingGroupsII {
    
    public static void main(String[] args){
        
    }
    public int numberOfAlternatingGroups(int[] colors, int k) {


         int[] arr  = new int[colors.length * 2];
         
         for(int i = 0; i < colors.length;i++){
                arr[i] = colors[i];
                arr[i+colors.length] = colors[i];
         }

         int i = 1;
         int j = 0;
         int answer = 0;
         while(j < colors.length){
            if(arr[i] == arr[i-1]){
                j = i;
            }
            //valid vindow
            if(i-j+1 == k){
                answer++;
                j++;
            }

                i++;
         }

         return answer;
    }
}
