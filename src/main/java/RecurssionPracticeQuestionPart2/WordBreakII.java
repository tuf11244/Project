/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 12/06/2023
 *https://leetcode.com/problems/word-break-ii/
 * @author parth
 */
public class WordBreakII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       String S = "catsanddog";
       List<String> worddict = new ArrayList<>();
       worddict.add("cat");
       worddict.add("cats");
       worddict.add("and");
       worddict.add("sand");
       worddict.add("dog");
       
       List<String> answer = wordBreak(S,worddict);
        System.out.println(answer);
       
    }
   public static List<String> wordBreak(String s, List<String> wordDict) {
        // Memoization to avoid redundant computations
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }

    private static List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String remaining = s.substring(word.length());

                if (remaining.isEmpty()) {
                    result.add(word);
                } else {
                    List<String> sublist = wordBreakHelper(remaining, wordDict, memo);

                    for (String sub : sublist) {
                        result.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}
 
