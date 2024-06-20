/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;
import java.util.*;
/**
 *Date: 06/19/2024
 * https://leetcode.com/problems/magnetic-force-between-two-balls/
 * @author parth
 */
public class MagneticForcebetweentwoballs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 0; //if the two balls are on the same spot
        
        int end = position[position.length-1] - position[0]; //the max difference between the first and last element 
        int answer = 0;
        
        while(low <= end){
            int mid = low + (end - low)/2;
            
            if(helper(position,m,mid)){
                answer = mid;
                low = mid + 1;
            }else{
                end = mid - 1;
            }
        }
       return answer; 
    }
     
     public static boolean helper(int[] position, int m, int mid){
        int count = 1; // Place the first ball at the first position
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= mid) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
     }
}
