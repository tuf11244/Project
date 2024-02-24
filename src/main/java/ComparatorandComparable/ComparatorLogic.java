/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;

import java.util.Comparator;

/**
 *
 * @author parth
 */
public class ComparatorLogic implements Comparator<Digits>{

    @Override
    public int compare(Digits i, Digits j) {
       if(i.getLastDigits()%10 > j.getLastDigits()%10){
           return 1;
       }
       return -1;
    }

    
}
