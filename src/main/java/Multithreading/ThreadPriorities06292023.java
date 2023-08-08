/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class ThreadPriorities06292023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MyThr1 obj1 = new MyThr1("Parth");
        MyThr1 obj2 = new MyThr1("Jigar");
        MyThr1 obj3 = new MyThr1("Vrajesh");
        MyThr1 obj4 = new MyThr1("Varsha");
        MyThr1 obj5 = new MyThr1("Pia");
        obj1.start();
        obj2.start();
        obj3.start();
        obj4.start();
        obj5.start();
        obj4.setPriority(Thread.MAX_PRIORITY);
        
   //     System.out.println("The id of the thead object is " + obj1.getId());
  //      System.out.println("The id of the thead object is " + obj2.getName());
        // TODO code application logic here
    }
}
class MyThr1 extends Thread{
    public MyThr1(String name){
        super(name);
    }
    public void run(){
        while(true){
           System.out.println("I am a thread " + this.getName());
       }
    }
    
}

