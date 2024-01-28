/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.HashSet;
import java.util.Set;
/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 * @author parth
 */
public class CheckifSentenceisPangram {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       System.out.println("Hello World");
       System.out.println(checkIfPangram("thequicklazybrownfoxjumpsoverthelazydog"));
    }
    public static boolean checkIfPangram(String sentence){
	    Set<Character> set = new HashSet<>();
	    
	    for(int i = 0; i < sentence.length();i++){
	         set.add(sentence.charAt(i));
	    }
	    
	    return set.size() == 26;
	    
	}
}
