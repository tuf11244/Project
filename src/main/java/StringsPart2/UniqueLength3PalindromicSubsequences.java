/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 01/03/2025
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 * @author parth
 */
public class UniqueLength3PalindromicSubsequences {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int countPalindromicSubsequence(String s) {

        List<Character> list = new ArrayList<>();

       for(int i =0; i < s.length();i++){
          if(list.contains(s.charAt(i))){
            continue;
          }else{
              list.add(s.charAt(i));
          }
       }   
        int count = 0;
       for(int i = 0; i < list.size();i++){
           
           char ch = list.get(i);
           int firsOccurence = getFirstIndex(ch,s);
           int lastOccurence = getLastIndex(ch,s);
           HashSet<Character> set = new HashSet<>();
           
           if(lastOccurence - firsOccurence + 1 >= 3){
            boolean flag = true;
            for(int k = firsOccurence+1; k < lastOccurence;k++){

                if(s.charAt(k) == s.charAt(firsOccurence)){
                    if(flag){
                        count++;
                        flag = false;
                    }
                }else{
                   set.add(s.charAt(k));
                }
            }
               
           }

           count = count + set.size();

           
       }
       return count;
    }

    public int getFirstIndex(char ch, String s){

        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == ch){
                return i;
            }
        }

        return -1;
    }

    public int getLastIndex(char ch, String s){

        for(int i = s.length() - 1; i>= 0;i--){
            if(s.charAt(i) == ch){
                return i;
            }
        }

        return -1;
    }
    
}
