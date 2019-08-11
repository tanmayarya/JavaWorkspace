package DPandGreedy;

import java.util.*;

public class ArithmaticSlices {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = scn.nextInt();
		System.out.println(Arithmetic_Slices(A));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input one array
	// It should return the required output

	public static int Arithmetic_Slices(int[] a) {
		if (a.length < 3)
			return 0;
		int dif = a[1] - a[0];
		int num = 0, count = 2;

		for (int i = 2; i < a.length; i++) {
			if (a[i] - a[i - 1] == dif) {
				count++;
				if (count > 2) {
					num += count-2;
				}
			} 
			else {
				count = 2;
				dif = a[i] - a[i - 1];
			}
		}
		return num;
	}
}