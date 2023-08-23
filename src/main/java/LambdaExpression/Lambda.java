/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LambdaExpression;
import java.util.ArrayList;
/**
 *
 * @author parth
 */
public class Lambda {

    /**Date: 08/22/2023
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(5);
        number.add(7);
        number.add(9);
        number.add(11);
        
        number.forEach((i) -> {System.out.println(i);});
        // TODO code application logic here
    }
}

