package HashMap2;

import java.util.*;

public class LoveForTwins {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(mt(arr));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array.
	// It should return an integer value.
	public static int mt(int[] a) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++)
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);

		for (int val : map.values()) {
			count += (val / 2) * 2;
		}

		return count;
	}
}
