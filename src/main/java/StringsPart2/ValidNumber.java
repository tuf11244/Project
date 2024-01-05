/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/valid-number/
 * Date: 01/04/204
 * @author parth
 */
public class ValidNumber {

    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean isValidNumber(String s){
        //Case 1 when there are more than 1 signs 
        s = s.trim();
        int countSign = 0;   //Count variable for signs 
        
        //Flag variable for digits, dots and Alphabets (i.e. e or E);
        boolean digits = false;
        boolean dotSeen = false;
        boolean alphabetSeen = false;
        
        
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            
            //if the character is digits 
            if(Character.isDigit(ch)){
                //Update the digits flag to true 
                digits = true;
            }
            //if the character is + or -
            else if(ch == '+' || ch == '-'){
                
                //Plus and Minus sign cannnot be greater than 2 
                if(countSign == 2){
                        return false;
                }
                //if the sign is in Middle, previous to it should be e or E 
                //Valid Number = +6e-1
                //Invalid Number = 6+0;
                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
                //Last character in the String cannot be a + or -
                //Invalid Number = 6+ or 6-
                if(i == s.length()-1){
                    return false;
                }
                countSign++;
            }
            
            //if the characte is '.'
          else if(ch == '.'){
                //Case 1 : if the '.' is at the end of string and we haven't see any digits 
                // Invalid = .
                if(i == s.length()-1 && !digits){
                    return false;
                }
                //if we have seen an e or E or we already have seen a dot before 
                //Invalid = e. or .7.               
                if(alphabetSeen || dotSeen){
                    return false;
                }
                
                //Make the dotSeen = true 
                 dotSeen = true;
                
            }
            //if the character is either e or E 
            else if(ch == 'e' || ch == 'E'){
                //Invalid Number : ee (we have already seen a 'e' before)
                //Invalid Number : e45 (character is e but we havent seen any digits yet) 
                //Invalid Number :45e (e is at the last index) 
                if(alphabetSeen || !digits || i == s.length()-1){
                    return false;
                }
                
                //Make the alphabetSeen = true;
                alphabetSeen = true;
            }else{
                //Any character other than digits or e or sign or . is present we return false
                return false;
            }
            
        }
       
        return true;
    }
            
    
}
