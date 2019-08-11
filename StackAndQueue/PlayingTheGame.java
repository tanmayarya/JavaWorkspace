package StackAndQueue;

import java.util.*;

public class PlayingTheGame {

	public static int calculatePoints(String[] ops) {
		// Write ypur code here only
		int score = 0;
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < ops.length; i++) {
			switch (ops[i].charAt(0)) {
			case '+':
				int a = st.pop();
				int b = st.pop();
				st.push(b);
				st.push(a);
				st.push(a + b);
				break;
			case 'D':
				st.push(2 * st.peek());
				break;
			case 'C':
				st.pop();
				break;

			default:
				st.push(Integer.parseInt(ops[i]));
				break;
			}
		}
		while(!st.isEmpty()) {
			score+=st.pop();
		}

		return score;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] S = new String[n];
		for (int i = 0; i < n; i++) {
			S[i] = sc.next();
		}
		System.out.println(calculatePoints(S));
	}

}
