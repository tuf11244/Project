/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

import java.util.Scanner;

/**
 *
 * @author parth
 */
public class Poweroftwo07272023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        boolean answer = (number & (number - 1)) == 0;
        System.out.println(answer);
        // TODO code application logic here
    }
}
