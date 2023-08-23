/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ObjectCloning;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws CloneNotSupportedException {
        Human Parth = new Human("Parth",29);
        
        Human twin = (Human) Parth.clone();
     //   System.out.println(twin.getAge());
     //   System.out.println(Arrays.toString(twin.arr));
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(Parth.arr));
        
        
        // TODO code application logic here
    }
}
