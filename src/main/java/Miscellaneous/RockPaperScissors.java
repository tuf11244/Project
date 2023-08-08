/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.*;

/**
 *
 * @author parth
 */
public class RockPaperScissors {
    
    public static final String ROCK = "ROCK";
    public static final String SCISSORS = "SCISSORS";
    public static final String PAPER = "PAPER";

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Enter the any of the following 3 choices ");
        System.out.println("ROCK");
        System.out.println("PAPER");
        System.out.println("SCISSORS");
        System.out.println(" ");
        
        String playerMove = getPlayerMove();
        String computerMove = getComputerMove();
        // TODO code application logic here
        if(playerMove.equals(computerMove))
            System.out.println("Game is Tie");
        else if(playerMove.equals(RockPaperScissors.ROCK)){
            if (computerMove.equals(RockPaperScissors.PAPER)){
                System.out.println("Computer Wins");
            }
            else {
                System.out.println("Player Wins");
            }
        }
        else if (playerMove.equals(RockPaperScissors.PAPER)){
            if (computerMove.equals(RockPaperScissors.SCISSORS)){
                System.out.println("Computer Wins ");
            }
            else {
                System.out.println("Player Wins");
            }
        }
        else if (playerMove.equals(RockPaperScissors.SCISSORS)) {
            if (computerMove.equals(RockPaperScissors.PAPER)){
                System.out.println("Player Wins");
                
            }
            
            else {
                System.out.println("Computer Wins ");
            }
        }
        
        System.out.println("Do you want to continue Yes or No ");
        Scanner console = new Scanner (System.in);
        String round2 = console.nextLine();
        
        if(round2.equalsIgnoreCase("Yes")){
            getPlayerMove();
            getComputerMove();
        }
        else {
            System.out.println("Thank you so much for playing");
        }
    
    }
    
        public static String getComputerMove()
    {
        String computerMove;
        Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1)
            computerMove = RockPaperScissors.ROCK;
        else if(input == 2)
            computerMove = RockPaperScissors.PAPER;
        else
            computerMove = RockPaperScissors.SCISSORS;
            
        System.out.println("Computer move is: " + computerMove);
        System.out.println();
        return  computerMove;    
    }   
        
         public static String getPlayerMove()
    {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String playermove = input.toUpperCase();
        System.out.println("Player move is: "+ playermove);
        return playermove;
    }  
         
         
    
}

   
    