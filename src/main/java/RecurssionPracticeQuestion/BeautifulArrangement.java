/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

//https://leetcode.com/problems/beautiful-arrangement/
import java.util.Arrays;
import java.util.ArrayList;
public class BeautifulArrangement{
    public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 3;
		int[] arr = new int[n];
		
		//Generate the Array; using N 
		for(int i = 0; i < n;i++){
		    arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
		//Below would be the list of list with all the permutations of the array
		ArrayList<ArrayList<Integer>> result = permute(arr);
		for(ArrayList<Integer> element : result){
		    System.out.print(element + " ");
		}
		System.out.println();
		System.out.println(countArrangement(result));
		
	}
	//Generate a List of List with all the permutations of the Array using backtracking
	public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; //used for backtracking

        generatePermutations(nums, used, current, result);

        return result;
    }
	private static void generatePermutations(int[] nums, boolean[] used, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                generatePermutations(nums, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    //Count the Arrangement 
     public static int countArrangement(ArrayList<ArrayList<Integer>> result) {
        int count = 0;
        for (ArrayList<Integer> element : result) {
            boolean isBeautiful = true;
            for (int i = 0; i < element.size(); i++) {
                if (element.get(i) % (i + 1) != 0 && (i + 1) % element.get(i) != 0) {
                    isBeautiful = false;
                    break;
                }
            }
            if (isBeautiful) {
                count++;
            }
        }
        return count;
    }
}
