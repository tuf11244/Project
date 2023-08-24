/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class StaticSynchronization07062023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Bank object1 = new Bank(5000);
         Bank object2 = new Bank(2000);
       
        Thread t1 = new Thread(object1);
        Thread t2 = new Thread(object1);
        Thread t3 = new Thread(object2);
        Thread t4 = new Thread(object2);
        t1.start();t2.start();t3.start();t4.start();
        t1.setName("Parth");
        t2.setName("Jigar");
        t3.setName("Hriday");
        t4.setName("Pia");
        
        // TODO code application logic here
    }
}

class Bank extends Thread{
   static int balance = 5000;
    static int withdraw;
    Bank(int withdraw){
        this.withdraw = withdraw;
    }
    public static synchronized void withDraw(){
     String name = Thread.currentThread().getName();
        if(withdraw<=balance){            
            System.out.println(name + " has withdrawn" + " " + withdraw ); 
            balance = balance - withdraw;
        }
        else{
            System.out.println("Insufficient Funds");
        }
      System.out.println("The remaining balance is " + balance);
        
    }
  
   @Override
    public void run(){
        withDraw();
    }
}
