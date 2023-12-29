/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.Arrays;

/**
 *https://leetcode.com/problems/camelcase-matching/
 * Date: 12/29/2023
 * @author parth
 */
public class CamelCaseMatching {

    /**
     * Logic and Algorithm 
     * We will have an index to track the pattern and an index to track the query String 
     *  Case 1 : if the character and query index is uppercase 
     *      - if the character in query index don't match with the character in pattern index return false 
     *      - else increase both the indexes
     * 
     *  Case 2 : if the character in query index is lowerCase and character in pattern index is also lowerCase 
     *      - if they match increase both the indexes 
     *      - else just increase the query index 
     * 
     * Case 3 : if the character in patter is Uppercase and character in query is LowerCase 
     *         increment the query Index for the next Comparison 
     * 
     * If pattern is not exhausted then obviously the String doesn't follow the pattern so return false
     * If the query is not exhausted then check the remaining character are lowerCase otherwise return false 
     * 
     * If all the above checks pass then return true
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        System.out.println(Arrays.toString(camelMatch(queries,"FB")));
    }
    public static boolean[] camelMatch(String[] queries, String pattern){
        boolean[] answer = new boolean[queries.length];
        for(int i = 0; i < queries.length;i++){
            answer[i] = isMatch(queries[i],pattern);
        }
        return answer;
    }
    public static boolean isMatch(String query, String pattern){
        int queryIndex = 0;
        int patternIndex = 0;
        
        while(queryIndex < query.length() && patternIndex < pattern.length()){
            char ch = query.charAt(queryIndex);
            
            //Case 1 : where character is uppercase
            if(Character.isUpperCase(ch)){
                
                //if it is same character in patter or not 
                if(ch != pattern.charAt(patternIndex)){
                    return false;
                }else{
                    queryIndex++;
                    patternIndex++;
                }
            }
            
            //Case 2 : where character is lowerCase in both query and pattern
            else if(Character.isLowerCase(ch) && Character.isLowerCase(pattern.charAt(patternIndex))){
                
                //if the characters are same in both pattern and query 
                if(ch != pattern.charAt(patternIndex)){
                    queryIndex++;
                    
                }else{
                    patternIndex++;
                    queryIndex++;
                }
            }
            
            //Case 3 : where character in pattern is UpperCase and character in query is LowerCase
            else if(Character.isUpperCase(pattern.charAt(patternIndex)) && Character.isLowerCase(ch)){
                queryIndex++;
            }
        }
        
        //if pattern is Still remaining 
        if(patternIndex < pattern.length()){
            return false;
        }
        
        while(queryIndex < query.length()){
            if(Character.isUpperCase(query.charAt(queryIndex))){
                return false;
            }else{
                queryIndex++;
            }
        }
        
        
        return true;
    }
}
