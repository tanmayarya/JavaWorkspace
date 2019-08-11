package StackAndQueue;

import java.util.*;

public class ConnectingRopes {

	public static long minCostRopes(long[] arr) {
		// Write your code here
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		for (int i = 0; i < arr.length; i++)
			q.add(arr[i]);
		Long cost = (long) 0;
		while (q.size() > 1) {
			long a = q.remove() + q.remove();
			cost += a;
			q.add(a);
		}

		return cost;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextLong();
		System.out.println(minCostRopes(arr));

	}
}
