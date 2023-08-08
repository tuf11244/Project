/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;

/**
 *
 * @author parth
 */

class Reverse{
    public String Reverse(String S){
        String rev = "";
       for(int i = 0; i < S.length(); i++){
          rev = rev + S.charAt(S.length()-1-i);
      }
    return rev;
    }

}
public class PalindromeStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the String that you would like to reverse");
        String text = console.nextLine();
        Reverse myObj = new Reverse();
        myObj.Reverse(text);
        System.out.println(myObj.Reverse(text));
        if (text.equalsIgnoreCase(myObj.Reverse(text))){
            System.out.println("Both the strings are palindrome");
        }
        else{
            System.out.println("The strings are not palindrome");
        }
        
        // TODO code application logic here
    }
}

