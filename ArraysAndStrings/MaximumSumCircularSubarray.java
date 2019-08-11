package ArraysAndStrings;

import java.util.*;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scn.nextInt();
		}
		System.out.print(maxSubarraySumCircular(A));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// It should return the required output

	public static int maxSubarraySumCircular(int[] a) {

		int msf = Integer.MIN_VALUE, sum = 0;
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			total += a[i];
			sum += a[i];
			if (sum < 0)
				sum = 0;
			msf = Math.max(sum, msf);
		}

		int minsf = Integer.MAX_VALUE;
		sum = 0;

		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum > 0)
				sum = 0;
			minsf = Math.min(sum, minsf);
		}

		return Math.max(msf, total - minsf);

	}

}