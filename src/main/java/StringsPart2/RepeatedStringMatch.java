/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 * Date: 12/20/2023
 *https://leetcode.com/problems/repeated-string-match/
 * @author parth
 */
public class RepeatedStringMatch {

      public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(repeatedStringMatch("abc", "cabcabca"));
    }

    public static int repeatedStringMatch(String a, String b){
        String copyA = a;
        int count = 1;
        while(a.length() <= Math.pow(10,4)){
            if(a.contains(b)){
                return count;
            }
            a = a + copyA;
            count++;
        }
        return -1;
    }
}
