/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 10/12/2024
 * https://www.geeksforgeeks.org/temple-offerings/
 * This is a classic greedy dynamic programming (DP) approach for solving such problems.
 * @author parth
 */
public class TempleOfferings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] heights = {1 ,4 ,3, 6, 2, 1};
        
        System.out.println(templeOfferings(heights));
    }
    
    public static int templeOfferings(int[] heights){
        int answer = 0;
        
        int[] left = new int[heights.length];
        left[0] = 1; //start with the smallest acceptable value
        
        for(int i = 1; i < heights.length;i++){
           if(heights[i] > heights[i-1]){
               left[i] = left[i-1] + 1;
           }else{
               left[i] = 1;
           }
        }
        
        int[] right = new int[heights.length];
        right[right.length -1] = 1;
        
        for(int i = heights.length - 2; i >= 0;i--){
            if(heights[i] > heights[i+1]){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 1;
            }
        }
        
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        
        for(int i = 0; i < heights.length;i++){
            answer = answer + Math.max(left[i], right[i]);
        }
        
        
        return answer;
    }
}
