package HashMap2;

import java.util.*;

public class LargestSubarrayWith0Sum {

	static int maxLen(int a[], int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int k = 0;
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
		return length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(maxLen(arr, n));
	}
}
