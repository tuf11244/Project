/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class RemoveDuplicatesinString08132023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(removeDuplicates("abbaxy"));
        // TODO code application logic here
    }
    public static String removeDuplicates(String S){
        if(S.length()<= 1){
            return S;
        }
        if(S.charAt(0) == S.charAt(1)){
            return removeDuplicates(S.substring(1));
        }
        return S.charAt(0) + removeDuplicates(S.substring(1));
    }
}
