/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Multithreading;

/**
 *
 * @author parth
 */
public class PrintTables07062023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Table obj = new Table();
       Thread1 t1 = new Thread1(obj);
       Thread2 t2 = new Thread2(obj);
       t1.start();
       t2.start();
        System.out.println(t2.getState());
        // TODO code application logic here
    }
}

class Table {
    public synchronized void printTable(int n){
        for(int i = 0; i <= 10; i++){
            System.out.println(n*i);
        }
    }
  
}

class Thread1 extends Thread{
     Table object;
    Thread1(Table object){
        this.object = object;
    }
   // Table obj = new Table();
    public void run(){
        object.printTable(5);
    }
}
class Thread2 extends Thread{
    Table object;
    Thread2(Table object){
        this.object = object;
    }
    public void run(){
        object.printTable(8);
    }
}
        
