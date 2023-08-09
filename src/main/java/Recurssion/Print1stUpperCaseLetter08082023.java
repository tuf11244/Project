/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class Print1stUpperCaseLetter08082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        upperCaseLetter("My name is Parth Desai ",0);
        // TODO code application logic here
    }
    
    public static void upperCaseLetter(String S, int start){
        if(S.isEmpty()){
            System.out.println(" ");
        }
        while(start < S.length()){
            if(Character.isUpperCase(S.charAt(start))){
                System.out.println(S.charAt(start));
            }
            upperCaseLetter(S,start+1);
        }
    }
}
