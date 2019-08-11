package DPandGreedy;

import java.util.*;

public class MinimumOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		minOperations(n);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an integer
	// It should print the required output

	static void minOperations(int n) {
		int a[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {

			if (i % 2 == 0) {
				a[i] = Math.min(a[i - 1], a[i / 2]) + 1;
			} else {
				a[i] = Math.min(a[i - 1] + 1, a[i / 2] + 2);
			}
		}

		System.out.println(a[n]);
	}
}