/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.*;
/**
 *Date: 02/19/2025
 * https://leetcode.com/problems/find-unique-binary-string/
 * @author parth
 */
public class FirstUniqueBinaryString {
    
    public String result;
    public String findDifferentBinaryString(String[] nums) {
        result = "";
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < nums.length;i++){
            set.add(nums[i]);
        }
        
        backtrack(set,new StringBuilder(),nums[0].length());
        return result;
    }

    public void backtrack(HashSet<String> set, StringBuilder temp, int n){
        if(temp.length() == n){
            if(set.contains(temp.toString()) == false){
                result = temp.toString();
            }
            return;
        }

        for(char ch : new char[]{'0','1'}){
            temp.append(ch);
            backtrack(set,temp,n);
            temp.deleteCharAt(temp.length()-1);
            if(result.length() > 0){
                return;
            }
        }
    }
}
