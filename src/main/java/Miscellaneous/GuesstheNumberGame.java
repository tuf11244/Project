/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author parth
 */
class Game{
    int computerGuess; int takeUserInput;int noOfGuesses;
    
    Game(){
    Random random = new Random();
    computerGuess = random.nextInt(100);
       // System.out.println(computerGuess);
    }
    void takeUserInput(){
        Scanner console = new Scanner(System.in);
        takeUserInput = console.nextInt();
        //System.out.println(takeUserInput);     
    }
    
 boolean isCorrectNumber(){
        if (computerGuess > takeUserInput){
            System.out.println("Player Input too low");
            //takeUserInput();
            noOfGuesses++;
            
        }
        else if(takeUserInput > computerGuess){
            System.out.println("Player Input too high");
           // takeUserInput();
            noOfGuesses++;
        }
        else if (takeUserInput == computerGuess){
            System.out.println("BangOn");
            return true;
        }
   return false;
}




    
}

public class GuesstheNumberGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Game myObject = new Game();
      // System.out.println(myObject.computerGuess);
    //   myObject.takeUserInput();
     //  myObject.isCorrectNumber();
       boolean b = false;
       while(!b){
           myObject.takeUserInput();
           b = myObject.isCorrectNumber();
           
       }
        System.out.println("You have guessed the correct number in "+ " " + myObject.noOfGuesses);
        // TODO code application logic here
    }
}

