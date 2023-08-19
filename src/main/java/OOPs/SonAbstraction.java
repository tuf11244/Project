/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class SonAbstraction  extends ParentAbstraction {
    
    public SonAbstraction(int age){
        super(age);
    }

    @Override
    void career() {
        System.out.println("I am going be a doctor");
        
    }

    @Override
    void partner() {
        System.out.println("I love deepika padukone" );
       
    }

   
    /**
     * @param args the command line arguments
     */
    
}
