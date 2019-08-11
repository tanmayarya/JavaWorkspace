package StackAndQueue;

import java.util.*;

public class PositionOfBrackets {
	public static void printBracketsPos(String s) {
		Stack<Integer> st = new Stack<Integer>();
		int c = 1;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(')
			{
				System.out.print(c+" ");
				st.push(c);
				c++;
			}
			else if(s.charAt(i)==')')
				System.out.print(st.pop()+" ");
		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		printBracketsPos(s);

	}
}