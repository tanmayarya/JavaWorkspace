package ArraysAndStrings;

import java.util.*;

public class ShorrtestContinuousSubarray {

	public static int findUnsortedSubarray(int[] a) {

		int start = -1;
		int end = -1;
		int max[] = new int[a.length];
		int min[] = new int[a.length];

		max[0] = a[0];
		for (int i = 1; i < a.length; i++)
			max[i] = Math.max(max[i - 1], a[i]);

		min[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--)
			min[i] = Math.min(min[i + 1], a[i]);

		for (int i = 0; i < a.length; i++) {
			if (min[i] != max[i]) {
				start = i;
				break;
			}
		}

		for (int i = a.length - 1; i >= 0; i--) {
			if (min[i] != max[i]) {
				end = i;
				break;
			}
		}
		if (start >= end)
			return 0;

		return end - start + 1;
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

		System.out.println(findUnsortedSubarray(arr));

	}

	// function to display an array.
	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}