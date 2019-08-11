package LinkedList;

import java.util.*;

public class RandomPointerInLL {

	public static Node mergeKList(Node[] arr, int k) {
		// write your code here.
		PriorityQueue<Node> q = new PriorityQueue<RandomPointerInLL.Node>();
		for (int i = 0; i < k; i++)
			q.add(arr[i]);

		Node head = q.poll();
		Node tail = head;
		if(head.next!=null)
			q.add(head.next);
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.next != null)
				q.add(n.next);
			tail.next = n;
			tail = tail.next;
		}
		return head;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		Node[] arr = new Node[k];

		Node start = null;
		Node curr = null;

		for (int i = 0; i < k; i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			start = new Node(a);
			arr[i] = start;

			curr = start;
			for (int j = 1; j < n; j++) {
				Node ptr = new Node(sc.nextInt());
				curr.next = ptr;
				curr = ptr;
			}
			curr.next = null;
			start = null;
		}

		Node res = mergeKList(arr, k);
		display(res);

	}

	// Class declaration for a Node of the Linked List
	static class Node implements Comparable<Node> {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public int compareTo(Node o) {
			if (this.data < o.data)
				return -1;
			else if (this.data > o.data)
				return 1;
			else
				return 0;
		}

	}

	/*
	 * Input Parameters: head: head of the linked list in which is to be displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

}