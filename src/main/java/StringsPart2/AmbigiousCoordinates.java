/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.List;
import java.util.ArrayList;
/**
 *Date: 01/01/2024
 * https://leetcode.com/problems/ambiguous-coordinates/
 * @author parth
 */
public class AmbigiousCoordinates {

    
    public static void main(String args[]) {
           System.out.println("Hello World");
           List<String> answer = ambiguousCoordinates("(0123)");
           System.out.print(answer + " ");
        
    }
     public static List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        //We need to take the string from 1st index till 2nd last index 
        //For example s = (123); we don't need to take the brackets 
        s = s.substring(1,s.length()-1);
        
        //Breaking the String in x,y coordinates 
        //example (0123) --> (0,123)
        for(int i = 1; i < s.length();i++){
            helper(s.substring(0,i),s.substring(i),result);
        }
        return result;
    }
    public static void helper(String x, String y, List<String> result){
        
        //putDot Function puts dot in String x and String y
        List<String> dotx = putDot(x);
        List<String> doty = putDot(y);
        
        //Now we have to make combination of all the String that are valid in dotx and doty
        for(String dx : dotx){
            if(isValid(dx)){
                for(String dy: doty){
                    if(isValid(dy)){
                        result.add("("+dx+", "+dy+")"); //We need the String in format (1, 23);
                    }
                }
            }
        }
    }
    
    private static List<String> putDot(String s){
        List<String> res = new ArrayList<>();
        res.add(s); //To add the whole String like "123";
        for(int i = 1; i < s.length();i++){
            res.add(s.substring(0,i)+"."+s.substring(i));
        }
        return res;
    }
    private static boolean isValid(String s){
        
        /*Case 1: If Number doesn't have dot, it should either be "0" or cannot have leading zeroes 
        Case 2: If a Number has a dot, the first half of it should either be "0" or cannot have leading zeroes
        Case 3: If the number has dot, the second half should not have trailing zeroes;*/
        
        if(s.contains(".")){
            String[] part = s.split("\\.");
            if(!part[0].equals("0") && part[0].startsWith("0")){
                return false;
            }else{
                return !part[1].endsWith("0");
            }
            
        }else{
            if(s.equals("0")){
                return true;
            }else{
                return !s.startsWith("0");
            }
        }
    }
}
