/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class Permutations08082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       // permutations("","parth");
      //  System.out.println(permutationsList("","parth"));
       // System.out.println(permutationsList("","parth").size());
      // permutationswithSpaces("A","BCD");
       //permutationswithCases("","abc");
       ArrayList<String> answer = new ArrayList<>();
       permutationswithLetterCase("","a1B2",answer);
        System.out.println(answer);
        // TODO code application logic here
    }
    
    public static void permutations(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        
        for(int i = 0; i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            permutations(first + ch + second,unprocessed.substring(1));
        }
        
    }
    
     public static ArrayList<String> permutationsList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        
        ArrayList<String> answer = new ArrayList<String>();
        
        for(int i = 0; i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            answer.addAll(permutationsList(first + ch + second,unprocessed.substring(1)));
            
        }
        return answer;
        
    }
     
    public static int permutationsCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){ 
            return 1;
        }
        char ch = unprocessed.charAt(0);
        int count = 0;
        for(int i = 0; i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            count = count +  permutationsCount(first + ch + second,unprocessed.substring(1));
        }
        return count;
        
    }
    //Permutations with Spaces
    public static void permutationswithSpaces(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        
        String first = processed + " " + ch;
        String second = processed + ch;
        
        //Recursivce calls 
        permutationswithSpaces(first,unprocessed.substring(1));
        permutationswithSpaces(second,unprocessed.substring(1));
        
        return;
       
    }
    //Permutation with Cases
    public static void permutationswithCases(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        
        String first = processed + Character.toUpperCase(ch);
        String second = processed + ch;
        
        //Recursivce calls 
        permutationswithCases(first,unprocessed.substring(1));
        permutationswithCases(second,unprocessed.substring(1));
        
        return;
       
    }
    public static void permutationswithLetterCase(String processed,String unprocessed, ArrayList<String> answer){
        if(unprocessed.isEmpty()){
            answer.add(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        if(Character.isDigit(ch)){
            String first = processed + ch;
            permutationswithLetterCase(first, unprocessed.substring(1),answer);
            
        } else {
             String first = processed + Character.toLowerCase(ch);
             String second = processed + Character.toUpperCase(ch);
             permutationswithLetterCase(first,unprocessed.substring(1),answer);
             permutationswithLetterCase(second,unprocessed.substring(1),answer);
            }
        }
    }
    

