package DPandGreedy;

import java.util.*;

public class MinimumStepsToMinimizeN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(count_min(n));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an integer
	// It should return the required output
	public static int count_min(int n) {

		int a[] = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			int z = Integer.MAX_VALUE;
			int x = Integer.MAX_VALUE;
			int c = a[i - 1] + 1;
			if (i % 3 == 0)
				z = a[i / 3] + 1;
			if (i % 2 == 0)
				x = a[i / 2] + 1;

			a[i] = Math.min(Math.min(z, x), c);
		}

		return a[n];
	}
}