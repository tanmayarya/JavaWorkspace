package StackAndQueue;

import java.util.*;

public class SortTheStack {

	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> st = new Stack<Integer>();
		while(!input.isEmpty()) {
			int tmp = input.pop();
			while(!st.isEmpty()&&tmp<st.peek())
				input.push(st.pop());
			st.push(tmp);
		}
		return st;
	}

// Dont make changes here 
	public static void main(String args[]) {
		Stack<Integer> input = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
			input.push(sc.nextInt());

		Stack<Integer> res = sortstack(input);

		while (!res.empty()) {
			System.out.print(res.pop() + " ");
		}
	}
}
