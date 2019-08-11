package DPandGreedy;

import java.util.*;

public class CombinationSumVersion4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = scn.nextInt();
		int target = scn.nextInt();
		System.out.println(combinationSum4(nums, target));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and integer
	// It should return the required output

	public static int combinationSum4(int[] nums, int target) {

		int dp[] = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] <= i)
					dp[i] += dp[i - nums[j]];
			}
		}
		return dp[target];
	}
}