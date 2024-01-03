/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 * Date: 12/20/2023
 *https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 * @author parth
 */
public class MinimumLengthafterDeletingSimilarEnds {

   public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(minimumLength("ca"));
		
	}
	public static int minimumLength(String s){
	int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                char currentChar = s.charAt(i);

                // Delete prefix and suffix with the current character
                while (i <= j && s.charAt(i) == currentChar) {
                    i++;
                }

                while (i <= j && s.charAt(j) == currentChar) {
                    j--;
                }
            } else {
                break;
            }
        }

        return j - i + 1;
	    
    }
}
