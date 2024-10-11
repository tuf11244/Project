/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 10/10/2024
 * https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
 * @author parth
 */
public class TheNumberoftheSmallestUnoccupiedChair {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int smallestChair(int[][] times, int targetFriend) {
        // Priority queue to sort friends by arrival time
        PriorityQueue<Chair> arrivalQueue = new PriorityQueue<>((a, b) -> a.start - b.start);
        // Priority queue to manage free chairs sorted by chair index
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        // Priority queue to manage occupied chairs sorted by when they will be free (end time)
        PriorityQueue<OccupiedChair> occupiedChairs = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);

        // Add all friends to the arrival queue
        for (int i = 0; i < times.length; i++) {
            arrivalQueue.add(new Chair(times[i][0], times[i][1], i));
        }

        // Initialize chairs (they are indexed starting from 0)
        int nextChair = 0;

        while (!arrivalQueue.isEmpty()) {
            Chair current = arrivalQueue.poll();

            // Free up chairs of friends who have already left before this friend arrives
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek().endTime <= current.start) {
                availableChairs.add(occupiedChairs.poll().chairNumber);
            }

            // Get the smallest available chair, or allocate a new chair if none are free
            int assignedChair;
            if (availableChairs.isEmpty()) {
                assignedChair = nextChair++;
            } else {
                assignedChair = availableChairs.poll();
            }

            // If the current friend is the target friend, return the assigned chair
            if (current.friend == targetFriend) {
                return assignedChair;
            }

            // Mark this chair as occupied until the current friend leaves
            occupiedChairs.add(new OccupiedChair(current.end, assignedChair));
        }

        return -1; // Shouldn't reach here, but just in case
    }
}

class Chair {
    int start;
    int end;
    int friend;

    public Chair(int start, int end, int friend) {
        this.start = start;
        this.end = end;
        this.friend = friend;
    }
}

class OccupiedChair {
    int endTime;
    int chairNumber;

    public OccupiedChair(int endTime, int chairNumber) {
        this.endTime = endTime;
        this.chairNumber = chairNumber;
    }
}
}
