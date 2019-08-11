package StackAndQueue;

import java.util.*;

public class NextWarmerDay {
	public static int[] findWarmerTemp(int T[]) {
		// Write your code here only
		int res[] = new int[T.length];
		Stack<Integer> st = new Stack<Integer>();
		res[T.length - 1] = 0;
		st.push(T.length - 1);

		for (int i = T.length - 2; i >= 0; i--)
		{
			while(!st.isEmpty() && T[i]> T[st.peek()])
				st.pop();
			if(st.isEmpty())
				res[i] =0 ;
			else res[i] = st.peek()-i;
			
			st.push(i);
		}
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp[] = new int[n];
		for (int i = 0; i < n; i++)
			temp[i] = sc.nextInt();
		int res[] = findWarmerTemp(temp);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
