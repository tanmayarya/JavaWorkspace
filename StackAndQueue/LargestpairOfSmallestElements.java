package StackAndQueue;

import java.util.*;

public class LargestpairOfSmallestElements {

	public static long findlargest(long arr[], int n) {
		long sum = 0;
		for (int i = 0; i < arr.length - 1; i++)
			sum = Math.max(sum, arr[i] + arr[i + 1]);
		return sum;
	}

	// Dont make changes here
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextLong();
		System.out.println(findlargest(arr, n));

	}
}
