/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class Concurrency06292023 extends Thread {
public static int amount = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Concurrency06292023 object = new Concurrency06292023();
        object.start();
        System.out.println(amount);
        amount++;
        System.out.println(amount);
                // TODO code application logic here
    }
@Override
    public void run(){
        amount++;       
    }
    
}


  

