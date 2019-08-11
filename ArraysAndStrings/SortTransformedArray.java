package ArraysAndStrings;

import java.util.*;

public class SortTransformedArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scn.nextInt();
		}
		Arrays.sort(nums);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		int[] res = sortTransformedArray(nums, a, b, c);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and 3 integers
	// It should return an integeral array

	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int ar[] = new int[nums.length];

		for (int i = 0; i < ar.length; i++) {
			ar[i] = a * nums[i] * nums[i] + b * nums[i] + c;
		}

		Arrays.sort(ar);
		return ar;
	}
}
