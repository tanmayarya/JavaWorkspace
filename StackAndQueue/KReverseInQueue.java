package StackAndQueue;

import java.util.*;

public class KReverseInQueue {

	static void reverseQueueFirstKElements(Queue<Integer> q, int k) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < k; i++) {
			st.push(q.poll());
		}
		for (int i = 0; i < k; i++) {
			q.add(st.pop());
		}
		for (int i = 0; i <q.size() - k; i++) {
			q.add(q.poll());
		}
		
		while(!q.isEmpty()) {
			System.out.print(q.poll() + " ");
		}
	}

	// Driver code
	public static void main(String args[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < n; i++)
			q.add(sc.nextInt());
		reverseQueueFirstKElements(q, k);
	}
}
