/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class RandomNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int randomNum = (int)(Math.random()* 103);
        int num1 = 27;
        String result = (randomNum > num1) ? "The truth wins" : "The truth loses" ;
        System.out.println(randomNum);
        System.out.println(result);
   
        /*if (randomNum > num1){
            System.out.println("The truth wins");
        }
        else{
            System.out.println("The truth loses");
        }*/
        // TODO code application logic here
    }
}
