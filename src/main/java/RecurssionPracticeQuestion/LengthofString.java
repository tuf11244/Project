/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 * Date: 11/17/2023
 *https://www.geeksforgeeks.org/program-for-length-of-a-string-using-recursion/
 * @author parth
 */
public class LengthofString {

    
    public static void main(String args[]) {
        System.out.println(lengthofString("abcde",0));
    }
    public static int lengthofString(String S, int count){
	    if(S.length() == 0){
	        return count;
	    }
	    return lengthofString(S.substring(1),count+1);
	}
}
