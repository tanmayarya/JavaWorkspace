package HashMap;

import java.util.*;

public class KSmallestElementInOrder {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int k = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		print_k_smallest_elements_in_their_original_order(n, k, arr);
	}

	public static void print_k_smallest_elements_in_their_original_order(int n, int k, int[] a) {

		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return 1;
				else if (o1 > o2)
					return -1;
				else
					return 0;
			}
		});

		for (int i = 0; i < a.length; i++) {
			if (q.size() < k)
				q.add(a[i]);
			else {
				if (a[i] < q.peek()) {
					q.poll();
					q.add(a[i]);
				}
			}
		}
		for (int i = 0; i < a.length; i++)
			if (q.contains(a[i]))
				System.out.print(a[i] + " ");
	}

}