/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public abstract class ParentAbstraction {

    /**
     * @param args the command line arguments
     */
   int age;
   
   public ParentAbstraction(int age){
       this.age = age;
     //  System.out.println(age);
   }
   
   static void hello(){
       System.out.println("Hey I am static method in ParentAbstraction Class");
   }
   abstract void career();
   abstract void partner();
}
