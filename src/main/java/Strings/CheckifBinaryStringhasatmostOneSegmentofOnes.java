/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * Date: 12/15/2023
 * @author parth
 *
*/
public class CheckifBinaryStringhasatmostOneSegmentofOnes {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(checkOnesSegment("110011"));
    }
    public static boolean checkOnesSegment(String s){
        for(int i = 1; i < s.length();i++){
            if(s.charAt(i-1) == '0' && s.charAt(i) =='1'){
                return false;
            }
        }
        return true;
    }
}
