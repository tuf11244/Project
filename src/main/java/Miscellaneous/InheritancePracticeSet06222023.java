/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;
import java.util.Scanner;

/**
 *
 * @author parth
 */
class Circle{
   int radius;
   Circle(){
       System.out.println("Please enter the radius");
       Scanner console = new Scanner(System.in);
       radius = console.nextInt();
   }
   double area(){
       return 3.14*radius*radius;
   }
}

class Rectangle1 extends Circle{
    int height;
    Rectangle1(){
        System.out.println("Please enter the height");
        Scanner console = new Scanner(System.in);
        height = console.nextInt();
    }
    @Override
    double area(){
        return 3.14*radius*radius*height;
    }
}
 
public class InheritancePracticeSet06222023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Circle myObj = new Rectangle1();
        double area = myObj.area();
        System.out.println(area);
        // TODO code application logic here
    }
}
