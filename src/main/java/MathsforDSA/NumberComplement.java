/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 08/21/2024
 * https://leetcode.com/problems/number-complement/
 * @author parth
 */
public class NumberComplement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        findComplement(5);
    }
    
    public static void findComplement(int  num){
        String ans = Integer.toBinaryString(num);
        String reverse = function(ans);
        System.out.println(reverse);
        int answer = Integer.parseInt(reverse,2);
        System.out.println(answer);
        System.out.println(ans);
    }
    
    public static String function(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                sb.append('0');
            }else{
                sb.append('1');
            }
        }
        return sb.toString();
    }
}
