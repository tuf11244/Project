/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.*;
/**
 *
 * @author parth
 */
public class dummy {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        List<String> l1 = new ArrayList<>();
        l1.add("Parth");
        l1.add("Bobby");
        l1.add("John");
        
        List<String> l2 = new ArrayList<>();
        l2.add("Bobby");
        l2.add("Parth");
        l2.add("John");
        
        System.out.println(l1.equals(l2));
    }
}
