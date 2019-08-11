package ArraysAndStrings;

import java.util.*;

public class SquaresOfSortedArray {

	public static int[] sortedSquares(int[] a) {

		int res[] = new int[a.length];

		int l = 0, r = a.length - 1, i = a.length - 1;
		while (l <= r &&i>=0) {
			if (a[l] * a[l] > a[r] * a[r]) {
				res[i] = a[l] * a[l];
				l++;
			} else {
				res[i] = a[r] * a[r];
				r--;
			}
			i--;
		}

		return res;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for length of array.
		int length = sc.nextInt();

		int[] arr = new int[length];

		// Input for elements of array.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int[] result = sortedSquares(arr);
		display(result);

	}

	// function to display an array.
	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}