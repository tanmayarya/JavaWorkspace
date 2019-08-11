package DPandGreedy;

import java.util.*;

public class BurstBalloons {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n + 2];
		nums[0] = 1;
		nums[n + 1] = 1;
		for (int i = 1; i <= n; i++)
			nums[i] = scn.nextInt();
		System.out.println(maxCoins(nums));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// It should return the required output

	public static int maxCoins(int[] nums) {

		int a[][] = new int[nums.length][nums.length];

		for (int g = 2; g < a.length; g++) {
			int i = 0, j = i + g;
			while (j < a.length) {
				int maxcoins = 0;
				for (int k = i + 1; k < j; k++) {
					maxcoins = Math.max(maxcoins, nums[i] * nums[k] * nums[j] + a[i][k] + a[k][j]);
				}
				a[i][j] = maxcoins;
				i++;
				j++;
			}
		}

		return a[0][a.length - 1];
	}
}