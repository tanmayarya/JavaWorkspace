package HashMap2;

import java.util.*;

public class LongestSubarrayWithSumDivisibleByK {

	public static void print(int n, int[] a, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int length = 0, sum = 0;
		map.put(0, -1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			int key = sum % k;
			if (key < 0)
				key += k;
			if (map.containsKey(key))
				length = Math.max(length, i - map.get(key));
			else
				map.put(key, i);

		}
		System.out.println(length);
	}

	// Don't make any changes here.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = s.nextInt();
		}
		int k = s.nextInt();
		print(n, num, k);
	}

}
