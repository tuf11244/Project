/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/multiply-strings/
 * Date: 12/20/2023
 * @author parth
 */
public class MultiplyStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(multiply("123","456"));
    }
    public static String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        
        int[] arr= new int[num1.length()+num2.length()];
        
        
        int j = num2.length() -1;
        int powerFactor = 0;
        while(j >= 0){
            int jvalue = num2.charAt(j) - '0';
            j--;
            
            int i = num1.length() - 1;
            int k = arr.length - 1 - powerFactor;
            int carry = 0;
            while(i >= 0 || carry != 0){
                int ivalue;
                if(i >= 0){
                    ivalue = num1.charAt(i) - '0';             
                }else{
                    ivalue = 0;
                }
                
                int product = ivalue  * jvalue + carry + arr[k];
                arr[k] = product % 10;
                carry = product /10;
                k--;
                i--;
            }
            powerFactor++;
        }
        
       StringBuilder answer = new StringBuilder();
        boolean flag = false;

        for (int value : arr) {
            if (value == 0 && !flag) {
                continue;
            } else {
                flag = true;
                answer.append(value);
            }
        }

        return answer.toString();
    }
}
