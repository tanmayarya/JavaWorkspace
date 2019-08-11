package StackAndQueue;

import java.util.*;

public class StackSupportingMinimumOperation {

	static int minEle;
	static Stack<Integer> s = new Stack<>();

	// Complete the below 3 functions only
	static int getMin() {
		return minEle;
	}

	static int pop() {
		if (s.isEmpty())
			return -1;
		if (s.peek() < minEle) {
			int res = minEle;
			minEle = 2 * minEle - s.peek();
			s.pop();
			return res;
		}
		return s.pop();
	}

	static void push(int x) {
		if (s.isEmpty()) {
			s.push(x);
			minEle = x;
		} else {
			if (x < minEle) {
				s.push(2 * x - minEle);
				minEle = x;
			} else
				s.push(x);
		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] query = new int[n];
		for (int i = 0; i < n; i++) {
			query[i] = sc.nextInt();
		}
		int i = 0;
		while (i < n) {
			if (query[i] == 1) {
				i++;
				push(query[i]);
			} else if (query[i] == 2) {
				System.out.println(pop());
			} else if (query[i] == 3) {
				System.out.println(getMin());
			}
			i++;
		}
	}

}