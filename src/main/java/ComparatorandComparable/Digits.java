/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;

/**
 *
 * @author parth
 */
public class Digits {

    int lastDigits;
    public Digits(){
        
    }
    public Digits(int lastDigits){
        this.lastDigits = lastDigits;
    }

    public int getLastDigits() {
        return lastDigits;
    }

    @Override
    public String toString() {
        return "Digits{" + "lastDigits=" + lastDigits + '}';
    }
   
}
