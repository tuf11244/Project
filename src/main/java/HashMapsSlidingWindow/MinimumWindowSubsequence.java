package HashMapsSlidingWindow;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 * This question was asked in AirBnb
 * Date: 11/26/2024
 * https://leetcode.com/problems/minimum-window-subsequence/
 *Date: 11/26/2024
 * @author parth
 */
public class MinimumWindowSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        String paragraph = "I want to work for Airbnb because they provide amazing benefits and career potential to their employees, and their vision and message are stellar examples for other modern companies to follow. The idea of belonging anywhere and championing the mission? That's a great goal.";
        String keywords = "and are for";
        
        String[] s = paragraph.split(" ");
        String[] t = keywords.split(" ");
        
        String[] answer = new String[s.length];
        
       int desiredCount = t.length;
       
       //Create a HashMap to for the t array to store the words and the frequency of the words 
       HashMap<String,Integer> hmForT = new HashMap<>();
       
       for(String x  : t){
           hmForT.put(x,hmForT.getOrDefault(x,0)+1);
       }
       
       HashMap<String,Integer> hmForS = new HashMap<>();
       
       int matchCount = 0;
       int i = -1;
       int j = -1;
       while(true){
           boolean f1 = false;
           boolean f2 = false;
           
           while(i < s.length - 1 && matchCount < desiredCount){
               i++;
               f1 = true;
               String dummy = s[i];
               
               hmForS.put(dummy, hmForS.getOrDefault(dummy, 0)+1);
               
               if(hmForS.getOrDefault(dummy,0) <= hmForT.getOrDefault(dummy,0)){
                   matchCount++;
               }  
           }
           
           while(j < i && matchCount == desiredCount){
               String[] pAnswer = Arrays.copyOfRange(s, j+1, i+1);
               
               if(isSubsequence(pAnswer,t) && pAnswer.length < answer.length){
                   answer = pAnswer;
               }
               j++;
               f2 = true;
               
               String dummy = s[j];
               
               if(hmForS.get(dummy) == 1){
                   hmForS.remove(dummy);
               }else{
                   hmForS.put(dummy, hmForS.get(dummy)-1);
               }
               
               if(hmForS.getOrDefault(dummy,0) < hmForT.getOrDefault(dummy,0)){
                   matchCount--;
               }
           }
           
           if(f1 == false && f2 == false){
               break;
           }
       }
       
       System.out.println(Arrays.toString(answer));   
    }
    
    
    
    public static boolean isSubsequence(String[] pAnswer,String [] t){
        
        int i = 0; //its for out pAnswer subarray
        int j = 0; //its for our t subarray 
        
        while(i < pAnswer.length){
            if(pAnswer[i].equals(t[j])){
                i++;
                j++;
            }else{
                i++;
            }
        }
                
        return j == t.length;
    }
}
