/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class DaughterAbstraction extends ParentAbstraction {

    /**
     * @param args the command line arguments
     */
    
   public DaughterAbstraction(int age){
        super(age);
    }
      @Override
    void career() {
        System.out.println("I am going to be a nurse");
        
    }

    @Override
    void partner() {
        System.out.println("I love Salman khan");
       
    }
    
}
