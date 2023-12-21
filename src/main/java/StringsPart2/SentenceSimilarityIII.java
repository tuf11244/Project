/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/sentence-similarity-iii/
 * Date: 12/20/2023
 * @author parth
 */
public class SentenceSimilarityIII {

    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(areSentencesSimilar("My name is Haley","My Haley"));
	}
	public static boolean areSentencesSimilar(String s1, String s2) {
        String shorter = s1.length() > s2.length() ? s2 : s1;
        String longer = shorter.equals(s1) ? s2 : s1;
        String[] longWords  = longer.split(" ");
        String[] shortWords = shorter.split(" ");
        int diff= 0;
        
        int i = 0;
        int j = 0;
        while( i < shortWords.length && j < longWords.length){
            if(shortWords[i].equals(longWords[j])){
                i++;
                j++;
            }else{
                diff = diff + 1;
                if(diff > 1){
                    break;
                }
                while(j < longWords.length && !shortWords[i].equals(longWords[j])){
                    j++;
                }
            }
        }
        if((diff == 0 && i == shortWords.length)||(diff == 1 && i == shortWords.length && j == longWords.length)){
            return true;
        }
        //Reset the pointers 
        i = shortWords.length -1;
        j = longWords.length - 1;
        diff = 0;
        
        while(i >= 0 && j >= 0){
              if(shortWords[i].equals(longWords[j])){
                i--;
                j--;
            }else{
                diff = diff + 1;
                if(diff > 1){
                    return false;
                }
                while(j >= 0 && !shortWords[i].equals(longWords[j])){
                    j--;
                }
            }
        }
        return (diff == 0 && i == -1)||(diff == 1 && i == -1 && j == -1);
        
    }
}
