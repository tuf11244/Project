/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class OddorEven07262023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(isOddorEven(67));
        // TODO code application logic here
    }
    public static boolean isOddorEven(int number){
        if((number & 1) == 1){
            return true;
        }
        return false;
    }
}
