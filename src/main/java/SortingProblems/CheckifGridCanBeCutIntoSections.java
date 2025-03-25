/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: 03/24/2025
 * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
 * Based of merge Intervals 
 * @author parth
 */
public class CheckifGridCanBeCutIntoSections {
   
    public static void main(String[] args) {
        
        
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xaxis = new int[rectangles.length][2];
        int[][] yaxis = new int[rectangles.length][2];

        for(int i = 0; i < rectangles.length;i++){
            xaxis[i][0] = rectangles[i][0];
            xaxis[i][1] = rectangles[i][2];
            yaxis[i][0] = rectangles[i][1];
            yaxis[i][1] = rectangles[i][3];
        }

        //Sort the xaxis and yaxis arrays
        Arrays.sort(xaxis,(a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(yaxis,(a,b) -> Integer.compare(a[0],b[0]));

        int[] currentInterval = xaxis[0];
         int horizontal = 1;
        for(int i = 1; i < xaxis.length;i++){
            int[] newInterval = xaxis[i];

            if(currentInterval[1] <= newInterval[0]){
                 horizontal++;
                 currentInterval = newInterval;
                 continue;
            }else{
                //Merge 
                 currentInterval[0] = Math.min(currentInterval[0],newInterval[0]);
                 currentInterval[1] = Math.max(currentInterval[1],newInterval[1]);
            }
        }

        

        currentInterval = yaxis[0];
        int vertical = 1;
        for(int i = 1; i < yaxis.length;i++){
            int[] newInterval = yaxis[i];

            if(currentInterval[1] <= newInterval[0]){
                 vertical++;
                 currentInterval = newInterval;
                 continue;
            }else{
                //Merge 
                 currentInterval[0] = Math.min(currentInterval[0],newInterval[0]);
                 currentInterval[1] = Math.max(currentInterval[1],newInterval[1]);
            }
        }
        

        return horizontal >= 3 || vertical >= 3;

    }
   
    
    
}
