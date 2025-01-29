/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;

/**
 * Date: 01/28/2025
 * https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
 * @author parth
 */
public class MaximumEmployeestoBeInvitedtoaMeeting {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    /**
     * Finds the maximum number of employees that can be invited to a meeting.
     * This uses graph traversal and BFS to determine cycles and connections.
     *
     * @param favorite the array representing employees and their favorite employee
     * @return the maximum number of employees that can be invited
     */
    public int maximumInvitations(int[] favorite){
        
        // Initialize a graph where each node (employee) will store its connections.
        List<Employee>[] graph = new ArrayList[favorite.length];
        
        for(int i = 0; i < favorite.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        // Reverse the graph to track the incoming relationships from other employees.
        for(int i = 0; i < favorite.length; i++){
            int u = i; // Current employee
            int v = favorite[i]; // The employee that `u` considers favorite
            
            graph[v].add(new Employee(v, u)); // Reverse Graph so that we can find the path length 
        }
        
        // Initialize variables for tracking the maximum cycle length and happy couples (cycles of length 2).
        int maxCycleLength = 0;
        int HappyCouple = 0; // For tracking cycle length of 2 (happy couple)
        
        // Visited array to track if a node (employee) has already been visited during traversal.
        boolean[] visited = new boolean[favorite.length];
        
        // Iterate over all employees.
        for(int i = 0; i < favorite.length; i++){
            
            // Skip if the employee has already been visited.
            if(!visited[i]){
                
                // A map to store employee nodes and their count when traversing (used for detecting cycles).
                HashMap<Integer, Integer> hm = new HashMap<>();
                int currentNode = i;  // Current employee being checked
                int currentNodeCount = 0;
                
                // Traverse until a cycle is detected or we run out of nodes to process.
                while(!visited[currentNode]) {
                    visited[currentNode] = true; // Mark the employee as visited
                    hm.put(currentNode, currentNodeCount); // Record the current position in the traversal
                    
                    // Move to the next employee in the favorite list.
                    int nextNode = favorite[currentNode];
                    currentNodeCount++;  // Increment the count for this employee
                    
                    // Check if a cycle is detected (if we revisit an employee).
                    if(hm.containsKey(nextNode)){
                        
                        int cycleLength = currentNodeCount - hm.get(nextNode); // Calculate the cycle length
                        maxCycleLength = Math.max(cycleLength, maxCycleLength); // Update maximum cycle length
                        
                        // Special case for a cycle of length 2 (happy couple)
                        if(cycleLength == 2) { 
                            // Track the visited employees in the cycle of length 2
                            boolean[] visitedNodes = new boolean[favorite.length];
                            visitedNodes[currentNode] = true;
                            visitedNodes[nextNode] = true;
                            // Add the pair and any reachable employees to HappyCouple count
                            HappyCouple += 2 + BFS(currentNode, graph, visitedNodes) + BFS(nextNode, graph, visitedNodes);
                        }
                        break;
                        
                    } else {
                        // Move to the next employee if no cycle is found.
                        currentNode = nextNode;
                    }
                }
            }
        }
        
        // Return the maximum of the longest cycle and the happy couple case count.
        return Math.max(maxCycleLength, HappyCouple);
    }
    
    /**
     * Breadth-first search (BFS) for exploring the longest path from the given starting node.
     * 
     * @param src the starting node
     * @param graph the employee graph
     * @param visitedNodes the list of already visited nodes
     * @return the maximum distance from the starting node to any other node
     */
    public int BFS(int src, List<Employee>[] graph, boolean[] visitedNodes){
        int maxDistance = 0;
        
        // Initialize a queue for BFS. Each queue entry is a pair of (node, distance).
        Queue<int[]> queue = new LinkedList<>();
        
        // Add the starting node with distance 0.
        queue.add(new int[]{src, 0});
        
        // Perform BFS until all reachable nodes have been visited.
        while(!queue.isEmpty()){
            int[] rem = queue.poll();
            
            int currentNode = rem[0]; // Current employee being processed
            int currentDistance = rem[1]; // Distance from source
            
            visitedNodes[currentNode] = true; // Mark this node as visited
            
            // Explore neighbors (i.e., other employees in the graph)
            for(Employee e : graph[currentNode]){
                if(!visitedNodes[e.nbg]){ // If the neighbor hasn't been visited yet
                    queue.add(new int[]{e.nbg, currentDistance + 1}); // Enqueue neighbor with increased distance
                    maxDistance = Math.max(maxDistance, currentDistance + 1); // Update the maximum distance
                }
            }
        }
        
        // Return the maximum distance found
        return maxDistance;  
    }
}

/**
 * Employee class to hold a pair of (source, neighbor) relationships in the graph.
 * src - the employee who has a favorite
 * nbg - the employee who is the favorite (i.e., the target)
 */
class Employee{
    int src;  // Source employee
    int nbg;  // Neighbor (favorite employee)

    // Constructor to initialize an employee pair (source and neighbor)
    public Employee(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
