/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

/**
 *
 * @author parth
 */
public class ReverseprefixofaWord {

    /**
     * @param args the command line arguments
     * Date : 08/25/2023
     * https://leetcode.com/problems/reverse-prefix-of-word/
     */
    public static void main(String args[]) {
        System.out.println(reversePrefix("abcdefd",'z'));
        // TODO code application logic here
    }
    public static String reversePrefix(String word, char c){
        String ans = " ";
        String remaining = "";
        for(int i = 0; i < word.length();i++){
            if(c == word.charAt(i)){
            ans = reverse(word.substring(0, i+1));
            remaining = word.substring(i+1);
             break;
            }
            if(i == word.length()-1 && c != word.charAt(i)){
                return word;
            }
        }
        return ans+remaining;
    }

    private static String reverse(String substring) {
        String reverse = " ";
        for(int i = substring.length()-1; i >= 0;i--){
            reverse = reverse + substring.charAt(i);
        }
        return reverse;
    }
        
}
