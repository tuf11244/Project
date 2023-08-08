/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class Synchronization07052023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Bus obj = new Bus(1);
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);
        t1.setName("Parth");
        t2.setName("Jigar");
        t3.setName("Hriday");
        t1.start();
        t2.start();
        t3.start();
        
       
        // TODO code application logic here
    }
}
class Bus implements Runnable{
    int avalaibleSeats = 2;
    int passenger;
    Bus(int passenger){ 
        this.passenger = passenger;
        
    }
    @Override
    public synchronized void run(){
        if(avalaibleSeats >= passenger){
            String name = Thread.currentThread().getName();
            System.out.println(name + " reserved seat");   
            avalaibleSeats = avalaibleSeats - passenger;
        }
        else{
            System.out.println("Sorry seat not available");
        }
}
}