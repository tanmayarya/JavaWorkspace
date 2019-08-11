package ArraysAndStrings;

import java.util.*;

public class Attacking {

	public static int findPoisonedDuration(int[] timeSeries, int k) {
		int count = 0;

		for (int i = 0; i < timeSeries.length - 1; i++) {
			if (timeSeries[i + 1] - timeSeries[i] >= k)
				count += k;
			else
				count += timeSeries[i + 1] - timeSeries[i];
		}
		count += k;

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] timeseries = new int[n];
		for (int i = 0; i < n; i++) {
			timeseries[i] = sc.nextInt();
		}
		System.out.println(findPoisonedDuration(timeseries, k));
	}

}
