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
public class MultiDimensionalArrayLists07122023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        
        //intialization 
        for(int i = 0; i < 3; i++){
            list.add(new ArrayList<Integer>());
        }
        
        //add elements
        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 3; j++){
                list.get(i).add(console.nextInt());
            }
        }
        // TODO code application logic here
    }
}
