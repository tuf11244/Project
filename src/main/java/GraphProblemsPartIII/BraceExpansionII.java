package GraphProblemsPartIII;

import java.util.*;

public class BraceExpansionII {
    public static void main(String[] args) {
        // Test the braceExpansionII function with an example input.
        System.out.println(braceExpansionII("{a,b}{c,{d,e}}"));
    }

    // Function to perform brace expansion and return all possible results as a sorted list.
    public static List<String> braceExpansionII(String input) {
        // A set to store the unique result strings (no duplicates).
        Set<String> result = new HashSet<>();
        // A queue to handle the strings for processing.
        Queue<String> queue = new LinkedList<>();

        // Add the input string to the queue as the starting point for processing.
        queue.offer(input);

        // Process the queue while it is not empty.
        while (!queue.isEmpty()) {
            // Dequeue the next string to process.
            String current = queue.poll();

            // If there are no braces left in the string, add it directly to the result.
            if (current.indexOf("{") == -1) {
                result.add(current);
                continue;
            }

            // Find the index of the first opening brace '{'.
            int left = current.indexOf("{");
            int index = left;

            // Find the matching closing brace '}' for the current brace set.
            while (index < current.length() && current.charAt(index) != '}') {
                // Update the left brace index if we encounter a nested '{'.
                if (current.charAt(index) == '{') {
                    left = index;
                }
                index = index + 1; // Move to the next character.
            }

            // The index of the closing brace '}'.
            int right = index;

            // Get the part of the string before the brace set (i.e., the prefix).
            String processed = current.substring(0, left);

            // Split the content inside the braces into separate parts (e.g., "a,b" -> ["a", "b"]).
            String[] processing = current.substring(left + 1, right).split(",");

            // Get the part of the string after the closing brace (i.e., the suffix).
            String unprocessed = current.substring(right + 1);

            // For each part inside the braces, combine it with the prefix and suffix.
            for (String part : processing) {
                // Build a new string by appending the current part to the prefix and suffix.
                StringBuilder sb = new StringBuilder(processed);
                sb.append(part).append(unprocessed);

                // Add the newly formed string to the queue for further processing.
                queue.offer(sb.toString());
            }
        }

        // Convert the result set to a list for sorting.
        List<String> resultList = new ArrayList<>(result);

        // Sort the list lexicographically to return the results in the correct order.
        Collections.sort(resultList);

        // Return the sorted list of strings.
        return resultList;
    }
}
