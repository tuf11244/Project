/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class ConstructorsinThreads06292023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MyThr obj = new MyThr("Parth");
        obj.start();
        System.out.println("The id of the thead object is " + obj.getId());
        System.out.println("The id of the thead object is " + obj.getName());
        
        // TODO code application logic here
    }
}

class MyThr extends Thread{
    public MyThr(String name){
        super(name);
    }
    public void run(){
     //   while(true){
     //       System.out.println("I am a thread");
      //  }
    }
    
}