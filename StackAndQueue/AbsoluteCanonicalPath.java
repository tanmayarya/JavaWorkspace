package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class AbsoluteCanonicalPath {
	public static String ACP(String s) {
		String res = "";
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '.' && i + 1 < s.length() && s.charAt(i + 1) == '.') {
				i++;
				if (!st.isEmpty())
					st.pop();
				while (!st.isEmpty() && st.peek() != '/')
					st.pop();
			} else if (c == '/') {
				if (st.isEmpty())
					st.push(c);
				else if (st.peek() != '/')
					st.push(c);
			} else if (c != '.') {
				st.push(c);
			}
		}
		if (st.size() > 1 && st.peek() == '/')
			st.pop();
		while (!st.isEmpty()) {
			res = st.pop() + res;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println(ACP(scn.next()));
	}
}
