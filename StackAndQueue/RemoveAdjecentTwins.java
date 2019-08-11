package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAdjecentTwins {

	public static void removeAdjTwins(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty())
				st.push(s.charAt(i));
			else if (st.peek() == s.charAt(i))
				st.pop();
			else
				st.push(s.charAt(i));
		}
		String sr = "";
		while (!st.isEmpty()) {
			sr = st.pop() + sr;
		}
		System.out.println(sr);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		removeAdjTwins(s);
	}

}
