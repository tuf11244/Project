/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 10/11/2024
 * https://leetcode.com/problems/word-break-ii/
 * @author parth
 */
public class WordBreakII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    private List<String> result;
    private Set<String> dict;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
       
         result = new ArrayList<>();
         dict = new HashSet<>(wordDict);
         
         String currentSentence = "";
         
         solve(0,currentSentence,s);
         
         return result;
    }
    
    public void solve(int idx, String currentSentence, String s){
        
        if(idx >= s.length()){
            result.add(currentSentence.trim());
            return;
        }
        
        for(int j = idx; j < s.length();j++){
            String tempWord = s.substring(idx,j+1);
            
            if(dict.contains(tempWord)){
                
                String tempSentence = currentSentence;
                
                if(!currentSentence.isEmpty()){
                    currentSentence = currentSentence + " ";
                }
                
                currentSentence = currentSentence + tempWord;//Add the tempWord to our sentence 
                
                solve(j+1,currentSentence,s);
                
                currentSentence = tempSentence; //backtrak
            }
        }
    }
}
