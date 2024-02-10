/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;
import java.util.TreeMap;

/**
 *
 * @author parth
 */
public class FindRightInterval {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {3,4},
            {2,3},
            {1,2},
        };
        int[] answer = findRightInterval2(arr);
    }
    public static int[] findRightInterval(int[][] arr){
        TreeMap<Integer,Integer> map = new TreeMap();
        
        if(arr.length == 1 && arr[0][0] != arr[0][1]){
            return new int[]{-1};
        }
        if(arr.length == 1 && arr[0][0] == arr[0][1]){
            return new int[]{0};
        }
        for(int i = 0; i < arr.length;i++){
            map.put(arr[i][0], i);
        }
        
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length;i++){
            Integer key = map.ceilingKey(arr[i][1]);
            answer[i] = key == null ? - 1 : map.get(key);
        }
                
        return answer;       
    }
    
    //Easier Method Complexity O(n)
    public static int[] findRightInterval2(int[][] intervals) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int[] result = new int[intervals.length];
    
    // Iterate through intervals to find max and min
    for (int[] interval : intervals) {
        max = Math.max(max, interval[1]);
        min = Math.min(min, interval[0]);
    }
    
    // Initialize bucket array
    int[] bucket = new int[max - min + 1];
    Arrays.fill(bucket, -1);
        System.out.println(Arrays.toString(bucket));
        
    // Fill bucket array based on start points
    for (int i = 0; i < intervals.length; i++) {
        int[] interval = intervals[i];
        bucket[interval[0] - min] = i;
    }
        System.out.println(Arrays.toString(bucket));
    
    // Update bucket array to store nearest right interval
    for (int i = bucket.length - 2; i >= 0; i--) {
        if (bucket[i] == -1) {
            bucket[i] = bucket[i + 1];
        }
    }
    
    // Fill result array based on end points
    for (int i = 0; i < intervals.length; i++) {
        result[i] = bucket[intervals[i][1] - min];
    }
    
    return result;
}

}
