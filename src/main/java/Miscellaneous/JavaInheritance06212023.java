/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class JavaInheritance06212023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Dog myObject = new Dog(); //Creating a object for Dog Class
       myObject.name = "Pug";
        myObject.barkSound();
        myObject.nameAnimal();
        
      myObject.PrintInt();
        
        Animal myObj = new Animal(); //Creating new object for Animal Class
       
       
        // TODO code application logic here
    }
}

class Animal{
    String name;
   
    public void barkSound(){
        System.out.println();
    }
    
    public void nameAnimal(){
        System.out.println(name);
        
}
   
}

class Dog extends Animal{
    int y;
    Dog(){
        y = 10;
    }
     public void barkSound(){
         System.out.println("Woof--woof");
     }
     public void nameAnimal(){
         System.out.println(name);
     }
     public void PrintInt(){
         System.out.println(y);
     }
}
