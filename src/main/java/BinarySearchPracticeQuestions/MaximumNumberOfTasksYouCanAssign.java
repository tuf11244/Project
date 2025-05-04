/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchPracticeQuestions;
import java.util.*;
/**
 *Date: 05/01/2025
 * https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/
 * @author parth
 */
public class MaximumNumberOfTasksYouCanAssign {
    
    public static void main(String[] args) {
        
    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength){
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int low = 0;
        int high = Math.min(tasks.length,workers.length);
        
        int answer = -1;
        
        while(low <= high){
            int mid = (high + low)/2;
            
            if(canBeCompleted(tasks,workers,pills,strength,mid)){
                answer = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return answer;
    }
    
    public boolean canBeCompleted(int[] tasks, int[] workers, int pills,int strength, int mid){
        
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        
        for(int i = workers.length-mid; i < workers.length;i++){
            tm.put(workers[i],tm.getOrDefault(workers[i], 0)+1);
        }
        
        return true;
    }
}
