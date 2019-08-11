package HashMap2;

import java.util.*;

public class KthSmallestElementInMatrix {

	public static class pcomp implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2)
				return -1;
			else if (o1 < o2)
				return 1;
			else
				return 0;
		}

	}

	public static int findKthSmallest(int[][] nums, int k) {
		// write your code here.
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new pcomp());

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				if (q.size() < k)
					q.add(nums[i][j]);
				else if (nums[i][j] < q.peek()) {
					q.poll();
					q.add(nums[i][j]);
				}
			}
		}

		return q.peek();

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for length of first array.
		int N = sc.nextInt();

		int[][] mat = new int[N][N];

		// Input for matrix elements.
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		int K = sc.nextInt();

		int result = findKthSmallest(mat, K);

		System.out.println(result);

	}

	// Function to display a matrix.
	public static void display(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
