package ArraysAndStrings;

import java.util.*;

public class LoopingInCircularArray {

	public static boolean isCycle(int a[]) {

		HashSet<Integer> pv = new HashSet<Integer>();
		HashSet<Integer> tv = new HashSet<Integer>();

		boolean isPositive = true;

		for (int i = 0; i < a.length; i++) {

			isPositive = a[i] > 0;

			if (!pv.contains(a[i])) {

				for (int j = i;; j %= a.length) {
					if (j < 0)
						j += a.length;
					if (pv.contains(j)) {
						if (tv.contains(a[j])&& tv.size()>1)
							return true;
						else
							break;

					} else {
						if (isPositive == a[j] > 0) {
							pv.add(j);
							tv.add(j);
							j += a[j];
						} else
							break;
					}
				}
				tv.clear();
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();

		System.out.println(isCycle(a));

	}

}
