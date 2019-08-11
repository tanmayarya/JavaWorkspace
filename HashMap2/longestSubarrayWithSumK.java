package HashMap2;

import java.util.*;

public class longestSubarrayWithSumK {

	public static void print(int n, int[] a, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int length = 0, sum = 0;
		map.put(0, -1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (map.containsKey(sum - k)) {
				length = Math.max(length, i - map.get(sum - k));
			}
			if (!map.containsKey(sum))
				map.put(sum, i);

		}
		System.out.println(length);
	}

	// Don't make any changes here.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = s.nextInt();
		}
		print(n, num, k);
	}

}
