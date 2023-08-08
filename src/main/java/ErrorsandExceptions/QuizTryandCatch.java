/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ErrorsandExceptions;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class QuizTryandCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      //  int[] marks = new int[10];
     int[] marks = {20,30,40,45,55,66,68,62,81,99};
    // int i = 0;
       Scanner console = new Scanner(System.in);
        boolean flag = true;
        int rounds = 0;
        while(flag){
            System.out.println("Please enter the index of the array that you would like to see the value of");
          int  index = console.nextInt();
           
                try{
                    System.out.println(marks[index]);
                    flag = false;
                    rounds++;
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("The is not a valid index");
                    System.out.println(e);
                    rounds++;
                }
           
        }
        System.out.println("You got the right index after this many rounds" + rounds);           
        }       
        }

    

