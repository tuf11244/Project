/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/defanging-an-ip-address/
 * Date: 12/15/2023
 * @author parth
 */
public class DefanginganIPAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < address.length();i++){
            char ch = address.charAt(i);
            if(ch == '.'){
                sb.append("[.]");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
