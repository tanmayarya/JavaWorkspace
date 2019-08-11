package StackAndQueue;

import java.util.*;

public class KSubarrayMaxSum {

	public static void printMax(int[] a, int k) {
		// Write your code here
		ArrayList<Integer> q = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			while (!q.isEmpty() && a[q.get(q.size() - 1)] < a[i])
				q.remove(q.size() - 1);
			q.add(i);
		}
		for (int i = k; i < a.length; i++) {
			while (!q.isEmpty() && a[q.get(q.size() - 1)] < a[i] && q.get(q.size() - 1) + k > i)
				q.remove(q.size() - 1);
			if (i >= k)
				q.add(i);

		}
		for (int i = 0; i < a.length; i++) {
			if (q.get(0) < i - k + 1)
				q.remove(0);
			if (q.get(0) < i + k)
				System.out.print(a[q.get(0)] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		printMax(arr, k);

	}
}