package ArraysAndStrings;

import java.util.*;

public class BuyStockAndSellStockV2 {

	public static int maxProfit(int[] a) {
		int profit = 0;

		if (a.length < 2)
			return 0;

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1])
				profit += a[i + 1] - a[i];
		}

		return profit;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(maxProfit(arr));
	}

	// function to display an array.
	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}
}