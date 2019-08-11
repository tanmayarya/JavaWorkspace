package StackAndQueue;

import java.util.*;

public class InfixExpression {

	public static int InfixEvaluation(String s) {
		Stack<Integer> ns = new Stack<Integer>();
		Stack<Character> os = new Stack<Character>();
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('%', 2);
		priority.put('^', 3);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				ns.push(c - '0');
			else if (c == '(')
				os.push(c);
			else if (c == ')') {
				while (os.peek() != '(') {
					char op = os.pop();
					int v1 = ns.pop();
					int v2 = ns.pop();
					ns.push(Operate(v2, op, v1));
				}
				os.pop();
			} else {
				while (!os.isEmpty() && os.peek() != '(' && priority.get(c) <= priority.get(os.peek())) {
					char op = os.pop();
					int v1 = ns.pop();
					int v2 = ns.pop();
					ns.push(Operate(v2, op, v1));
				}
				os.push(c);
			}
		}
		while (!os.isEmpty()) {
			char op = os.pop();
			int v1 = ns.pop();
			int v2 = ns.pop();
			ns.push(Operate(v2, op, v1));
		}
		return ns.pop();
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

	public static String InfixToPostfix(String s) {
		Stack<String> ns = new Stack<String>();
		Stack<Character> os = new Stack<Character>();
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('%', 2);
		priority.put('^', 3);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c) || Character.isLowerCase(c))
				ns.push(c + "");
			else if (c == '(')
				os.push(c);
			else if (c == ')') {
				while (os.peek() != '(') {
					char op = os.pop();
					String v1 = ns.pop();
					String v2 = ns.pop();
					ns.push(v2 + v1 + op);
				}
				os.pop();
			} else {
				while (!os.isEmpty() && os.peek() != '(' && priority.get(c) <= priority.get(os.peek())) {
					char op = os.pop();
					String v1 = ns.pop();
					String v2 = ns.pop();
					ns.push(v2 + v1 + op);
				}
				os.push(c);
			}
		}
		while (!os.isEmpty()) {
			char op = os.pop();
			String v1 = ns.pop();
			String v2 = ns.pop();
			ns.push(v2 + v1 + op);
		}
		return ns.pop();
	}

	public static String InfixToPrefix(String infix) {
		String s = "";
		for (int i = 0; i < infix.length(); i++) {
			// reversing string and changing brackets
			char c = infix.charAt(i);
			if (c == '(')
				c = ')';
			else if (c == ')')
				c = '(';
			s = c + s;
		}
		// solving normal infix to postfix but dont pop for equal precedence
		Stack<String> ns = new Stack<String>();
		Stack<Character> os = new Stack<Character>();
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('%', 2);
		priority.put('^', 3);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c) || Character.isLowerCase(c))
				ns.push(c + "");
			else if (c == '(')
				os.push(c);
			else if (c == ')') {
				while (os.peek() != '(') {
					char op = os.pop();
					String v1 = ns.pop();
					String v2 = ns.pop();
					ns.push(v2 + v1 + op);
				}
				os.pop();
			} else {
				while (!os.isEmpty() && os.peek() != '(' && priority.get(c) < priority.get(os.peek())) {
					char op = os.pop();
					String v1 = ns.pop();
					String v2 = ns.pop();
					ns.push(v2 + v1 + op);
				}
				os.push(c);
			}
		}
		while (!os.isEmpty()) {
			char op = os.pop();
			String v1 = ns.pop();
			String v2 = ns.pop();
			ns.push(v2 + v1 + op);
		}
		s = ns.pop();
		String prefix = "";
		for (int i = 0; i < s.length(); i++)
			prefix = s.charAt(i) + prefix;

		return prefix;
	}

	public static int calculate(String s) {
		boolean counting = false;
		Stack<Integer> ns = new Stack<Integer>();
		Stack<Character> os = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c==' ')
				continue;
			
			if (Character.isDigit(c)) {
				if(counting) {
					ns.push(ns.pop()*10+(c-'0'));
				}
				else ns.push(c - '0');
				if (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
					counting = true;
				}
				else
					counting = false;
				
			}

			else if (c == '(')
				os.push(c);
			else if (c == ')') {
				while (os.peek() != '(') {
					char op = os.pop();
					int v1 = ns.pop();
					int v2 = ns.pop();
					ns.push(Operate(v2, op, v1));
				}
				os.pop();
			} else {
				while (!os.isEmpty() && os.peek() != '(') {
					char op = os.pop();
					int v1 = ns.pop();
					int v2 = ns.pop();
					ns.push(Operate(v2, op, v1));
				}
				os.push(c);
			}
		}
		while (!os.isEmpty()) {
			char op = os.pop();
			int v1 = ns.pop();
			int v2 = ns.pop();
			ns.push(Operate(v2, op, v1));
		}
		return ns.pop();

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		System.out.println(InfixEvaluation(scn.next()));
//		System.out.println(InfixToPostfix(scn.next()));
//		System.out.println(InfixToPrefix(scn.next()));
		System.out.println(calculate(scn.nextLine()));
	}
}
