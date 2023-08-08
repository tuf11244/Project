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
public class Armstrong07092023 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        //System.out.println("Enter the number that you want to check: ");
       // int number = console.nextInt();
       // System.out.println(Armstrong(number));
        for(int i = 100; i < 1000; i++){
            if(Armstrong(i)){
                System.out.println(i);
            }
        }
       // Armstrong(number);
        
        
        // TODO code application logic here
    }
   public static boolean Armstrong(int number){ 
        int sum = 0;
        int original = number;
        while(number > 0){
            int remainder = number%10;
            int cube = remainder*remainder*remainder;
            sum = sum + cube;
            number = number/10;
        }
       if(sum == original){
           return true;
       }
       else{
           return false;
       }
}

}
