/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */

abstract class Base{
    
    Base(){
        System.out.println("I am a constructor for class Base");
    }
    
    public void sayHello(){
        System.out.println("Say Hello");
    }
    
    void greet(){
        System.out.println("Good Morning");
    }
}

class Derived extends Base{
    @Override
     void greet(){
        System.out.println("Suprabhat");
    }
}
public class Abstraction06232023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Derived myObj = new Derived();
        myObj.greet();
        myObj.sayHello();
        // TODO code application logic here
    }
}
