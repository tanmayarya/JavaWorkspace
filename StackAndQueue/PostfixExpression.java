package StackAndQueue;

import java.util.*;

public class PostfixExpression {
	public static int PostfixEvaluation(String s) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				st.push(c - '0');
			else {
				int v1 = st.pop();
				int v2 = st.pop();
				st.push(Operate(v2, c, v1));
			}
		}
		return st.pop();
	}

	public static int Operate(int v1, char c, int v2) {
		switch (c) {
		case '+':
			return v1 + v2;
		case '-':
			return v1 - v2;
		case '*':
			return v1 * v2;
		case '/':
			return v1 / v2;
		case '%':
			return v1 % v2;
		case '^':
			return (int) Math.pow(v1, v2);
		}
		return 0;
	}

	public static String PostfixToInfix(String s) {
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				st.push(c + "");
			else {
				String v1 = st.pop();
				String v2 = st.pop();
				st.push('(' + v2 + c + v1 + ')');
			}
		}
		return st.pop();
	}
	public static String PostfixToPrefix(String s) {
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				st.push(c + "");
			else {
				String v1 = st.pop();
				String v2 = st.pop();
				st.push(c+v2+v1);
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
//		System.out.println(PostfixEvaluation(scn.next()));
//		System.out.println(PostfixToInfix(scn.next()));
		System.out.println(PostfixToPrefix(scn.next()));
	}

}
