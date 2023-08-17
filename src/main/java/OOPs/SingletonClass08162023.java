/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package OOPs;

/**
 *
 * @author parth
 */
public class SingletonClass08162023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     //   Singleton object = new Singleton();//Can't use it ERROR as the constructor is private 
     Singleton object1 = Singleton.getInstance();
     Singleton object2 = Singleton.getInstance();
     
     //Both the above statement are pointing to the same object i.e. Object1 
        System.out.println(object1);
        // TODO code application logic here
    }
}

 class Singleton{
    private Singleton(){       //Private Constructor
    }
    public static Singleton instance; //Declaring a new object for the Singleton Class 
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
