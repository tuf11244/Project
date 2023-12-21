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
		System.out.println(checkPalindromeFormation("ulacfd","jizalu"));
		
	}
	public static boolean checkPalindromeFormation(String a,String b){
	    if(a.length() == 1 && b.length() == 1){
	        return true;
	    }
	    for(int i = 0; i < a.length();i++){
	        String aprefix = a.substring(0,i+1);
	        String asuffix = a.substring(i+1);
	        String bprefix = b.substring(0,i+1);
	        String bsuffix = b.substring(i+1);
	        if(isPalindrome(aprefix+bsuffix) || isPalindrome(bprefix+asuffix)){
	            return true;
	        }
	    }
	    return false;
	}
	public static boolean isPalindrome(String result){
	    return result.equals(reverse(result));
	}
	public static String reverse(String s){
	    String reverse = "";
	    for(int i = s.length()-1; i >= 0;i--){
	        reverse = reverse + s.charAt(i);
	    }
	    return reverse;
	}
   
}

//Optimized Method;
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(a.length() == 1 && b.length() == 1){
	        return true;
	    }
        return canFormPalindrome(a, b) || canFormPalindrome(b, a);
	
    }
    public  boolean canFormPalindrome(String a, String b) {
        int len = a.length();

        for (int i = 0; i < len / 2; i++) {
            if (a.charAt(i) != b.charAt(len - 1 - i)) {
                return isPalindrome(a.substring(i, len - i)) || isPalindrome(b.substring(i, len - i));
            }
        }

        return true;
    }
    public  boolean isPalindrome(String result){
	    return result.equals(reverse(result));
	}
	public  String reverse(String s){
	    StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
	}
}
