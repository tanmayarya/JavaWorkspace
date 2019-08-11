package StackAndQueue;

import java.util.*;

public class ValidBraces {

	public static void isbal(String s) {
		// Write your code here
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(')
				st.push(c);
			else if (c == ')') {
				if (st.pop() != '(') {
					System.out.println("not balanced");
					return;
				}
			} else if (c == ']') {
				if (st.pop() != '[') {
					System.out.println("not balanced");
					return;
				}
			} else if (c == '}') {
				if (st.pop() != '{') {
					System.out.println("not balanced");
					return;
				}
			}
		}
		if (st.isEmpty())
			System.out.println("balanced");
		else
			System.out.println("not balanced");
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		isbal(s);

	}
}
