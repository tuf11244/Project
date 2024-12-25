/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 12/24/2024
 * https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/
 * @author parth
 */
public class FindBuildingwhereAliceandBobcanMeet {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] answer = new int[queries.length]; // Array to store results for each query
        Arrays.fill(answer, -1); // Initialize with -1 (default for unanswered queries)

        // Map to group queries by their maximum index in the input array
        HashMap<Integer, List<QueryPair>> queryMap = new HashMap<>();

        // Priority Queue (min-heap) based on QueryPair's compareTo method
        PriorityQueue<QueryPair> pq = new PriorityQueue<>();

        // Step 1: Preprocess queries and directly answer simple ones
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0]; // First building index in the query
            int b = queries[i][1]; // Second building index in the query

            if (a == b) {
                // Both indices are the same, Alice and Bob already meet
                answer[i] = a;
            } else if (a > b && heights[a] > heights[b]) {
                // Alice moves left and meets Bob at index `a`
                answer[i] = a;
            } else if (a < b && heights[a] < heights[b]) {
                // Alice moves right and meets Bob at index `b`
                answer[i] = b;
            } else {
                // This query requires more computation:
                // Store it in the queryMap using the max index of (a, b) as the key
                int key = Math.max(a, b);
                QueryPair queryPair = new QueryPair(Math.max(heights[a], heights[b]), i);
                queryMap.computeIfAbsent(key, k -> new ArrayList<>()).add(queryPair);
            }
        }

        // Step 2: Process the heights array and resolve remaining queries
        for (int i = 0; i < heights.length; i++) {
            // Process queries from the priority queue whose height requirements are met
            while (!pq.isEmpty() && pq.peek().maxHeight < heights[i]) {
                QueryPair query = pq.poll();
                answer[query.queryIndex] = i; // The leftmost building index is `i`
            }

            // Add new queries (from queryMap) with `i` as the maximum index into the priority queue
            if (queryMap.containsKey(i)) {
                for (QueryPair query : queryMap.get(i)) {
                    pq.offer(query);
                }
            }
        }

        return answer; // Return the final results array
    }
}

// Helper class representing a query
class QueryPair implements Comparable<QueryPair> {
    int maxHeight; // Maximum height requirement for the query
    int queryIndex; // Index of the query in the original input

    public QueryPair(int maxHeight, int queryIndex) {
        this.maxHeight = maxHeight; // Initialize max height
        this.queryIndex = queryIndex; // Initialize query index
    }

    @Override
    public int compareTo(QueryPair other) {
        // Sort based on maxHeight, smallest first (min-heap behavior)
        return Integer.compare(this.maxHeight, other.maxHeight);
    }
}

