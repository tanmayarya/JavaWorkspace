package HashMap2;

import java.util.*;

public class KthLargestElementInStream {

	public static class pcomp implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2)
				return 1;
			else if (o1 < o2)
				return -1;
			else
				return 0;
		}

	}

	static class KthLargest {
		PriorityQueue<Integer> pq;
		int k;

		public KthLargest(int k, int[] nums) {
			pq = new PriorityQueue<Integer>(new pcomp());
			this.k = k;
			for (int i = 0; i < nums.length; i++) {
				if (pq.size() < k)
					pq.add(nums[i]);
				else if (nums[i] > pq.peek()) {
					pq.poll();
					pq.add(nums[i]);
				}
			}

		}

		public int add(int val) {
			// write your code here.
			if (val > pq.peek()) {
				pq.poll();
				pq.add(val);
			}
			return pq.peek();

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for length of first array.
		int N = sc.nextInt();

		int[] intialStream = new int[N];

		// Input for initial stream elements.
		for (int i = 0; i < intialStream.length; i++) {
			intialStream[i] = sc.nextInt();
		}

		int K = sc.nextInt();

		int M = sc.nextInt();
		int[] remainingStream = new int[M];

		// Input for remaining stream elements.
		for (int i = 0; i < remainingStream.length; i++) {
			remainingStream[i] = sc.nextInt();
		}

		KthLargest obj = new KthLargest(K, intialStream);

		for (int i = 0; i < remainingStream.length; i++) {
			int kthLargest = obj.add(remainingStream[i]);
			System.out.println(kthLargest);
		}

	}

	// Function to display an array.
	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}
