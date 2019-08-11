package StackAndQueue;

import java.util.*;

public class ConsecutivePairStack {

	public static boolean pairWiseConsecutive(Stack<Integer> st) {
		if(st.size()%2==1)
			st.pop();
		while(!st.isEmpty()) {
			if(Math.abs(st.pop()-st.pop()) == 1)
				return true;
		}
		
	return false;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			st.push(sc.nextInt());
		}
		System.out.println(pairWiseConsecutive(st));

	}
}
