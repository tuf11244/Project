/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 12/09/2024 POTD
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/
 * @author parth
 */
public class FindtheLongestSubstringthatOccursThrice {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
   
    //Optimal Method
    public int maximumLength(String s){
        
        int[][] arr = new int[26][s.length()+1];
        
        char previous = s.charAt(0);
        int length = 0;
        for(int i = 0; i < s.length();i++){
            char current = s.charAt(i);
            
            //if the character is same
            if(current == previous){
                length = length + 1; //increase the length;
                arr[current - 'a'][length] =  arr[current - 'a'][length] + 1; //increase the frequency in our arr 
            }else{
                length = 1; //reset the length == 1 because difference character is found
                arr[current-'a'][length] = arr[current - 'a'][length] + 1;
                previous = current;
            }
        }
        
        int result = 0;
        for(int i = 0; i < 26; i++){ //i the number of row i.e. the number of alphabets
            int cumulativeSum = 0;
            for(int j = arr[0].length - 1; j >= 1; j--){ //j is the length
                cumulativeSum = cumulativeSum + arr[i][j];
                
                if(cumulativeSum >= 3){
                    result = Math.max(result,j);
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}



