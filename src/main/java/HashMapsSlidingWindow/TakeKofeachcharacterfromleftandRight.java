/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 11/20/2024
 * https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
 * @author parth
 */
public class TakeKofeachcharacterfromleftandRight {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int takeWindow(String s, int k){
        int countA = 0;
        int countB = 0;
        int countC = 0;
        
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == 'a'){
                countA++;
            }else if(s.charAt(i) == 'b'){
                countB++;
            }else{
                countC++;
            }
        }
        
        if(countA < k || countB < k || countC < k){
            return -1;
        }
        
        int i = 0;
        int j = 0;
        int minToBeDeleted = s.length();
        while(i < s.length()){
             if(s.charAt(i) == 'a'){
                countA--;
            }else if(s.charAt(i) == 'b'){
                countB--;
            }else{
                countC--;
            }
             
             while(j <= i &&(countA < k || countB < k || countC < k)){
                 if(s.charAt(j) == 'a'){
                countA++;
                    }else if(s.charAt(j) == 'b'){
                countB++;
                    }else{
                countC++;
                }
                 
                 j++;
             }
             
             minToBeDeleted = Math.min(minToBeDeleted,i-j+1);        
             
        }
        
        return s.length() - minToBeDeleted;
    }
}
