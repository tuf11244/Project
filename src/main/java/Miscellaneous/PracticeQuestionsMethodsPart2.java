/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;
/**
 *
 * @author parth
 */
public class PracticeQuestionsMethodsPart2{
/*
// Practice Question 1 : To count the number of vowels using Java methods
   static int Vowels(String enter){
   int count = 0;
   for(int i = 0; enter.length() > i ;i++){
    if(enter.charAt(i) == 'a' || enter.charAt(i) == 'e' || enter.charAt(i) == 'i' || enter.charAt(i) == 'o' || enter.charAt(i) == 'u'){
   count++;
    }     
   }
   return count;
}
    /**
     * @param args the command line arguments
     */
 /*   
    public static void main(String args[]) {
        System.out.println("Please the enter the string of your choice and this program with let you know the number of vowels in the string");
        Scanner console = new Scanner(System.in);
        String numberOfVowels = console.nextLine();
        int z = Vowels(numberOfVowels);
        System.out.println("The number of vowels in the string you entered is " + " " + z);
        
        //System.out.println(numberOfVowels);
        // TODO code application logic here
    }*/
    
// Practice Question 2 : Counting the number of words in a string using a method
   
   public static void main(String args[]) {
        System.out.println("Please the enter the string of your choice and this program with let you know the number of vowels in the string");
        Scanner console = new Scanner(System.in);
        String numberOfWords = console.nextLine();
        PracticeQuestionsMethodsPart2 obj = new PracticeQuestionsMethodsPart2();
        int z = obj.Words(numberOfWords);
        System.out.println("The number of worlds in the string you entered is " + " " + z);
        
        //System.out.println(numberOfVowels);
        // TODO code application logic here
    }
   
   int Words(String enter){
       int count = 0;
       //for (int i =0; i < enter.length(); i++){
           if(!(" ".equals(enter.substring(0,1))) || !(" ".equals(enter.substring(enter.length() - 1)))){
               for(int i = 0; i < enter.length(); i++){
                   if(enter.charAt(i) == ' '){
                   count++;
               }
                   count = count + 1;
                   
               }
           }
       
           return count;
   }
    
    
}
