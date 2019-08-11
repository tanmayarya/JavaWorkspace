package ArraysAndStrings;

import java.util.*;

public class BestSightSeeingpair {

	public static int maxScoreSightseeingPair(int[] a) {
		int max = 0;
		for (int i = 0, j = 1; i < a.length && j < a.length; j++) {
			max = Math.max(max, a[i] + a[j] - (j - i));

			if (a[i] - (j - i) < a[j])
				i = j;
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(maxScoreSightseeingPair(arr));

	}

	// function to display an array.
	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}
}
