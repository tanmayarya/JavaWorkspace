package HashMap;

import java.util.*;

public class SubarrayRangeWithGivenSum {

	static int subArraySum(int a[], int n, int target) {
		int sum = 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			count += map.getOrDefault(sum-target, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int sum = scn.nextInt();
		int[] arr = new int[n];
		for (int z = 0; z < n; z++) {
			arr[z] = scn.nextInt();
		}
		System.out.println(subArraySum(arr, n, sum));
	}
}
