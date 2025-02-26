package GraphProblemsPartIII;
import java.util.*;


/**
 * Date: 02/25/2025
 * Problem: https://leetcode.com/problems/most-profitable-path-in-a-tree/
 * @author Parth
 */
public class MostProfitablePathinaTree {
    
    // This map stores the time at which Bob reaches each node in the tree.
    HashMap<Integer, Integer> mapForBob = new HashMap<>();

    public static void main(String[] args) {
        // Test cases can be added here if needed
    }

    /**
     * Finds the most profitable path for Alice in a tree.
     * 
     * @param edges The edges of the tree represented as an adjacency list.
     * @param bob   The starting position of Bob.
     * @param amount The amount of profit available at each node.
     * @return The maximum profit Alice can collect.
     */
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = edges.length; // The number of edges (nodes are n + 1)
        
        // Creating an adjacency list representation of the graph
        List<Paths>[] graph = new ArrayList[n + 1]; 

        // Initializing the adjacency list for each node
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Constructing the graph using the given edges
        for (int[] edge : edges) {
            int src = edge[0];
            int nbg = edge[1];
            
            // Adding edges in both directions since it's an undirected tree
            graph[src].add(new Paths(src, nbg));
            graph[nbg].add(new Paths(nbg, src));
        }

        // Array to store the maximum profit Alice can collect
        int[] aliceIncome = new int[1];
        aliceIncome[0] = Integer.MIN_VALUE; // Initialize to the smallest possible value

        // Boolean array to track visited nodes
        boolean[] visited = new boolean[n + 1];

        // First, perform DFS to determine the time Bob reaches each node
        dfsForBob(graph, visited, bob, 0, 0);

        // Reset visited array for Alice's DFS traversal
        visited = new boolean[n + 1];

        // Perform DFS for Alice to compute the maximum possible profit
        dfsForAlice(graph, visited, 0, aliceIncome, 0, 0, amount);

        return aliceIncome[0]; // Return the maximum profit Alice can obtain
    }

    /**
     * Performs DFS to calculate the time at which Bob reaches each node.
     *
     * @param graph The adjacency list representation of the tree.
     * @param visited An array to track visited nodes.
     * @param src The current node being processed.
     * @param target The target node Bob starts from.
     * @param time The time step at which Bob reaches the current node.
     * @return True if the target node is reached, False otherwise.
     */
    public boolean dfsForBob(List<Paths>[] graph, boolean[] visited, int src, int target, int time) {

        if (src == target) {
            mapForBob.put(src, time); // Store the time when Bob reaches the target node
            return true;
        }

        visited[src] = true; // Mark the current node as visited
        mapForBob.put(src, time); // Store the time Bob reaches this node

        // Traverse all adjacent nodes (DFS)
        for (Paths p : graph[src]) {
            if (!visited[p.nbg]) { // Process only unvisited nodes
                if (dfsForBob(graph, visited, p.nbg, target, time + 1)) {
                    return true; // If we reach the target, stop recursion
                }
            }
        }

        // Backtracking: Remove the node from Bob's path if it does not lead to the target
        mapForBob.remove(src);
        
        return false;
    }

    /**
     * Performs DFS to calculate the maximum profit Alice can obtain.
     *
     * @param graph The adjacency list representation of the tree.
     * @param visited An array to track visited nodes.
     * @param src The current node being processed.
     * @param aliceIncome An array storing the maximum profit Alice can collect.
     * @param currentIncome The accumulated profit up to this point.
     * @param time The current time step (distance from the root).
     * @param amount The profit associated with each node.
     */
    public void dfsForAlice(List<Paths>[] graph, boolean[] visited, int src, int[] aliceIncome, int currentIncome, int time, int[] amount) {
        
        visited[src] = true; // Mark the current node as visited

        // If Bob hasn't reached this node yet, Alice takes full profit
        if (!mapForBob.containsKey(src) || time < mapForBob.get(src)) {
            currentIncome += amount[src];
        } 
        // If Bob and Alice reach at the same time, split the profit
        else if (time == mapForBob.get(src)) {
            currentIncome += (amount[src] / 2);
        }

        // Check if this is a leaf node (only one connection and not the root)
        if (graph[src].size() == 1 && src != 0) {
            aliceIncome[0] = Math.max(aliceIncome[0], currentIncome); // Update max profit
        }

        // Perform DFS for all unvisited neighboring nodes
        for (Paths p : graph[src]) {
            if (!visited[p.nbg]) {
                dfsForAlice(graph, visited, p.nbg, aliceIncome, currentIncome, time + 1, amount);
            }
        }
    }
}

/**
 * Helper class representing an edge in the tree.
 */
class Paths {
    int src; // Source node
    int nbg; // Neighbor node

    /**
     * Constructor to initialize a new edge.
     * 
     * @param src The source node.
     * @param nbg The destination node.
     */
    public Paths(int src, int nbg) {
        this.src = src;
        this.nbg = nbg;
    }
}
