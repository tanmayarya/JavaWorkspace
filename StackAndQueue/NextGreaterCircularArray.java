package StackAndQueue;

import java.util.*;

public class NextGreaterCircularArray {

	public static int[] nextGreaterInCircularManner(int[] arr) {

		int res[] = new int[arr.length];
		res[arr.length - 1] = -1;
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr[arr.length - 1]);

		for (int i = 2 * arr.length - 2; i >= 0; i--) {

			while (!st.isEmpty() && arr[i % arr.length] >= st.peek())
				st.pop();

			if (st.isEmpty())
				res[i % arr.length] = -1;
			else
				res[i % arr.length] = st.peek();
			st.push(arr[i % arr.length]);
		}
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int[] nums1 = new int[n1];
		for (int i = 0; i < n1; i++)
			nums1[i] = sc.nextInt();
		int[] res = nextGreaterInCircularManner(nums1);
		for (int i = 0; i < n1; i++)
			System.out.print(res[i] + " ");
	}

}
