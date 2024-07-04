/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/03/2024
 * https://www.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
 * @author parth
 */
public class CountSubsequencesoftheFormABC {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int function(String s){
        int a = 0;
        int ab = 0;
        int abc = 0;
        
        for(int i =0; i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                a = 2 * a + 1;
            }else if(ch == 'b'){
                ab = 2 * ab + a;
            }else if(ch == 'c'){
                abc = 2 * abc + ab;
            }
        }
        
        long MOD = 1000000000 + 7;
        
        return (int) (abc % MOD);
    }
}
