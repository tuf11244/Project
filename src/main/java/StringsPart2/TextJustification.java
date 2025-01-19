package StringsPart2;

/*
 * License and template-related comments (can be replaced by specific license info or removed if not required).
 */
import java.util.*;

/**
 * Date: 11/29/2024
 * https://leetcode.com/problems/text-justification/
 * Solution author: Parth
 */
public class TextJustification {

    /**
     * Main method for executing the application logic.
     * Currently, it's unused but serves as an entry point for testing.
     */
    public static void main(String args[]) {
        // TODO: Implement or add test cases here if required.
    }

    /**
     * Method to fully justify a list of words into lines with a specified maximum width.
     *
     * @param words    Array of words to justify.
     * @param maxWidth Maximum width for each line of text.
     * @return List of justified strings (lines).
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int currentWidth = words[i].length(); // Current letter count in the line.
            int j = i + 1;
            int emptySlots = 0; // Tracks the spaces between words.

            // Calculate the range of words that can fit in the current line.
            while (j < words.length && currentWidth + emptySlots + words[j].length() + 1 <= maxWidth) { // +1 for space
                currentWidth += words[j].length(); // Update the width with the length of the next word.
                j++;
                emptySlots++; // Increase the number of spaces needed between words.
            }

            // Calculate the remaining spaces to achieve full justification.
            int spacesNeeded = maxWidth - currentWidth;
            int availableSpacesPerSlot = emptySlots == 0 ? 0 : spacesNeeded / emptySlots;
            int extraSpaces = emptySlots == 0 ? 0 : spacesNeeded % emptySlots;

            // Handle the case for the last line, which needs to be left-justified.
            if (j == words.length) {
                availableSpacesPerSlot = 1; // Single space between words.
                extraSpaces = 0; // No extra spaces.
            }

            // Build the justified line and add it to the answer.
            String line = helper(i, j, words, maxWidth, availableSpacesPerSlot, extraSpaces);
            answer.add(line);
            i = j; // Move to the next line's starting word.
        }

        return answer;
    }

    /**
     * Helper function to construct a justified line.
     *
     * @param i                        Start index of the current line in the words array.
     * @param j                        End index (exclusive) of the current line in the words array.
     * @param words                    Array of words.
     * @param maxWidth                 Maximum allowed width for the line.
     * @param availableSpacesPerSlot   Number of evenly distributed spaces per gap.
     * @param extraSpaces              Remaining extra spaces to be distributed across gaps.
     * @return A fully justified line as a String.
     */
    public static String helper(int i, int j, String[] words, int maxWidth, int availableSpacesPerSlot, int extraSpaces) {
        StringBuilder sb = new StringBuilder();

        for (int k = i; k < j; k++) {
            sb.append(words[k]); // Add the word.

            if (k == j - 1) { // If this is the last word in the line, no spaces are needed.
                continue;
            }

            // Add the minimum spaces required for justification.
            for (int e = 1; e <= availableSpacesPerSlot; e++) {
                sb.append(" ");

                if (extraSpaces > 0) { // Distribute extra spaces as needed.
                    sb.append(" ");
                    extraSpaces--;
                }
            }
        }

        // If the line's length is less than maxWidth, pad the remaining spaces at the end.
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString(); // Return the constructed line.
    }
}
