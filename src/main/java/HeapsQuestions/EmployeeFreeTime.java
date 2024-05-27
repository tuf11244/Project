package HeapsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Date: 04/04/2024
 * https://leetcode.com/problems/employee-free-time/
 * @author parth
 */
public class EmployeeFreeTime {

    public static void main(String args[]) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(List.of(new Interval(1, 2), new Interval(5, 6)));
        schedule.add(List.of(new Interval(1, 3)));
        schedule.add(List.of(new Interval(4, 10)));
        
        List<Interval> answer = employeeFreeTime(schedule);
        
        for (Interval x : answer) {
            System.out.println(x);
        }
    }
    
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> answer = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start); // Min heap
        
        // Add all intervals to the priority queue
        for (List<Interval> employee : schedule) {
            pq.addAll(employee);
        }
        
        // Merge intervals and find gaps
        Interval prev = pq.poll(); // Start with the first interval
        while (!pq.isEmpty()) {
            Interval current = pq.poll();
            if (prev.end < current.start) {
                // If there is a gap between prev and current
                answer.add(new Interval(prev.end, current.start));
                prev = current; // Move to the next interval
            } else {
                // Merge overlapping intervals
                prev.end = Math.max(prev.end, current.end);
            }
        }

        return answer;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
