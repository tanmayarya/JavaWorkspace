package DPandGreedy;

import java.util.*;

public class PaintHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] costs = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				costs[i][j] = scn.nextInt();
			}
		}
		System.out.println(minCost(costs));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2D array
	// It should return the required output

	public static int minCost(int[][] costs) {

		return 0;
		
	}
}