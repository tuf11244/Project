/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.*;

/**
 *
 * @author parth
 */
public class BasicArrayListsPart207122023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<String> name = new ArrayList<String>(5);
        Scanner console = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            System.out.println("Please enter the String to add in Array List");
            name.add(console.next());
        }
        System.out.println(name);  //Prints out the ArrayList
        System.out.println(name.get(0));
        // TODO code application logic here
    }
}
