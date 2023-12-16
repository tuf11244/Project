/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 * Date: 12/15/2023
 * @author parth
 */
public class CheckifTwoStringareEqual {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] word1 = {"a","bc"};
        String[] word2 = {"a","c"};
        System.out.println(arrayStringAreEqual(word1,word2));
    }
    public static boolean arrayStringAreEqual(String[] word1, String[] word2){
        String s1 = "";
        String s2 = "";
        for(int i = 0; i < word1.length;i++){
            s1 = s1 + word1[i];
        }
        for(int j = 0; j < word2.length;j++){
            s2 = s2 + word2[j];
        }
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }
}
