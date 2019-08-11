package StackAndQueue;

import java.util.*;

public class CountingNumberOfReversals {

	public static int min_str_reversal(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{')
				st.push(s.charAt(i));
			else {
				if (!st.isEmpty() && st.peek() == '{')
					st.pop();
				else
					st.push('}');
			}
		}
		int oc=0,cc=0;
		while(!st.isEmpty())
		{
			if(st.pop()=='{')
				oc++;
			else cc++;
		}
		return (int) (Math.ceil((oc*1.0)/2) + Math.ceil((cc*1.0)/2));
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(min_str_reversal(s));

	}
}
