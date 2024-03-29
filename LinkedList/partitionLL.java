package LinkedList;

import java.util.Scanner;

public class partitionLL {

	public static Node partition(Node n, int x) {

		Node smallH = null, smallT = null, bigH = null, bigT = null;
		Node c = n;
		Node nxt = c.next;
		while (nxt != null) {
			nxt = c.next;
			if (c.data < x) {
				if (smallH == null) {
					smallH = c;
					smallT = c;
				} else {
					smallT.next = c;
					smallT = c;
				}
				smallT.next = null;
			} else {
				if (bigH == null) {
					bigH = c;
					bigT = c;
				} else {
					bigT.next = c;
					bigT = c;
				}
				bigT.next = null;
			}
			c = nxt;
		}
		if (smallH == null)
			return bigH;
		else
			smallT.next = bigH;
		return smallH;
	}

	// -----------------------------------------------------

	static Node head1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();

		Node tail;
		head1 = tail = insert(null, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			tail = insert(tail, a);
		}

		int x = sc.nextInt();

		head1 = partition(head1, x);
		display(head1);

	}

	// Class declaration for a Node of the Linked List
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	/*
	 * Input Parameters: tail: tail of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: tail of the linked list/the node that is inserted
	 */
	public static Node insert(Node tail, int data) {

		if (tail == null) {
			return new Node(data);
		}

		Node nn = new Node(data);
		tail.next = nn;
		return nn;
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
