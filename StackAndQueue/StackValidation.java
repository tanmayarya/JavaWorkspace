package StackAndQueue;

import java.util.*;

public class StackValidation {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		// Write your code here
		int i = 0;
		int j = 0;
		Stack<Integer> st = new Stack<Integer>();

		while (i < popped.length) {
			if (!st.isEmpty() && st.peek() == popped[j]) {
				st.pop();
				j++;
			} else {
				st.push(pushed[i]);
				i++;
			}
		}
		while (j < popped.length) {
			if (!st.isEmpty() && st.peek() == popped[j]) {
				st.pop();
				j++;
			}
			else return false;
		}
		return true;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] pushed = new int[N];
		int[] popped = new int[N];
		for (int i = 0; i < N; i++)
			pushed[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			popped[i] = sc.nextInt();
		System.out.print(validateStackSequences(pushed, popped));
	}
}
