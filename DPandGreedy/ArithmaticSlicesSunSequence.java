package DPandGreedy;

import java.util.*;

public class ArithmaticSlicesSunSequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = scn.nextInt();
		System.out.print(Arithmetic_Subsequence(A));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an integer array
	// It should return the required output

	public static int Arithmetic_Subsequence(int[] a) {
		HashMap<Integer, Integer> maps[] = new HashMap[a.length];

		for (int i = 0; i < maps.length; i++)
			maps[i] = new HashMap<Integer, Integer>();

		int count = 0;

		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				count += maps[j].getOrDefault(a[i] - a[j], 0);
				maps[i].put(a[i] - a[j],
						maps[i].getOrDefault(a[i] - a[j], 0) + maps[j].getOrDefault(a[i] - a[j], 0) + 1);
			}
		}

		return count;
	}
}