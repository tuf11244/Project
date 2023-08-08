/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class SieveofEratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int number = 40; 
        boolean[] primes = new boolean[number + 1];
        sieves(number,primes);
            // TODO code application logic here
    }
    public static void sieves(int number, boolean[] primes){
        for(int i = 2; i*i <= number; i++){
            if(!primes[i]){
                for(int j = i*2; j <= number; j = j+i){
                    primes[j] = true;
                }
            }
        }
        for(int i = 2; i <= number; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }           
        }
    }
    

