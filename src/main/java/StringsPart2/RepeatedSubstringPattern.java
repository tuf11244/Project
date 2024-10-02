/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 10/02/2024
 * https://leetcode.com/problems/repeated-substring-pattern
 * @author parth
 */
public class RepeatedSubstringPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static boolean repeatedSubstringPattern(String s){
        
        for(int i = s.length()/2; i >= 1; i--){
            
            int times = s.length()/i;
            String pattern = s.substring(0,i);
            StringBuilder sb = new StringBuilder();
            if(s.length() % i == 0){
                
                while(times > 0){
                    sb.append(pattern);
                    times--;
                }
                
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
