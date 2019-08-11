package DPandGreedy;

import java.util.*;

public class MinimumPathSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int m2[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				m2[i][j] = scn.nextInt();
			}
		}
		System.out.println(maze(m2));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input a 2D array
	// It should return the required output

	public static int maze(int[][] m) {
		// Write your code here
		return calculate(new int[m.length][m[0].length], m, 0, 0);

	}

	public static int calculate(int dp[][], int a[][], int i, int j) {

		if (i == a.length - 1 && j == a[i].length - 1)
			return a[i][j];

		if (i >= a.length || j >= a[i].length)
			return Integer.MAX_VALUE;

		if (dp[i][j] != 0)
			return dp[i][j];

		return Math.min(calculate(dp, a, i + 1, j), calculate(dp, a, i, j + 1)) + a[i][j];

	}
}
