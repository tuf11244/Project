package MathsforDSA;

/**
 * Date: 06/01/2025
 * LeetCode: https://leetcode.com/problems/distribute-candies-among-children-ii/
 *
 * Problem Summary:
 * Distribute `n` candies among 3 children where each child can receive at most `limit` candies.
 * Count the number of valid distributions (non-negative integers ≤ limit) such that their total is exactly `n`.
 *
 * @author parth
 */
public class DistributeCandiesAmongChildrenII {
    
    public static void main(String[] args) {
        // You can test here by calling distributeCandies(n, limit)
    }

    public long distributeCandies(int n, int limit){
        
        // Child1 can get at least max(0, n - 2*limit)
        // Because the remaining 2 children can give at most 2*limit candies.
        int minChild1 = Math.max(0, n - 2 * limit);
        
        // Child1 can get at most min(n, limit)
        int maxChild1 = Math.min(n, limit);
        
        long ways = 0; // to count all valid distributions
        
        // Try all possible values for child1 between minChild1 and maxChild1
        for(int i = minChild1; i <= maxChild1; i++){
            
            // After giving i candies to child1, we have `remaining` candies for child2 and child3
            int remaining = n - i;
            
            // Minimum candies child2 can get is max(0, remaining - limit)
            // This ensures child3 gets ≤ limit candies.
            int minChild2 = Math.max(0, remaining - limit);
            
            // Maximum child2 can get is min(remaining, limit)
            // (Because we can't give more than what's left or above the limit)
            int maxChild2 = Math.min(remaining, limit);
            
            // For each valid `i`, number of ways to choose (child2, child3) pairs is:
            // (maxChild2 - minChild2 + 1)
            // Because for each valid value j for child2, child3 = remaining - j is automatically valid.
            ways = ways + (maxChild2 - minChild2 + 1);
        }

        // Return the total number of valid combinations
        return ways;
    }
}
