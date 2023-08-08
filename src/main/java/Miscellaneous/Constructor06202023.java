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
class Constructor{
    int a; int b;
    Constructor(int x, int y){ //Parameterized Constructor
        a = x; b = y;
    }
    Constructor(int x, String b){ //Paramaterized Constructor with variables being printed in same constructor
        System.out.println(x);
        System.out.println(b);
    }
    void Display(){
        System.out.println(a);
        System.out.println(b);
    }
}
public class Constructor06202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Constructor myObj = new Constructor(25,100);
        Constructor myObject = new Constructor(25,"Parth");
        //myObj.a = 25;
        //Scanner console = new Scanner(System.in);
        //myObj.b = console.next();
        myObj.Display();
        
        // TODO code application logic here
    }
}
