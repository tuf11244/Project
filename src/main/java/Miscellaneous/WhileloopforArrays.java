/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class WhileloopforArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] students = {"Harry", "Parth", "Jigar", "Nainesh", "Mark"};
        int i = 0;
        while (students.length > i){
            //System.out.print("This is how you print the elements in Array using while loop");
            System.out.println(students[i]);
            i++;
        }
        
        // TODO code application logic here
    }
}
