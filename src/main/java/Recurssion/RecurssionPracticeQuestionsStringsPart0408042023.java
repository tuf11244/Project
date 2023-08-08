/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class RecurssionPracticeQuestionsStringsPart0408042023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String str = "I Love apple";
        char[] arr = {'H','E','L','L','O'};
        //System.out.println(Arrays.toString(reverse(arr,0,arr.length-1))); Question 3
        //System.out.println(str.substring(2));
        //System.out.println(removeAllthea(str));  //Question 1
        //System.out.println(removetheString(str)); //Question 2
        //System.out.println(subSequence(" ","abc")); //Question 4
        //System.out.println(subSequencewithAscii("","abc")); //Question 5
        // TODO code application logic here
    }
    
    //Question 1: Remove all the a's in the String 
    public static String removeAllthea(String str){
      if(str.isEmpty()){
          return "";
      }
      char ch = str.charAt(0);
      if(ch == 'a'){
          return removeAllthea(str.substring(1));
      }   
        return ch + removeAllthea(str.substring(1)); 
        
    }
    
    //Question 2: Remove the enire the String (in this case Apple)
    public static String removetheString(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("apple")){
            return removetheString(str.substring(5));
        }
        return str.charAt(0) + removetheString(str.substring(1));
    }
    
    //Question 3 : LeetCode 344
    public static char[] reverse(char[] arr, int start, int end){
        if(start >= end){
            return arr;
        }
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
          
        return reverse(arr,start+1,end-1);
    }
    
    //Question 4 : Subsets,Subsequences and Permutations and Combinations;---Very Very Important
    public static ArrayList<String> subSequence(String processed, String unProcessed){
        
        if(unProcessed.isEmpty()){
         ArrayList<String> subsets = new ArrayList<>();
         subsets.add(processed);
         return subsets;
        }
        char ch = unProcessed.charAt(0);
        ArrayList<String> left = subSequence(processed + ch, unProcessed.substring(1));
        ArrayList<String> right = subSequence(processed,unProcessed.substring(1));
        
        left.addAll(right);
        return left;  //Whether you written left or right doesn't matter
       
        
    }
    //Question 5 : Ascii Values for the above subsequences 08/05/2023
    public static ArrayList<String> subSequencewithAscii(String processed, String unProcessed){
        
        if(unProcessed.isEmpty()){
         ArrayList<String> subsets = new ArrayList<>();
         subsets.add(processed);
         return subsets;
        }
        char ch = unProcessed.charAt(0);
        
        ArrayList<String> first = subSequencewithAscii(processed + ch, unProcessed.substring(1));
        ArrayList<String> second = subSequencewithAscii(processed,unProcessed.substring(1));
        ArrayList<String> third = subSequencewithAscii(processed + (ch+0),unProcessed.substring(1));
       
        first.addAll(second);
        first.addAll(third);
        
        return first; 
       
        
    }
    
    
    
}
