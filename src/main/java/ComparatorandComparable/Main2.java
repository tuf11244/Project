/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ComparatorandComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author parth
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<Digits> list = new ArrayList<>();
        list.add(new Digits(43));
        list.add(new Digits(31));
        list.add(new Digits(72));
        list.add(new Digits(29));
        ComparatorLogic com = new ComparatorLogic();
        Collections.sort(list, com);
        System.out.println(list);
    }
}
