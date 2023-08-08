/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class Factors07292023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //factors(20);
        optimizedFactors(36);
        // TODO code application logic here
    }
    public static void factors(int number){
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                System.out.print(i + " ");
            }
        }
    }
    public static void optimizedFactors(int number){
        for(int i = 1; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                System.out.println(i + " " + (number/i));
            }
        }
    }
}
