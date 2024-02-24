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
public class Main3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<Books> list = new ArrayList<>();
        list.add(new Books("Great Expectations"));
        list.add(new Books("Rich Dad Poor Dad"));
        list.add(new Books("Dhando"));
        list.add(new Books("Tom Sawyer"));
        list.add(new Books("Atomic Habits"));
        
        Collections.sort(list, new BooksComparator());
        
        for(Books b : list){
            System.out.println(b);
        }
    }
}
