/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *Date: 11/22/2023
 * https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 * @author parth
 */
public class TowerofHanoi {

    public static void main(String args[]) {
        int N = 4; //Number of disks 
        //A = Source rod
        //B  = Helper rod
        //C = destination Rod
        towerofHanoi(N,'A','C','B');
    }
    public static void towerofHanoi(int N,char source, char destination, char helper){
        if(N==0){
            return;
        }
        towerofHanoi(N-1,source,helper,destination);
        System.out.println("Move disk " + N + " from rod " + source +  " to " + destination );
        towerofHanoi(N-1,helper,destination,source);
    }
}
