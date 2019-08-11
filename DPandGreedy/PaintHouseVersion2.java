package DPandGreedy;

import java.util.*;

public class PaintHouseVersion2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[][] costs = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				costs[i][j] = scn.nextInt();
			}
		}
		System.out.println(minCostII(costs));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2d array
	// It should return the required output

	public static int minCostII(int[][] costs) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int a[][] = new int[costs.length][costs[0].length];

		for (int j = 0; j < a[0].length; j++)
			a[0][j] = costs[0][j];

		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				q.add(a[i - 1][j]);

			int sm = q.poll();
			int ssm = q.poll();

			for (int j = 0; j < a[0].length; j++) {
				if (a[i-1][j] == sm)
					a[i][j] = costs[i][j] + ssm;
				else
					a[i][j] = costs[i][j] + sm;
			}

			q.clear();
		}
		int min = a[a.length-1][0];
		for (int j = 1; j < a[0].length; j++) {
			min = Math.min(a[a.length-1][j], min);
		}

		return min;
	}
}