/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Generics;

/**
 *
 * @author parth
 */

 class Printer <T> {

    T thingtoPrint;
    public Printer(T thingtoPrint){
        this.thingtoPrint = thingtoPrint;
    }
    
    public void print(){
        System.out.println(thingtoPrint);
    }

}
public class GenericsBasics08212023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Printer<String> print = new Printer<>("Parth");
        print.print();
        // TODO code application logic here
    }
}
