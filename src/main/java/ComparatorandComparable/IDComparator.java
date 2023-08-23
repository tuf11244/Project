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
public class IDComparator implements Comparator<Employee08222023> {

    @Override
    public int compare(Employee08222023 o1, Employee08222023 o2) {
      return o1.getEmployeeID() - o2.getEmployeeID();
    }

    /**
     * @param args the command line arguments
     */
   
}
