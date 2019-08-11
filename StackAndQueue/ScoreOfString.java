package StackAndQueue;

import java.util.*;

public class ScoreOfString {

	public static int scoreOfParentheses(String s) {
		// Write your code here
		Stack<String> st = new Stack<String>();
		for(int i=0;i<s.length();i++) 
		{
			char c = s.charAt(i);
			if(c=='(')
				st.push(c+"");
			
			else {
				int n=0;
				while(st.peek().charAt(0)!='(')
					n+=Integer.parseInt(st.pop());
				if(n!=0)
					n*=2;
				else n=1;
				st.pop();
				st.push(n+"");
			}
		}
		while(st.size()>1) {
			int a = Integer.parseInt(st.pop());
			int b = Integer.parseInt(st.pop());
			st.push(a+b+"");
		}
		return Integer.parseInt(st.pop());
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(scoreOfParentheses(s));
	}

}
