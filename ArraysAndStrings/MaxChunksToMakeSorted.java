package ArraysAndStrings;

import java.util.*;

public class MaxChunksToMakeSorted {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		System.out.println(maxChunksToSorted(a));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written
	// This function takes as input an array
	// It should return required output

	public static int maxChunksToSorted(int[] a) {
		int count = 0;

		int max[] = new int[a.length];
		int min[] = new int[a.length];
		max[0] = Integer.MIN_VALUE;

		for (int i = 1; i < a.length; i++)
			max[i] = Math.max(a[i - 1], max[i - 1]);

		min[a.length - 1] = a[a.length - 1];

		for (int i = a.length - 2; i >= 0; i--)
			min[i] = Math.min(min[i + 1], a[i]);

		for (int i = 0; i < a.length; i++) {
			if (min[i] > max[i])
				count++;
		}

		return count;
	}
}
