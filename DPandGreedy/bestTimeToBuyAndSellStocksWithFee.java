package DPandGreedy;

import java.util.*;

public class bestTimeToBuyAndSellStocksWithFee {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scn.nextInt();
		}
		int fee = scn.nextInt();
		System.out.print(maxProfit(prices, fee));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and an integer
	// It should return the required output

	public static int maxProfit(int[] prices, int fee) {
		// Write your code here
		int mpb = -prices[0];
		int mps = 0;

		for (int i = 1; i < prices.length; i++) {
			int a = mpb;
			mpb = Math.max(mpb, mps - prices[i]);
			mps = Math.max(mps, a - fee + prices[i]);

		}
		return mps;
	}
}