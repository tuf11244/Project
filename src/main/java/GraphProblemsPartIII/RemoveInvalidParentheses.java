package GraphProblemsPartIII;
import java.util.*;

/**
 * Date: 03/12/2025
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Author: Parth
 * Solved using Recurssion also but gives a TLE submission on Leetcode
 */
public class RemoveInvalidParentheses {
    
    public static void main(String[] args) {
        // Main function is empty here, presumably for testing purposes.
    }
    
    /**
     * This function removes invalid parentheses from a string and returns a list of all valid strings.
     * A valid string is one that has balanced parentheses.
     * 
     * @param s the input string with parentheses
     * @return a list of valid strings after removing invalid parentheses
     */
    public static List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>(); // List to store the final valid strings
        
        if (s.length() == 0) {
            return result; // If the input string is empty, return an empty list
        }
        
        Queue<String> queue = new LinkedList<>(); // Queue to perform BFS (Breadth First Search)
        HashSet<String> visited = new HashSet<>(); // Set to track visited strings to avoid cycles
        
        queue.add(s); // Start by adding the original string to the queue
        boolean found = false; // Flag to check if we have found a valid string
        
        while (!queue.isEmpty()) {
            
            String rem = queue.poll(); // Poll a string from the queue
            
            if (visited.contains(rem)) {
                continue; // If this string has already been processed, skip it
            }
            visited.add(rem); // Mark the string as visited
            
            // Check if the string is valid
            if (isValid(rem)) {
                result.add(rem); // If valid, add to the result list
                found = true; // Set the found flag to true
            }
            
            if (found) {
                continue; // If we have found any valid string, stop further processing
            }
            
            // For all characters in the string, remove each parenthesis and add the new string to the queue
            for (int i = 0; i < rem.length(); i++) {
                if (Character.isLetter(rem.charAt(i))) {
                    continue; // Skip letters since we only want to remove parentheses
                }
                
                String newString = rem.substring(0, i) + rem.substring(i + 1); // Remove the parenthesis at index i
                
                if (!visited.contains(newString)) { // Check if the new string has already been processed
                    queue.add(newString); // If not, add it to the queue for further processing
                }
            }
        }
        
        return result; // Return the list of valid strings
    }
    
    /**
     * This function checks if the given string has valid parentheses.
     * A string is valid if the number of opening parentheses '(' matches
     * the number of closing parentheses ')', and they are correctly nested.
     * 
     * @param s the input string
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>(); // Stack to track the parentheses
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                st.push(ch); // Push opening parentheses onto the stack
            } else if (ch == ')') {
                if (st.isEmpty() || st.peek() == ')') {
                    st.push(ch); // If stack is empty or top is ')', push the closing parentheses
                } else {
                    st.pop(); // If stack has '(', pop it as a valid pair is formed
                }
            }
        }
        return st.size() == 0; // If the stack is empty, the parentheses are valid
    }
}
