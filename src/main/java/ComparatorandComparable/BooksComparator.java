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
public class BooksComparator implements Comparator<Books> {

   

    @Override
    public int compare(Books o1, Books o2) {
        if(o1.getBooks().length() > o2.getBooks().length()){
            return 1;
        }
        return -1;
    }
}
