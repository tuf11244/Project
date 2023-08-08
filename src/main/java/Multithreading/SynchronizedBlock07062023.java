/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class SynchronizedBlock07062023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        OurThread t1 = new OurThread();
        t1.start();
        // TODO code application logic here
    }
}

class Message{
    public void show(String name){
        
        synchronized(this){
            for(int i = 0; i < 3; i++){
                System.out.println("Hello how are you?" + name);
            }
        }
    }
}

class OurThread extends Thread{
    Message object = new Message();
    @Override
    public void run(){
        System.out.println("Please enter the name that you would like to ask how are they");
        Scanner console = new Scanner(System.in);
        String n = console.next();
        object.show(n);
    }
}
