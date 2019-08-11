package ArraysAndStrings;

import java.util.*;

public class RangeAddition {

	public static int[] getModifiedArray(int length, int[][] updates) {
		int a[] = new int[length];

		for (int i = 0; i < updates.length; i++) {

			a[updates[i][0]] += updates[i][2];
			if (updates[i][1] + 1 < length)
				a[updates[i][1] + 1] -= updates[i][2];

		}
		for (int i = 1; i < length; i++)
			a[i] += a[i - 1];

		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for length of first array.
		int length = sc.nextInt();

		int K = sc.nextInt();

		int[][] updates = new int[K][3];

		for (int i = 0; i < updates.length; i++) {
			for (int j = 0; j < updates[0].length; j++) {
				updates[i][j] = sc.nextInt();
			}
		}

		int[] result = getModifiedArray(length, updates);
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
