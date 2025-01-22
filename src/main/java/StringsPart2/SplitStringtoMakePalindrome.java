/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/split-two-strings-to-make-palindrome/
 * Date: 12/20/2023
 * @author parth
 */
public class SplitStringtoMakePalindrome {

  public static void main(String[] args) {
		System.out.println("Hello World");
		//System.out.println(checkPalindromeFormationOp("xxxxf","xecab"));
		
	}
	public boolean checkPalindromeFormation(String a, String b) {
        // Check if there's any split that can make the strings form a palindrome
        return canFormPalindrome(a, b) || canFormPalindrome(b, a);
    }
    
    // Helper function to check if a part of a and b can form a palindrome
    private boolean canFormPalindrome(String a, String b) {
        int left = 0;
        int right = a.length() - 1;
        
        // Move inward and check for the symmetry of characters in both strings
        while (left < right) {
           if(a.charAt(left) == b.charAt(right)){
               left++;
               right--;
           }else{
               return isPalindrome(a.substring(left,right+1)) || isPalindrome(b.substring(left,right+1));
           }
        }
        return true; // If we reached the center, it's already a palindrome
    }
    
    // Helper function to check if a part of the string is a palindrome
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
