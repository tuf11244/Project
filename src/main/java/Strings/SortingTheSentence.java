/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;
import java.util.Arrays;
/**
 *https://leetcode.com/problems/sorting-the-sentence/
 * Date: 12/15/2023
 * @author parth
 */
public class SortingTheSentence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String s = "is2 sentence4 This1 a3";
        String[] word = s.split(" ");
        System.out.println(Arrays.toString(word));
       
        sortSentence(word);
    }
    public static void sortSentence(String[] word){
        String[] output = new String[word.length];
        for(String s : word){
            int position  = s.charAt(s.length() - 1) - '0';
            //Since its 0 based indexing and position would be between 1 and 9
            output[position - 1] = s.substring(0,s.length()-1);
        }
        
        StringBuilder answer = new StringBuilder();
        for(String element : output){
            answer.append(element);
            answer.append(" ");
        }
        
        System.out.println(answer.toString().trim());
        }
   
}

