package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class DecodingAString {

	public static String decode(String s) {
		Stack<String> st = new Stack<String>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int count = c - '0';
				if (i > 0) {
					if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
						count = (s.charAt(i - 1) - '0') * 10 + count;
						i--;
					}
				}
				String r = st.pop();
				String sr = "";
				for (int j = 0; j < count; j++)
					sr += r;
				st.push(sr);
			}

			else if (c == '[') {
				String r = "";
				while (st.peek().charAt(0) != ']')
					r += st.pop();
				st.pop();
				st.push(r);
			} else
				st.push(c + "");
		}
		String sr = "";
		while (!st.isEmpty())
			sr += st.pop();
		return sr;

	}

	// Dont make any changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(decode(s));
	}

}