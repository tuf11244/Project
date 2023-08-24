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
public class AreaofCuboid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*Scanner keyboard1 = new Scanner(System.in);
        System.out.println("Please enter the length of the cuboid");
        int length = keyboard1.nextInt();
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("Please enter the breadth of the cuboid");
        int breadth = keyboard2.nextInt();
        Scanner keyboard3 = new Scanner(System.in);
        System.out.println("Please enter the height of the cuboid");
        int height = keyboard3.nextInt();
        int volume = length * breadth * height;
        System.out.println(volume);*/
        
        System.out.println("Enter the String that you want to reverse");
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();
        String reverse = reverse(text);
        System.out.println("The original string is "+ " " + text);
        System.out.println("The reverse string is " + " " + reverse);
        
             
        
        // TODO code application logic here
    }
    

 public static String Reverse(String S){
      String rev = "";
      for(int i = 0; i < S.length(); i++){
          rev = rev + S.charAt(S.length()-1-i);
      }
      return rev;
  }
 
 public static String reverse(String S){
     String rev = "";
     for(int i = S.length()-1; i>= 0;i--){
         rev = rev + S.charAt(i);
     }
     return rev;
 }
}
