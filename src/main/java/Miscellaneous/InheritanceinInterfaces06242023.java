/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 * 
 */

interface MycellPhone{
    void phoneCall();
    void games();
}
interface MysmartPhone extends MycellPhone{
    void camera();
    void tinder();
    void touchscreen();
}
class Phone implements MysmartPhone{
   @Override
   public void phoneCall(){
        System.out.println("Please pick the phone and dial the number that you want to");
    }
   @Override
  public void games(){
        System.out.println("Opening the games menu");
    }
   @Override
  public void camera(){
        System.out.println("Say Cheez");
    }
   @Override
  public void tinder(){
        System.out.println("Swipe right if she is preety otherwise swipe left if she is ugly");
    }
   @Override
   public void touchscreen(){
        System.out.println("The smartphone is touch screen");
    }
}
public class InheritanceinInterfaces06242023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Phone myPhone = new Phone();
       myPhone.phoneCall();
        // TODO code application logic here
    }
}
