/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */

class MyThread extends Thread{
    @Override
    public void run(){
  //     while(true){
        System.out.println("My Thread is running");
  //  }
    
}
}

class MyThread1 extends Thread{
    public void run(){
     //   while(true){
        System.out.println("My Thread1 is running");
    //}
}
}
public class ExtendSyntax06272023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MyThread obj = new MyThread();
        MyThread1 object = new MyThread1();
        obj.start();
        object.start();
        System.out.println(obj.getName() + " " + obj.getState());
        System.out.println(object.getName() + " " + object.getState());
        
        // TODO code application logic here
    }
}
