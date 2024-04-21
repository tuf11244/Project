/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *Date: 04/20/2024
 * https://leetcode.com/problems/word-ladder/
 * @author parth
 */
public class WordLadder {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("lot");
        wordDict.add("log");
        wordDict.add("cog");
        
        int answer = ladderLength("hit","cog",wordDict);
        System.out.println(answer);
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordDict){
        
        HashSet<String> set = new HashSet<>();
        Queue<Ladder> queue = new LinkedList<>();
        queue.add(new Ladder(beginWord,1));
        
        //Add the words from out dictionary to the set 
        for(int i = 0; i < wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        while(!queue.isEmpty()){
             Ladder current = queue.poll();
             String word = current.word;
             int steps = current.level;
             
             //if the word equals our endWord 
             //we return steps
             if(word.equals(endWord)){
                 return steps;
             }
             
             for(int i = 0; i < word.length();i++){
                 for(char ch = 'a'; ch <= 'z';ch++){
                 char[] wordArray = word.toCharArray(); //Changing our word to character array for better manipulation purposes 
                 wordArray[i] = ch;
                 String replacedWord = new String(wordArray);
                 
                 //Now see if our replacedWord exists in our set 
                 if(set.contains(replacedWord)){
                     set.remove(replacedWord);
                     //Add the replaced word in our queue and increment the steps 
                     queue.add(new Ladder(replacedWord,steps+1));
                 }
                 
             }
             }
            
        }
              
        return 0;
    }
}

class Ladder{
    String word;
    int level;
    public Ladder(String word, int level){
        this.word = word;
        this.level = level;
    }
}
