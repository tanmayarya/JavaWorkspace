package StackAndQueue;

import java.util.*;

public class FindLeftRightSmaller {

	static int findMaxDiff(int a[], int n) {
		int max = 0;
		Stack<Integer> st = new Stack<Integer>();
		int sel[] = new int[n];
		int ser[] = new int[n];
		sel[0] = 0;
		ser[n - 1] = 0;

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() &&  a[i] < a[st.peek()] ) {
				int idx = st.pop();
				ser[idx] = a[i];
				if (st.isEmpty())
					sel[idx] = 0;
				else
					sel[idx] = a[st.peek()];
			}
			if (st.isEmpty())
				sel[i] = 0;
			st.push(i);
		}
		while (!st.isEmpty() && a[st.peek()] > 0) {
			int idx = st.pop();
			ser[idx] = 0;
			if (st.isEmpty())
				sel[idx] = 0;
			else
				sel[idx] = a[st.peek()];
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, Math.abs(ser[i] - sel[i]));
		}
		
		for(int i=0;i<n;i++)
			System.out.println(i+" "+a[i]+" "+sel[i]+" "+ser[i]+" ");
		

		return max;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		System.out.println(findMaxDiff(A, N));
	}
}
