/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 07/14/2024
 *https://leetcode.com/problems/number-of-atoms/
 * @author parth
 */
public class NumberofAtoms {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
     public static String countOfAtoms(String formula) {
        
        int n = formula.length();
        
        Stack<HashMap<String,Integer>> st = new Stack<>();
        
        st.push(new HashMap<>());
        
        int i = 0;
        
        while(i < n){
            // Beginning of the formula
            if(formula.charAt(i) == '('){
                st.push(new HashMap<>());
                i++;
            }
            // Trigger point ..since it closed bracket the formula until that moment would be at the top of our stack
            else if(formula.charAt(i) == ')'){
                HashMap<String,Integer> hm = st.pop();
                i++;
                
                int multiplier = 0;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    multiplier = multiplier * 10 + formula.charAt(i) - '0';
                    i++;
                }
                
                if(multiplier == 0){
                    multiplier = 1; // Assign 1 value as multiplying any element with 0 would give us an issue 
                }
                
                // Multiply the current value for all our chemical elements from our hashmap with the multiplier
                for(String s : hm.keySet()){
                    int valency = hm.get(s);
                    hm.put(s, valency * multiplier);
                }
                
                // Merging our current hashmap in our topmost hashmap
                for(String s : hm.keySet()){
                    if(st.peek().containsKey(s)){
                        int oldvalue = st.peek().get(s);
                        int newvalue = hm.get(s);
                        st.peek().put(s, newvalue + oldvalue);
                    }else{
                        st.peek().put(s, hm.get(s));
                    }
                }
                
            } else {
                // We have a character so we need to build our element name 
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i));
                i++;
                while(i < n && Character.isLowerCase(formula.charAt(i))){
                    element.append(formula.charAt(i));
                    i++;
                }
                
                // Now we have to get the valency for the above current element 
                int valency = 0;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    valency = valency * 10 + formula.charAt(i) - '0';
                    i++;
                }
                
                if(valency == 0){
                    valency = 1; // so that we don't have any mathematical issue 
                }
                // Now we merge our element created on the topmost hashmap in our stack
                if(st.peek().containsKey(element.toString())){
                    st.peek().put(element.toString(), st.peek().get(element.toString()) + valency);
                } else {
                    st.peek().put(element.toString(), valency);
                }
            }
        }
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(st.peek());
        StringBuilder result = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            result.append(key);
            int count = sortedMap.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}
