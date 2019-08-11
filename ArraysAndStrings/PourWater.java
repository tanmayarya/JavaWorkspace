package ArraysAndStrings;

import java.util.*;

public class PourWater {

	public static int[] pourWater(int[] height, int v, int k) {
		// write your code here.
		int a[] = height;

		while (v > 0) {

			if (k - 1 >= 0 && a[k - 1] < a[k]) {
				int i = 0, minIdx = k - 1;
				for (i = k - 1; i > 0; i--) {
					if (a[i-1] < a[minIdx])
						minIdx = i-1;
					if (a[i] < a[i - 1])
						break;
				}
				a[minIdx]++;
			}

			else if (k + 1 < a.length && a[k + 1] < a[k]) {

				int i = 0, minIdx = k + 1;
				for (i = k + 1; i < a.length - 1; i++) {
					if (a[i+1] < a[minIdx])
						minIdx = i+1;
					if (a[i] < a[i + 1])
						break;
				}
				a[minIdx]++;

			} else
				a[k]++;

			v--;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for length of first array.
		int N = sc.nextInt();

		int[] arr1 = new int[N];

		// Input for array1 elements.
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}

		int V = sc.nextInt();
		int K = sc.nextInt();

		int[] result = pourWater(arr1, V, K);
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