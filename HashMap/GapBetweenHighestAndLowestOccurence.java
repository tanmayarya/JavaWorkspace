package HashMap;

import java.util.*;

public class GapBetweenHighestAndLowestOccurence {

	public static void findDifference(int[] a) {
		int hf = 0, lf = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			lf = Math.min(lf, map.get(a[i]));
			hf = Math.max(hf, map.get(a[i]));
		}
		System.out.println(hf-lf);
	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextInt();
		}
		findDifference(num);
	}
}
