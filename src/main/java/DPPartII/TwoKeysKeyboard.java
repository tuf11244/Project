/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 08/06/2024
 * https://leetcode.com/problems/2-keys-keyboard/
 * @author parth
 */
public class TwoKeysKeyboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minSteps(int n) {
       int answer = 0;

       for(int i = 2; i * i <= n;){
                if(n % i == 0){
                    answer = answer + i;
                    n = n/i;
                }else{
                    i++;
                }
       }

       if(n!=1){
         answer = answer + n;
       }
        return answer;
    }
}
