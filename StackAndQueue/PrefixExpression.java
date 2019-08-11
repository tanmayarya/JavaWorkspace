package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class PrefixExpression {

	public static int PrefixEvaluation(String s) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				st.push(c - '0');
			else {
				int v1 = st.pop();
				int v2 = st.pop();
				st.push(Operate(v1, c, v2));
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

	public static String PrefixToInfix(String s) {
		Stack<String> st = new Stack<String>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				st.push(c + "");
			else {
				String v1 = st.pop();
				String v2 = st.pop();
				st.push('(' + v1 + c + v2 + ')');
			}
		}
		return st.pop();
	}

	public static String PrefixToPostfix(String s) {
		Stack<String> st = new Stack<String>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				st.push(c + "");
			else {
				String v1 = st.pop();
				String v2 = st.pop();
				st.push(v1 + v2 + c);
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
//		System.out.println(PrefixEvaluation(scn.next()));
//		System.out.println(PrefixToInfix(scn.next()));
		System.out.println(PrefixToPostfix(scn.next()));
	}

}
