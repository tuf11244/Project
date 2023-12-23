/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;

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
       // System.out.println(multiply("123","456"));
        System.out.println(add("146","9854"));
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
    
    //Add two Strings 
    public static String add(String num1, String num2){
        //Base Cases 
        //Case 1 : If both the Strings are 0
        if(num1.equals("0") && num2.equals("0")){
            return "0";
        }
        //Case 2 and 3 : if one of the nums is 0
        if(num1.equals("0") && !num2.equals("0")){
            return num2;
        }
        if(num2.equals("0") && !num1.equals("0")){
            return num1;
        }
        
        String longest = num1.length() > num2.length() ? num1 : num2;
        String shortest = num1.equals(longest) ? num2 : num1;
        
        ArrayList<Integer> list = new ArrayList<>();
        int k = longest.length() - shortest.length();
        
        while(k > 0){
            shortest = "0" + shortest;
            k--;
        }
        System.out.println(longest);
        System.out.println(shortest);
        
        int carry = 0;
       //At this point all the Strings are equal
        for(int i = shortest.length() -1; i >= 0; i--){
            int digit1 = longest.charAt(i) - '0';
            int digit2 = shortest.charAt(i) - '0';
            
            int sum = digit1 + digit2 + carry;
            carry = sum/10;
            
            if(carry > 0){
                list.add(sum%10);
            }else{
                list.add(sum);
            }
        }
        if(carry > 0){
            list.add(carry);
        }
        
        String answer = "";
        
        System.out.println(list);
        
        for(int j = list.size()-1; j >= 0; j--){
            answer = answer + list.get(j);
        }
        return answer;
        
        }
        
    }
    

