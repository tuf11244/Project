/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class ThreadMethods06292023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       MyNewThread object = new MyNewThread();
       MyNewThread2 obj = new MyNewThread2();
        obj.start();
        try{
            object.join();
        }
       
       catch(Exception e){
               System.out.println(e);
               }
       object.start();
        // TODO code application logic here
    }
}

class MyNewThread extends Thread{
    @Override
    public void run(){
        int i = 0;
        while(i<10){
        System.out.println("I am trying to understand Multi-threading");
          i++;
    }
       
}
}
class MyNewThread2 extends Thread{
    @Override
    public void run(){
        int i = 0;
        while(i<10){
        System.out.println("I am trying to understand Multi-threading in MyNewThread2 class");
          i++;
    }
       
}
}
