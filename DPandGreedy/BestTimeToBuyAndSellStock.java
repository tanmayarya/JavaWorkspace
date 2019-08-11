package DPandGreedy;

import java.util.*;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scn.nextInt();
		}
		System.out.print(maxProfit(prices));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// It should return the required output

	public static int maxProfit(int prices[]) {
		// Write your code here
		int minsf = prices[0];
		int maxdiff = 0;

		for (int i = 0; i < prices.length; i++) {
			minsf = Math.min(minsf, prices[i]);
			maxdiff = Math.max(maxdiff, prices[i] - minsf);
		}

		return maxdiff;
	}
}
