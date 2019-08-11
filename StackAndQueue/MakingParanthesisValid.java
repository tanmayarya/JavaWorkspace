package StackAndQueue;

import java.util.*;

public class MakingParanthesisValid {

	public static int minAddToMakeValid(String s) {
        //Write your code here
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c==')' && !st.isEmpty() && st.peek()=='(')
				st.pop();
			else st.push(c);
		}
		return st.size();
    }

    // Dont make changes here
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(minAddToMakeValid(s));
    }

}