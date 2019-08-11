package StackAndQueue;

import java.util.*;

public class NextGreaterInOther {

	public static int[] nextGreaterOther(int[] nums1, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int res[] = new int[nums1.length];
		map.put(arr[arr.length - 1], -1);
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr[arr.length - 1]);

		for (int i = arr.length - 2; i >= 0; i--) {

			while (!st.isEmpty() && arr[i] >= st.peek())
				st.pop();

			if (st.isEmpty())
				map.put(arr[i], -1);
			else if(!map.containsKey(arr[i]))
				map.put(arr[i], st.peek());
			st.push(arr[i]);
		}
		for (int i = 0; i < nums1.length; i++)
			res[i] = map.get(nums1[i]);
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt(), n2 = sc.nextInt();
		int[] nums1 = new int[n1];
		int[] nums2 = new int[n2];
		for (int i = 0; i < n1; i++)
			nums1[i] = sc.nextInt();
		for (int i = 0; i < n2; i++)
			nums2[i] = sc.nextInt();
		int[] res = nextGreaterOther(nums1, nums2);
		for (int i = 0; i < n1; i++)
			System.out.print(res[i] + " ");
	}

}
