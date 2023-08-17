/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class Inheritance08162023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int y = 15;
        Child object = new Child();
        object.greeting();
        
        // TODO code application logic here
    }
}

class Child extends Inheritance08162023{
   int x = 10;
   int y;
   Child(){
       System.out.println(x);
   }
   public void greeting(){
       System.out.println("Good morning");
       System.out.println(y+x);
   }
      
}
