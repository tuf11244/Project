/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 *Date: 09/09/2024
 *https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring
 * @author parth
 */
public class LongestKUniqueCharactersSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //System.out.println(longestKUniqueSubstring("joizyglhbetjlvglzvvktxqsslufceppzpgogrifbeyuiblmgcqtkhhbimxigczvbtvrtsperlhunsyywgnttbwjgunjwjtqzqvrdumddtzaffcmjlakmfappoqqkvmfnevaabqxtzslodalgvtwvbsknohmjcumrrqktskvidbizexkprdonsjkbcoeplcafdalmvfaswnjkiqcwowhykczbdkankmkrrwsmcomaubfelnljztemcbmmoptndjodpqnikglvraezkvfxcphvgdgkouirhidbdtesjogrilbxhgtqprexyxptbqdxnwsuddzoiuumlbbgmhuzbgaslssvtexzlipsqfrfvxbkxmazocqvtaguvxmoqvhkfklucswkizrpatpakmuswqdsmxtnuujewtwtrnofowrgmxegwkxokotqhfodaegkmopjpdvpxzjrunwfqeldjhajnjzaargszgxakniopptsoakustvpbtocrovfceofpbeddqeidyvosbwbspesilldkdvocbfrbzthbgsnzaabjfbeanwoicritttjvkromyiodiazfgzktgkeqjmojamqrdusaibheiivnvmokacqudrcairqtisixcjxjsdubgusrcpleludvkjiabbeukbeadqruccuhwcrgosagtuyjfhnaniapxkrqdbmdsbxrzriyszsoguditxxpvdopzktljyrdzxunnybfzfqoezhizbustnwlpqypfqtgxapvwrcybnsjfrsdhyafsdglucczqtoazaycxybnlratmdqphtdwqsddhkrhvbgsytp",10));
          System.out.println(countofSubstrings("aba",2));
    }
    public static int longestKUniqueSubstring(String s, int k){
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        //Get all the unique Characters
        for(int i = 0; i < s.length();i++){
            set.add(s.charAt(i));
        }
        
        if(k > set.size()){
            return -1;
        }
        
        int i = -1;
        int j = -1;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            //Acquire
            while(i < s.length()-1){
                
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch,0)+1);
                
                if(hm.size() < k){
                    continue;
                }else if(hm.size() == k){
                    int length = i - j;
                    if(length > maxLength){
                    maxLength = length;
                } 
                }
                else{
                        break;
                    }
            }
            // Release
            while(j < i){
                     
                f2 = true;
                j++;
                char ch = s.charAt(j);
                if(hm.get(ch) == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch, hm.get(ch)-1);
                }
                //that means the hm.size() is alreay valid;
                if(hm.size() == k){
                    break;
                }               
            }
            if(f1 == false && f2 == false){
                break;
            }       
    }
        return maxLength;
    }  
}
