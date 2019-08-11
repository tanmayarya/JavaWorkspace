package ArraysAndStrings;

import java.util.*;

public class magicSquaresInGrid {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] Input = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Input[i][j] = scn.nextInt();
			}
		}
		System.out.print(numMagicSquaresInside(Input));
	}

	// -----------------------------------------------------
	// This is a functional problem. Do not make changes to main
	// This function takes as input an array and integer k.
	// It should print required output.
	public static int numMagicSquaresInside(int[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[i].length - 2; j++) {
				if (isMagic(grid, i, j))
					count++;
			}
		}
		return count;
	}

	public static boolean isMagic(int[][] grid, int si, int sj) {
		if (grid[si + 1][sj + 1] != 5)
			return false;
		int sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = si; i < si + 3; i++) {
			for (int j = sj; j < sj + 3; j++) {
				if (set.contains(grid[i][j]))
					return false;
				else
					set.add(grid[i][j]);
				sum += grid[i][j];
			}
			if (sum != 15)
				return false;
			sum = 0;
		}
		for (int j = sj; j < sj + 3; j++) {
			for (int i = si; i < si + 3; i++) {
				sum += grid[i][j];
			}
			if (sum != 15)
				return false;
			sum = 0;
		}
		for (int i = si, j = sj; i < si + 3 && j < sj + 3; j++, i++)
			sum += grid[i][j];
		if (sum != 15)
			return false;
		sum = 0;
		for (int i = si, j = sj + 2; i < si + 3 && j >= sj; j--, i++)
			sum += grid[i][j];
		if (sum != 15)
			return false;

		return true;
	}
}
