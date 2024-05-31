/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/27/2024
 *https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * @author parth
 */
public class TimeNeededInformtoEmployees {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class Solution {
    public static int max;
    public static int answer;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    // Create an adjacency list for the manager-subordinate relationships
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                if (!hm.containsKey(manager[i])) {
                    hm.put(manager[i], new ArrayList<>());
                }
                hm.get(manager[i]).add(i);
            }
        }
        answer = 0;
        max = 0;
         // Perform DFS to find the maximum time needed to inform all employees
        dfs(headID, hm, informTime);
        return max;
       
        
}
private void dfs(int current, HashMap<Integer, List<Integer>> hm, int[] informTime) {
       max = Math.max(max,answer);
       
       if(hm.containsKey(current)){
       for(int subordinate : hm.get(current)){
            answer = answer + informTime[current];
            dfs(subordinate,hm,informTime);
            answer = answer - informTime[current]; //backtrack
       }
    }
}
}
