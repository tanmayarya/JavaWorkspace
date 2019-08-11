package StackAndQueue;

import java.util.*;

public class RemoveRepeatedDigits {

	static long removeRep(long n) {
		String s = n + "";

		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (st.isEmpty())
				st.push(c);
			else if (!st.isEmpty() && c != st.peek())
				st.push(c);
		}
		s = "";
		while (!st.isEmpty()) {
			s = st.pop() + s;
		}
		return Long.parseLong(s);
		// Write your code here
	}

	// Dont make changes here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		System.out.println(removeRep(A));

	}

}
