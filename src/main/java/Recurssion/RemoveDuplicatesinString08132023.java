/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class RemoveDuplicatesinString08132023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String s = "abbaxy";
      //  System.out.println(removeDuplicates(s));
        removeDuplicates("",s);
        System.out.println(removeDuplicateswithString("",s).length());
    }
    public static String removeDuplicates(String S){
        String newString = "";
        for(int i = 0; i < S.length();i++){
            char ch = S.charAt(i);
            if(newString.indexOf(ch)== -1){
                newString = newString + ch;
            }
        }
        return newString;
    }
    
    public static void removeDuplicates(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
           return;
        }
        char ch = unprocessed.charAt(0);
        if(processed.indexOf(ch)== -1){
          removeDuplicates(processed+ch,unprocessed.substring(1));
        }
        else{
            removeDuplicates(processed,unprocessed.substring(1));
        }
    }
    
    public static String removeDuplicateswithString(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
           return processed;
        }
        char ch = unprocessed.charAt(0);
        if(processed.indexOf(ch)== -1){
           return removeDuplicateswithString(processed+ch,unprocessed.substring(1));
        }
        
           return removeDuplicateswithString(processed,unprocessed.substring(1));
       
    }
         
    }

