/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 *  https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
package Recurssion;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author parth
 */
public class PhoneNumberCombination0808023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //phoneNumberCombination("","23");
        System.out.println(phoneNumberCombinationList("","2825"));
        // TODO code application logic here
    }
    
    public static void phoneNumberCombination(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0'; // Will convert String "2" to int 2
        for(int i = (digit-1) * 3 ; i < digit*3; i++){
            char ch = (char)('a' + i);
            phoneNumberCombination(processed + ch, unprocessed.substring(1));
        }
        
        
    }
    
    public static ArrayList<String> phoneNumberCombinationList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();
        int digit = unprocessed.charAt(0) - '0';
        for(int i = (digit-1)*3; i < digit*3;i++){
            char ch = (char)('a' + i);
          answer.addAll(phoneNumberCombinationList(processed + ch, unprocessed.substring(1)));
        }
        
        return answer;
        
    }
}
