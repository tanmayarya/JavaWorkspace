package DPandGreedy;

import java.util.*;

public class Minimumpartition {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();
		System.out.println(findMinSumPartition(a, n));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array alongwith its length
	// It should return the required output

	static int findMinSumPartition(int a[], int n) {

		return 0;

	}
}
