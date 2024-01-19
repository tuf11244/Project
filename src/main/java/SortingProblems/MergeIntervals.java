/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Date: 01/19/2024
 * https://leetcode.com/problems/merge-intervals/
 * @author parth
 */
public class MergeIntervals {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] Intervals = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };
        
        int[][] answer = merge(Intervals);
        for(int[] arr : answer){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] merge(int[][] Intervals){
        //Sort the 2D Array
        Arrays.sort(Intervals, (a,b)->Integer.compare(a[0],b[0]));
        
        //Create an ArrayList that has 1D arrays
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int[] interval : Intervals){
            //Empty List add the First Array
            if(list.size()==0){
                list.add(interval);
            }else{
                int[] prevInterval = list.get(list.size()-1);
                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }else{
                    list.add(interval);
                }
            }
        }
        //Convert the ArrayList to 2D Array 
        return list.toArray(new int[list.size()][]);
        
    }
}
