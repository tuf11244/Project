/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/27/2024
  https://leetcode.com/problems/maximum-total-importance-of-roads/
 * @author parth
 */
public class MaximumTotalImportanceofRoads {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public long maximumImportance(int n, int[][] roads) {
        long[] indegree = new long[n];
        for(int[] road : roads){
              int src = road[0];
              int nbg = road[1];
              indegree[src]++;
              indegree[nbg]++;
        }

        Arrays.sort(indegree);
        long sum = 0;
        int imp = n;

        for(int i = indegree.length-1; i >=0; i--){
            sum = sum + (indegree[i] * imp);
            imp--;
        }
        return sum;
    }
}
