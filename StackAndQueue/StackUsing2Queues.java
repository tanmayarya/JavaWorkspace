package StackAndQueue;

import java.util.*;

public class StackUsing2Queues {
	static Queue<Integer> curr = new LinkedList<Integer>();
	static Queue<Integer> next = new LinkedList<Integer>();

	/* The method pop which return the element poped out of the stack */
	static int pop() {
		if (curr.isEmpty())
			return -1;
		while (curr.size() > 1)
			next.add(curr.poll());
		int a = curr.poll();
		curr = next;
		next = new LinkedList<Integer>();
		return a;
	}

	/* The method push to push element into the stack */
	static void push(int a) {
		curr.add(a);
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			if (q == 1) {
				int val = sc.nextInt();
				push(val);
			} else if (q == 2) {
				System.out.println(pop());
			}
		}
	}

}
