/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ErrorsandExceptions;

/**
 *
 * @author parth
 */
public class SampleTryandCatch06302023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int a = 50;
        int b = 0;
       // int c = a/b;
        
       try {
            int c = a/b;
        System.out.println(c);
       }
       catch(Exception e){
           System.out.println("We have failed to divide");
           System.out.println(e);
       }
       finally{
           System.out.println("End of the program");
       }
        // TODO code application logic here
    }
}
