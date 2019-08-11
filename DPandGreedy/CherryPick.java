package DPandGreedy;

import java.util.*;

public class CherryPick {
	public static boolean flag = false;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] grid = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				grid[i][j] = scn.nextInt();
			}
		}
		System.out.print(cherryPickup(grid));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2D array
	// It should return the required output

	public static int cherryPickup(int[][] grid) {

		int ans = cp(0, 0, 0, grid, new int[grid.length][grid.length][grid[0].length]);
		if (!flag)
			return 0;
		return ans;
	}

	public static int cp(int r1, int c1, int r2, int grid[][], int a[][][]) {
		int ans = 0;
		int c2 = c1 + r1 - r2;

		if (r1 == grid.length-1 && c1 == grid[0].length-1) {
			flag = true;
			return grid[r1][c1];
		}

		if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid.length)
			return 0;
		if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
			return 0;
		if (a[r2][r1][c1] != 0)
			return a[r2][r1][c1];

		int f1 = cp(r1 + 1, c1, r2 + 1, grid, a);
		int f2 = cp(r1, c1 + 1, r2, grid, a);
		int f3 = cp(r1 + 1, c1, r2, grid, a);
		int f4 = cp(r1, c1 + 1, r2 + 1, grid, a);
		if (r1 == r2 && c1 == c2)
			ans = Math.max(Math.max(f1, f2), Math.max(f3, f4)) + grid[r1][c1];
		else
			ans = Math.max(Math.max(f1, f2), Math.max(f3, f4)) + grid[r1][c1] + grid[r2][c2];
		a[r2][r1][c1] = ans;
		return ans;
	}
}