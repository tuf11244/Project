/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Date: 01/07/2023
 *https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations
 * @author parth
 */
public class CheckifStringisTransformablewithSubstringSortOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean isTransformable(String s, String t){
	    //Below is an Array of 10 ArrayList;
	    ArrayList<Integer> indices[] = new ArrayList[10];
	    
	    // Array to keep track of how many digits have been processed so far
	    int countSoFar[] = new int[10];
	    
	    System.out.println(Arrays.toString(countSoFar));
	    
	    //Below loop creates an Array of 10 empty ArrayList's
	    // Initializing the indices array with empty ArrayLists
	    for(int i = 0; i <= 9;i++){
	        indices[i] = new ArrayList<>();
	    }
	    // Storing the indices of each digit in s
	    for(int i = 0; i < s.length();i++){
	        indices[s.charAt(i) - '0'].add(i);
	    }
	     // Iterating through each digit in t
	    for(int i = 0; i < t.length();i++){
	        int currentDigit = t.charAt(i) - '0';
	        int countofCurrentDigits = indices[currentDigit].size();
	        
	        //// If we have used all occurrences of the current digit in s, return false
	        if(countSoFar[currentDigit] >= countofCurrentDigits){
	            return false;
	        }
	        // Check for any smaller digits that still need to be processed
	        for(int numLessThanCurrent = 0; numLessThanCurrent < currentDigit;numLessThanCurrent++){
	            
	            // Check if there are remaining occurrences of the smaller digit
	            boolean flag = countSoFar[numLessThanCurrent] < indices[numLessThanCurrent].size();
	            
	            // Check the order of occurrences for the current and smaller digits
	            if(flag && indices[numLessThanCurrent].get(countSoFar[numLessThanCurrent]) < indices[currentDigit].get(countSoFar[currentDigit])){
	                return false;
	            }
	        }
	        //// Move to the next occurrence of the current digit in s
	        countSoFar[currentDigit] = countSoFar[currentDigit] + 1;
	    }
	    System.out.println(Arrays.toString(indices));
	    return true;
	    
	}
}
