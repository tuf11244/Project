/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *
 * given 3 sorted arrays (A,B,C) each of size n;and an integer D;
    you have to find number of tuples (i,j,k)
    such that:-
    |A[i]-B[j]|<=D
    |B[j]-C[k]|<=D
    |A[i]-C[k]|<=D
provided time complexity of N2logN
but interviewer told that O(N),O(NlogN) solutions were also possible
PS : duplicates are possible
 * @author parth
 */
public class GoogleInterviewQuestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Approach = O(n^2Logn)
    public static int countTuples(int[] A, int[] B, int[] C, int D) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                // Define the valid range for C[k] based on A[i] and B[j]
                int lowerBound = Math.max(A[i] - D, B[j] - D);
                int upperBound = Math.min(A[i] + D, B[j] + D);

                // Find the number of elements in C that fall within [lowerBound, upperBound]
                int start = lowerBound(C, lowerBound);
                int end = upperBound(C, upperBound);

                // Add the number of valid C[k]s in the range
                count += (end - start + 1);
            }
        }
        return count;
    }

    // Binary search to find the lower bound (first element >= target)
    private static int lowerBound(int[] C, int target) {
        int low = 0, high = C.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (C[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Binary search to find the upper bound (last element <= target)
    private static int upperBound(int[] C, int target) {
        int low = 0, high = C.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (C[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    
    //O(N)
    public static int countTuplesOptimized(int[] A, int[] B, int[] C, int D) {
        int i = 0, j = 0, k = 0;
        int count = 0;

        while (i < A.length && j < B.length && k < C.length) {
            if (Math.abs(A[i] - B[j]) <= D && Math.abs(B[j] - C[k]) <= D && Math.abs(A[i] - C[k]) <= D) {
                count++;
                i++;
                j++;
                k++;
            } else {
                // Move the pointer with the smallest value
                if (A[i] <= B[j] && A[i] <= C[k]) {
                    i++;
                } else if (B[j] <= A[i] && B[j] <= C[k]) {
                    j++;
                } else {
                    k++;
                }
            }
        }
        return count;
    }
}
