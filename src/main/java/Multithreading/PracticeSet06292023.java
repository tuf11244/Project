/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class PracticeSet06292023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Question1 object1 = new Question1();
        Question1B object1B = new Question1B();
        
      // object1.setPriority(4);
        object1B.setPriority(6);
       // object1.start();
       // object1B.start();
      //  System.out.println(object1.getPriority());
       // System.out.println(object1B.getPriority());
        System.out.println(object1.currentThread().getState());
        System.out.println(object1.getState());
        object1B.start();
        // TODO code application logic here
    }
}
class Question1 extends Thread{
    @Override
    public void run(){
      //  while(true){
        System.out.println("Good Morning");
        //System.out.println("Welcome");
   // }
}
}
class Question1B extends Thread{
    @Override
    public void run(){
      //  while(true){
        /*    try{
                Thread.sleep(200);
            }
            catch(Exception e){
                System.out.println(e);
            }*/
       // System.out.println("Good Morning");
        System.out.println("Welcome");
    //}
}
}
