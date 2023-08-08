/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class JoinMethod07052023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        JoinMethod t1 = new JoinMethod();
        JoinMethod t2 = new JoinMethod();
        JoinMethod t3 = new JoinMethod();
        JoinMethodOne obj = new JoinMethodOne();
        t1.setName("Parth Desai");
        t2.setName("Jigar Desai");
        t3.setName("Varsha Desai");
        obj.setName("Yield Method");
        
        t1.start();
        t3.start();
        t2.start();
        obj.start();
        
       
        // TODO code application logic here
    }
}

class JoinMethod extends Thread{
    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        for(int i = 0; i < 2; i++){
            System.out.println(name);
            Thread.yield();
        }
            
    }
}
class JoinMethodOne extends Thread{
     public void run(){
        String name = Thread.currentThread().getName();
        for(int i = 0; i < 2; i++){
            System.out.println(name);
        }
            
    }
}
