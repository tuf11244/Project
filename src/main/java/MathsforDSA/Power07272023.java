/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *
 * @author parth
 */
public class Power07272023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int base = 3; 
        int power = 6;
        
        int ans = 1; 
        while(power > 0){
            if((power & 1) == 1){
                ans = ans * base;
            }
            base = base * base;
            power = power >> 1;
        }
        System.out.println(ans);
        // TODO code application logic here
    }
}
