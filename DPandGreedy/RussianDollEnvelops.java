package DPandGreedy;

import java.util.*;

public class RussianDollEnvelops {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		pair envelope[] = new pair[r];
		for (int i = 0; i < r; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			envelope[i] = new pair(a, b);
		}
		System.out.println(maxEnvelopes(envelope));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as an integer array
	// It should return the required output

	public static class pair implements Comparable<pair> {
		int h, w;

		public pair(int a, int b) {
			h = a;
			w = b;
		}

		@Override
		public int compareTo(pair o) {

			if (this.h > o.h)
				return 1;
			else if (this.h < o.h)
				return -1;

			return 0;
		}
	}

	public static int maxEnvelopes(pair[] envelopes) {
		int max = 1;
		Arrays.sort(envelopes);

		int a[] = new int[envelopes.length];
		a[0] = 1;
		for (int i = 1; i < envelopes.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (envelopes[i].w > envelopes[j].w && envelopes[i].h > envelopes[j].h && a[i] < a[j] ) {
					a[i] = a[j];
				}
			}
			a[i]++;
			max = Math.max(max, a[i]);
		}

		return max;
	}
}