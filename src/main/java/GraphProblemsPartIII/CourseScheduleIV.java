/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 01/26/2025
 *https://leetcode.com/problems/course-schedule-iv/
 * @author/parth
 */
public class CourseScheduleIV {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public boolean[][] memo;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Boolean> answer = new ArrayList<>();

        memo = new boolean[numCourses][numCourses];

        if(prerequisites.length == 0){
            for(int i = 0; i < queries.length;i++){
                 answer.add(false);
            }
            return answer;
        }

        List<Course> [] graph = new ArrayList[numCourses];

        for(int i = 0; i < graph.length;i++){
            graph[i] = new ArrayList<>();
        } 

        for(int[] pre : prerequisites){
            int src = pre[0];
            int nbg = pre[1];

            graph[src].add(new Course(src,nbg));
        }
        
        for(int i  = 0; i < numCourses;i++){
             bfs(graph,i);
        }

        for(int i = 0; i < queries.length;i++){
             int src = queries[i][0];
             int nbg = queries[i][1];
            
             answer.add(memo[src][nbg]);
        }
        return answer;
    }

    public void bfs(List<Course> [] graph, int src){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int rem = queue.poll();

            if(memo[src][rem]){
                continue;
            }

            memo[src][rem] = true;

            for(Course e : graph[rem]){
                queue.add(e.nbg);
            }
        }
    }
}
class Course{
    int src;
    int nbg;

    public Course(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
