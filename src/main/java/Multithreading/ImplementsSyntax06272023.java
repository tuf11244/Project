/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
class Mythread2 implements Runnable{
    @Override
    public void run(){
        System.out.println("My Thread running");
    }
   
}


public class ImplementsSyntax06272023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello");
        Mythread2 obj = new Mythread2();
        Thread t1 = new Thread(obj);
        t1.start();
        t1.toString();
        System.out.println(t1.getState());
        System.out.println(t1);
       // t1.getState();
        // TODO code application logic here
    }
}
