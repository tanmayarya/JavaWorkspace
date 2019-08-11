package ArraysAndStrings;

import java.util.*;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = scn.nextInt();
		}
		System.out.print(maxArea(height));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array of heights
	// It should return required output.

	public static int maxArea(int[] a) {
		int l = 0, r = a.length - 1;
		int max = 0;
		while (l < r) {
			int val = (r - l) * Math.min(a[l], a[r]);
			max = Math.max(max, val);

			if (a[l] < a[r])
				l++;
			else if (a[l] > a[r])
				r--;
			else {
				l++;
				r--;
			}
		}

		return max;
	}
}