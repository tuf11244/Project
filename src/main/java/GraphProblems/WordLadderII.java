/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;
/**
 *Date : 05/30/2024
 * https://leetcode.com/problems/word-ladder-ii/
 * @author parth
 */
public class WordLadderII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
         
        //Put the word of wordList in our set
        HashSet<String> set = new HashSet<>(wordList);
        
        //This time our queue will be made up of ArrayList<>
        Queue<List<String>> queue = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord); //push the beginWord in temp list
        queue.add(temp); //add temp to our current queue
        
        List<String>  usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        
        int level = 0;
        List<List<String>> answer = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            List<String> rem = queue.poll();
            
            //erase all the words in the previous level to transform
            if(rem.size() > level){
                level++;
                for(String s : usedOnLevel){
                    set.remove(s);
                }
            }
            
            
            String word = rem.get(rem.size() - 1); //we get the last word we need to transform 
            
            if(word.equals(endWord)){
                //First sequency where we reached end
                if(answer.size() == 0){
                    answer.add(rem);
                }
                //Since we need all the sequences 
                else if(answer.get(0).size() == rem.size()){
                    answer.add(rem);
                }
            }
            
            for(int i = 0; i < word.length();i++){
                for(char ch = 'a'; ch <= 'z';ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);
                    
                    if(set.contains(replacedWord)){
                        
                        rem.add(replacedWord); //add it to our current list
                        
                        List<String> list = new ArrayList<>(rem); //copy our current list to our list
                        queue.add(list); //add the list to the queue
                        
                        usedOnLevel.add(replacedWord); //add the word to our usedOnLevel list
                        rem.remove(rem.size()-1); //backtrack --i.e. remove the word that was added
                        
                    }
                    
                }
            }
        }
        return answer;
        
    }
}

class Soln{
    
     HashMap<String,Integer> hm; //to store the transformation String to the level it was transformed
     String b;
     List<List<String>> answer;
     public  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
         
         HashSet<String> set = new HashSet<>(wordList); //copy the wordList word in our set
         
         Queue<String> queue  = new LinkedList<>();
         b = beginWord;
         queue.add(beginWord);
         
         hm = new HashMap<>();
         hm.put(beginWord,1);
         
         int size = beginWord.length();
         set.remove(beginWord);
         
         answer = new ArrayList<>();
         
         while(!queue.isEmpty()){
             String word = queue.poll();
             int steps = hm.get(word);
             
             if(word.equals(endWord)){
                 break;
             }
             
             for(int i = 0; i < word.length();i++){
                 for(char ch = 'a'; ch <= 'z';ch++){
                    char[] wordArray = word.toCharArray(); //Changing our word to character array for better manipulation purposes 
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);
                    
                    if(set.contains(replacedWord)){
                        // push the word along with its level
                        // in the map data structure.
                        hm.put(replacedWord,steps+1);
                        
                        queue.add(replacedWord);
                        set.remove(replacedWord);
                    }
                 }
             }
         }
         
         if(hm.containsKey(endWord)){
             List<String> seq = new ArrayList<>();
             seq.add(endWord);
             dfs(endWord,seq); //we are doing dfs from the endWord 
         }
         
         
         return answer;
     }
     
     public void dfs(String word,List<String> seq){
         
         // Function for implementing backtracking using the created map
        // in reverse order to find the transformation sequence in less time.

        // Base condition :
        // If word equals beginWord, we’ve found one of the sequences
        // simply reverse the sequence and return. 
        
        if(word.equals(b)){
            // Since java works with reference, create
            // a duplicate and store the reverse of it
            List < String > dup = new ArrayList < > (seq);
            Collections.reverse(dup);
            answer.add(dup);
            return;
        }
        
        int steps = hm.get(word);
        for(int i = 0; i < word.length();i++){
                 for(char ch = 'a'; ch <= 'z';ch++){
                    char[] wordArray = word.toCharArray(); //Changing our word to character array for better manipulation purposes 
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);
                    
                    if(hm.containsKey(replacedWord) && hm.get(replacedWord)+1 == steps){
                        
                        seq.add(replacedWord);
                        
                        dfs(replacedWord,seq);
                        
                     // pop the current word from the back of the queue
                    // to traverse other possibilities.
                        seq.remove(seq.size()-1); //backtrack;
                    }
                    
     }
        }
     }
}
