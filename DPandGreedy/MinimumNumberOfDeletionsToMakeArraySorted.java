package DPandGreedy;

import java.util.*;

public class MinimumNumberOfDeletionsToMakeArraySorted {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();
		mindeletions(a, n);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and its length
	// It should print the required output

	public static void mindeletions(int[] a, int n) {
		// Write your code here
		System.out.println(a.length - lis(a));
	}

	public static int lis(int a[]) {
		int lis[] = new int[a.length];
		int max = 1;
		lis[0] = 1;

		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] < a[i] && lis[j] > lis[i]) {
					lis[i] = lis[j];
				}
			}
			lis[i]++;
			max = Math.max(max, lis[i]);
		}

		return max;
	}
}