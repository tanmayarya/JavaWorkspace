package HashMap;

import java.util.*;

public class KthLargestElement {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solve(n, num, k);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array,n length of array and k.
	// It should print required output.
	public static void solve(int n, int[] a, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (q.size() < k)
				q.add(a[i]);
			else if (q.peek() < a[i]) {
				q.poll();
				q.add(a[i]);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>(q);
		Collections.sort(list);
		for (int i = list.size() - 1; i >= 0; i--)
			System.out.print(list.get(i) + " ");
	}
}