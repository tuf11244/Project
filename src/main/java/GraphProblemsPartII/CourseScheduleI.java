/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/28/2024
 *https://leetcode.com/problems/course-schedule/
 * https://leetcode.com/problems/course-schedule-ii/
 * @author parth
 */
public class CourseScheduleI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] prerequisties = {
            {1,0}
        };
        System.out.println(canFinish(2,prerequisties));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses;i++){
             adj.add(new ArrayList<>());
        }
        //Build the graph
        for(int[] prereqs : prerequisites){
            int src = prereqs[1];
            int nbg = prereqs[0];
            
            adj.get(src).add(nbg);
        }
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses;i++){
            List<Integer> nbrs  = adj.get(i);
            for(int nbg : nbrs){
                indegree[nbg]++;
            }
        }
        
        //Add the indegree with 0 to our queue 
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i); //add the courses with 0 nbrs
            }
        }
        
       int count = 0;
       while(!queue.isEmpty()){
           int rem = queue.poll();
           count++;
           //If it asks to return order add this 
           // answer[idx] = rem;
          // idx++;
           List<Integer> nbrs = adj.get(rem);
           
           for(int nbr : nbrs){
               indegree[nbr]--;
               if(indegree[nbr] == 0){
                   queue.add(nbr);
               }
           }
           
       }
        return count == numCourses;      
       
    }
}
