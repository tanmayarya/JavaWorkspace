package StackAndQueue;

import java.util.*;

public class PassingTernaryOperator {

	public static String parseTernary(String expression) {
		// Write your code here
		Stack<Character> st = new Stack<Character>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (c == ':')
				continue;
			else if (c == '?') {
				char a = st.pop();
				char b = st.pop();
				if (expression.charAt(i - 1) == 'T')
					st.push(a);
				else
					st.push(b);
				i--;
			}
			else st.push(c);
		}
		return st.peek()+"";
	}

	// Dont make chsnges here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(parseTernary(sc.next()));
	}
}
