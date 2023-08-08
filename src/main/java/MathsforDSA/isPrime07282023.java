/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class isPrime07282023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        for(int i = 1; i <= 40; i++){
            if(isPrime(i) == true){
                System.out.println(i);
            }
        }
        // TODO code application logic here
    }
    public static boolean isPrime(int number){
        if(number == 1){
            return false;
        }
        int c = 2;
        while(c*c < number){
            if(number % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}
