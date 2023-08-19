/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class MainAbstraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SonAbstraction son = new SonAbstraction(30);
        DaughterAbstraction daughter = new DaughterAbstraction(19);
        
        son.career();
        daughter.career();
        
        ParentAbstraction.hello();
        SonAbstraction.hello();
        
    //    ParentAbstraction father = new ParentAbstraction(60);
        
        // TODO code application logic here
    }
}
