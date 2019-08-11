package StackAndQueue;

import java.util.*;

public class LongestValidParanthesis {

	public static int longestParenthesis(String s) {

		int count = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				st.push(i);
			else {
				st.pop();
				if (!st.isEmpty())
					count = Math.max(count, i - st.peek());
				else
					st.push(i);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String s = scn.next();
		System.out.println(longestParenthesis(s));

	}
}
