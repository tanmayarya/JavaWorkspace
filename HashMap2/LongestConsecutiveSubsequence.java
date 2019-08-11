package HashMap2;

import java.util.*;
import java.util.Map.Entry;

public class LongestConsecutiveSubsequence {

	public static int consecuitveSub(int n, int[] a) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int i = 0; i < a.length; i++)
			map.put(a[i], true);

		for (int i = 0; i < a.length; i++)
			if (map.containsKey(a[i] - 1))
				map.put(a[i], false);
		boolean counting = false;
		int count = 0;
		int max =0;
		for (Entry<Integer, Boolean> entry : map.entrySet()) {
			if (entry.getValue()) {
				count = 1;
				while (map.containsKey(entry.getKey() + count))
					count++;
				max = Math.max(max, count);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		System.out.println(consecuitveSub(n, num));

	}

}
