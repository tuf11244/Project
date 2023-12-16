/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;
//Date: 12/15/2023
//https://leetcode.com/problems/reverse-words-in-a-string-iii/
import java.util.Arrays;
public class ReverseWordsIII
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		String s = "Let's take LeetCode contest";
		String[] value = s.split(" ");
		System.out.println(Arrays.toString(value));
	//	System.out.println(reverse("Hello World"));
                System.out.println(helper(value));
	    
	}
	public static String reverse(String S){
	    String reverse = "";
	    for(int i = S.length()-1;i>=0;i--){
	        reverse = reverse + S.charAt(i);
	    }
	    return reverse;
	}
	public static String helper(String[] value){
	    String originalReverse = "";
	    for(int i = 0; i < value.length;i++){
	        originalReverse = originalReverse + reverse(value[i]) + " ";
	    }
	    return originalReverse;
	}

}
