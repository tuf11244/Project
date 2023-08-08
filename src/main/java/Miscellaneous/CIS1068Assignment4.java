/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

import java.util.Scanner;
import java.util.*;
/**
 *
 * @author parth
 */
public class CIS1068Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       //Rules to be printed on Screen
        System.out.println("Greeetings : I welcome you the ancient Nordic game aka european version of Rock Paper Scissors just little bit complicated LOL");
        System.out.println("You have 5 options to chose from i.e. \"Godisus\" , \"Derflug\", \"Kullen\", \"Koppang\", \"Songesand\"  ");
        System.out.println("The Rules are printed below : ");
        System.out.println(" Rule no 1: Songesand beats Kullen and Godisus");
        System.out.println(" Rule no 2: Kullen beats Derflug and Koppang");
        System.out.println(" Rule no 3: Derflug beats Songesand and Godisus");
        System.out.println(" Rule no 4: Godisus beats Kullen and Koppang");
        System.out.println(" Rule no 5: Koppang beats Sogensand and Derflug");
        int rounds = 0;
        //User is Asked to play a round
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would like to play a round with Computer. Please enter Yes or No");
       String answer = keyboard.next();
       String playerMove = getPlayerMove();
       String computerMove = getComputerMove();
       
       while (!(answer.equalsIgnoreCase("No"))){
        if(answer.equalsIgnoreCase("Yes")){
            getPlayerMove();
            getComputerMove();
            //String playerMove = getPlayerMove();
          //  String computerMove = getComputerMove();
            decideWinner(playerMove,computerMove);
            rounds++;
            System.out.println("Would like to play a round with Computer. Please enter Yes or No");
            answer = keyboard.next();
          
        }
        else {
        System.out.println("Please enter a valid input ---its either Yes or No ");  
        answer = keyboard.nextLine();
    }
    
       
    }
        System.out.println(rounds);
        
    }
  public static String getPlayerMove() {
        Scanner keyboard1 = new Scanner(System.in);
        System.out.println("You have 5 options to chose from i.e. \"Godisus\" , \"Derflug\", \"Kullen\", \"Koppang\", \"Songesand\"  ");
        String playerMove = keyboard1.next();
            System.out.println("The Player Move is " + playerMove);
            return playerMove;
        // TODO code application logic here
    }
  
  public static String getComputerMove(){
      String computerMove = null; 
      Random random = new Random();
      int input = random.nextInt(5);
      if (input == 0){
          computerMove = "Godisus";
      }
      else if (input == 1){
          computerMove = "Derflug";
      }
      else if (input == 2){
          computerMove = "Kullen";
      }
      else if (input == 3){
          computerMove = "Koppang";
      }
      else if (input == 4){
          computerMove = "Songesand";
      }
      System.out.println("The Computer Move is " + computerMove);
      return computerMove;
}
  public static void decideWinner(String playerMove, String computerMove ){
     
      if(playerMove.equals(computerMove)){
      System.out.println("I am still figuring out code");
      
      }
      else if (playerMove.equals("Godisus")&& computerMove.equals("Kullen") || playerMove.equals("Godisus") && computerMove.equals("Koppang")){
        // if (computerMove.equals("Kullen") || computerMove.equals("Koppang")){
             System.out.println("The Player Wins - 1");
              
        }
      
      else if (playerMove.equals("Koppang")) {
             if(computerMove.equals("Songesand")|| computerMove.equals("Derflug")){
                 System.out.println("The player Wins - 2");
                
             }  
         }
      else if (playerMove.equals("Derflug")){
           if (computerMove.equals("Songesand")|| computerMove.equals("Godisus")){
               System.out.println("The player wins");
             //   rounds = rounds + 1;
           }
       
  }
      else if(playerMove.equals("Kullen")){
           if (computerMove.equals("Derflug") || computerMove.equals("Koppang")){
               System.out.println("The player wins");
              //  rounds = rounds + 1;
           }
       }
      
      else if(playerMove.equals("Songesand")){
           if (computerMove.equals("Kullen") || computerMove.equals("Godisus")){
               System.out.println("The player wins");
            //    rounds = rounds + 1;
           }
       }
      
      else if (computerMove.equals("Godisus")){
         if (playerMove.equals("Kullen") || playerMove.equals("Koppang")){
             System.out.println("The Computer Wins");
           //   rounds = rounds + 1;
         }
      }
      else if (computerMove.equals("Koppang")) {
             if(playerMove.equals("Songesand")|| playerMove.equals("Derflug")){
                 System.out.println("The Computer Wins");
               //   rounds = rounds + 1;
             }  
         }
      else if (computerMove.equals("Derflug")){
           if (playerMove.equals("Songesand")|| playerMove.equals("Godisus")){
               System.out.println("The Computer wins");
             //   rounds = rounds + 1;
           }
       
  }
      else if(computerMove.equals("Kullen")){
           if (playerMove.equals("Derflug") || playerMove.equals("Koppang")){
               System.out.println("The Computer wins");
            //    rounds = rounds + 1;
           }
       }
      
      else if(computerMove.equals("Songesand")){
           if (playerMove.equals("Kullen") || playerMove.equals("Godisus")){
               System.out.println("The Computer wins");
             //   rounds = rounds + 1;
           }
       }
      
      else {
           System.out.println("No body Wins");
          //  rounds = rounds + 1;
       }
      
     
      
      }
  
}