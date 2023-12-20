/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.com/problems/minimum-time-difference/
 * Date: 12/19/2023
 * @author parth
 */
public class MinimumTimeDifference {

    
    public static void main(String args[]) {
        List<String> timepoints = new ArrayList<>();
        timepoints.add("23:59");
        timepoints.add("00:00");
        System.out.println(findMinDifference(timepoints));
    }
    public static int findMinDifference(List<String> timepoints){
        //Create a new Array to store the time in minutes 
        //For example if timepoints[0] = 23:59 
        //23 is hour , 59 is minutes 
        //That would be convereted to arr[0] = 23 * 60 + 49 
        int[] arr = new int[timepoints.size()];
        
        for(int i = 0; i < timepoints.size();i++){
            String time = timepoints.get(i);
            
            //23:59 is given to us in String 
            //So we don't need ":", that why substring method
            int value = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3)); 
            
            //Store the value in arr
            arr[i] = value;
        }
        
        //sort the array
        Arrays.sort(arr);
        
        //System.out.println(Arrays.toString(arr));
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length;i++){
            min = Math.min(min,arr[i]-arr[i-1]);
        }
       
        
        //Finally we have to check with the first value and last value in array 
        min = Math.min(min,(24*60 - arr[arr.length-1] + arr[0]));
        
        return min;
    }
}
