package General;

import java.util.*;

public class CalculateMolecularMass {

	public static int calculate(String s) {
		int mass = 0;
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int a = Integer.parseInt(st.pop());
				st.push((a * (c - '0')) + "");
			} else if (c == 'C')
				st.push(12 + "");
			else if (c == 'H')
				st.push(1 + "");
			else if (c == 'O')
				st.push(16 + "");
			else if (c == '(')
				st.push('(' + "");
			else if (c == ')'){
				int a = 0;
				while (st.peek().charAt(0) != '(')
					a += Integer.parseInt(st.pop());
				st.pop();
				st.push(a + "");
			}
		}
		int a = 0;
		while (!st.isEmpty())
			a += Integer.parseInt(st.pop());
		return a;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		System.out.println(calculate(s));
	}
}
