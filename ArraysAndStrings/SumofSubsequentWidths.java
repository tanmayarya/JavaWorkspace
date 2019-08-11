package ArraysAndStrings;

import java.util.*;

public class SumofSubsequentWidths {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scn.nextInt();
		}
		System.out.print(sumSubseqWidths(A));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// It should return the required output

	public static int sumSubseqWidths(int[] a) {

		Arrays.sort(a);
		int min = 1;
		int max = 1;

		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			max = (int) Math.pow(2, i);
			min = (int) Math.pow(2, a.length - 1 - i);

			sum += ((max - min) * a[i]);
		}
		return sum;
	}
}