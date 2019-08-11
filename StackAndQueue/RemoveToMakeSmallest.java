package StackAndQueue;

import java.util.*;

public class RemoveToMakeSmallest {

	public static String removeMakeSmallest(String num, int k) {
		String res = "";
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			while (k > 0 && !st.isEmpty() && st.peek() > c - '0') {
				st.pop();
				k--;
			}
			st.push(c - '0');
		}
		while (k > 0)
			st.pop();

		while (!st.isEmpty())
			res = st.pop() + res;
		
		for(int i=0;i<res.length();i++)
			if(res.charAt(i)!='0')
				return res.substring(i);
		
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(removeMakeSmallest(s, k));
	}

}
