package DPandGreedy;

import java.util.*;

public class BestTimeToBuyAndSellStockVersion3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scn.nextInt();
		}
		System.out.print(maxProfit(prices, n));
	}
	// -----------------------------------------------------
	// This function takes as input an array and its size
	// It should return the required output

	public static int maxProfit(int prices[], int n) {
		int max = 0;
		
		return max;
	}
}