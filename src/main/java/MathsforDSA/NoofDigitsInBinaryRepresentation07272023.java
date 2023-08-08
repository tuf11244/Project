/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class NoofDigitsInBinaryRepresentation07272023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int number = 3457;
        int base = 2;
        int answer = (int)(Math.log(number)/Math.log(base)) + 1;
        System.out.println(Integer.toBinaryString(number));
        System.out.println(answer);
        // TODO code application logic here
    }
}
