package HashMap;

import java.util.*;

public class SubarraySumDivisbleByK {

	public static int subarraysDivByK(int[] a, int k) {

		int sum = 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			int rem = sum % k;
			if (rem < 0)
				rem += k;
			count += map.getOrDefault(rem, 0);
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int z = 0; z < n; z++) {
			arr[z] = scn.nextInt();
		}
		System.out.println(subarraysDivByK(arr, k));
	}
}