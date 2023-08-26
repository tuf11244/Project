/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

/**
 *
 * @author parth
 */
public class Determineifhalvesarealike {

    /**
     * Date: 08/25/2023
     * @param args the command line arguments
     * https://leetcode.com/problems/determine-if-string-halves-are-alike/
     */
    public static void main(String args[]) {      
      halfvesarealike("book");
      
        // TODO code application logic here
    }
    
    public static void halfvesarealike(String S){
        String a = " ";
        String b = " ";
        int counta = 0;
        int countb = 0;
        
        for(int i = 0; i < S.length()/2;i++){
            a = a + S.charAt(i);
        }
        for(int j = S.length()/2; j < S.length();j++){
            b = b + S.charAt(j);
        }
        System.out.println(a);
        System.out.println(b);
        
       for(int x = 0; x < a.length();x++){
           if(isVowel(a.charAt(x))){
               counta++;
           }
           
       }
       for(int y = 0; y < b.length();y++){
           if(isVowel(b.charAt(y))){
               countb++;
           }
           }     
        System.out.println(counta);
        System.out.println(countb);
        if(counta == countb){
            System.out.println("both string are alike");
        }
        else{
           System.out.println("both string are different"); 
        }
        
        
    }      
        public static boolean isVowel(char c){
            c = Character.toLowerCase(c);
        return c =='a'|| c =='e'||c =='i'||c =='o'||c =='u';        
        }
        
    }
        
    


