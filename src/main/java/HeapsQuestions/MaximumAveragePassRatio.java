/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 12/14/2024
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 * @author parth
 */
public class MaximumAveragePassRatio {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue (max heap), ordering based on gain in ratio (largest gain first)
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));
        
        // Initializing the priority queue with classes
        for (int[] clas : classes) {
            ClassInfo p = new ClassInfo(clas[0], clas[1]);
            pq.add(p);
        }

        // Distribute the extra students to maximize gain
        while (extraStudents > 0) {
            // Remove the class with the largest possible gain in ratio
            ClassInfo rem = pq.poll();

            // Increment the pass and total students for this class
            rem.passStudents++;
            rem.students++;

            // Recalculate the gain for this class and reinsert it into the heap
            rem.calculateGain();
            pq.add(rem);

            // One less extra student to assign
            extraStudents--;
        }

        // Sum the average ratio of all classes
        double answer = 0.0;
        while (!pq.isEmpty()) {
            ClassInfo rem = pq.poll();
            answer += (double) rem.passStudents / rem.students;
        }

        // Return the final average
        return answer / classes.length;
    }
}

class ClassInfo {
    int passStudents;
    int students;
    double gain;

    // Constructor
    public ClassInfo(int passStudents, int students) {
        this.passStudents = passStudents;
        this.students = students;
        calculateGain();  // Calculate the initial gain based on the current state
    }

    // Method to calculate the gain based on passing ratio increment
    public void calculateGain() {
        gain = (double)(passStudents + 1) / (students + 1) - (double) passStudents / students;
    }
}

