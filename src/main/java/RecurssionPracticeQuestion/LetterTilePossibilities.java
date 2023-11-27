/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/letter-tile-possibilities/
 * Date: 11/27/2023
 * @author parth
 */
public class LetterTilePossibilities {

   
    public static void main(String args[]) {
        ArrayList<String> answers = subsets("","AAABBC");
        System.out.print(answers + " ");
        System.out.println("");
        System.out.print(removeDuplicates(answers) + " ");
        ArrayList<String> removeDuplicates = removeDuplicates(answers);
        permutationsCount(removeDuplicates);
        //System.out.println("");
    }
    //Same as printing subsequences
    public static ArrayList<String> subsets(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
         ArrayList<String> subsets = new ArrayList<>();
         subsets.add(processed);
         return subsets;
        }
        char ch = unprocessed.charAt(0);
        String first = processed + ch;
        String second = processed;
        //Recurssion Calls
       ArrayList<String> left =  subsets(first,unprocessed.substring(1));
       ArrayList<String> right = subsets(second,unprocessed.substring(1));
        left.addAll(right);
        return left;
    }
    public static ArrayList<String> removeDuplicates(ArrayList<String> answers){
        ArrayList<String> removeDuplicates = new ArrayList<>();
        
        for(String S : answers){
            if(removeDuplicates.contains(S) || S.isEmpty()){
                continue;
            }
            else{
                removeDuplicates.add(S);
            }
        }
        return removeDuplicates;
    }
    public static void permutationsCount(ArrayList<String> removeDuplicates){
        ArrayList<String> permutations = new ArrayList<>();
        for(String x : removeDuplicates){
            permutations("",x,permutations);
        }
        //System.out.println(permutations);
        numTilePossibilities(permutations);
    }
    private static void permutations(String processed,String unprocessed, ArrayList<String> permutations){
        if(unprocessed.isEmpty()){
            permutations.add(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
       for(int i = 0; i <= processed.length();i++){
           String first = processed.substring(0,i);
           String second = processed.substring(i, processed.length());
           permutations(first+ch+second,unprocessed.substring(1),permutations);
       }
    }
    
    public static void numTilePossibilities(ArrayList<String> permutations){
        ArrayList<String> finalAnswer = new ArrayList<>();
        for(String w : permutations){
            if(finalAnswer.contains(w)){
                continue;
            }else{
                finalAnswer.add(w);
            }           
        }
        System.out.println("");
        System.out.println("The total tile possibilites are " + finalAnswer.size());
    }
}
