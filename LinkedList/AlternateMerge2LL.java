package LinkedList;

import java.util.Scanner;

public class AlternateMerge2LL {
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This takes as input the heads of first and second linked list.
	// It should return an array containing containing heads of resultant
	// first and second linked list at index 0 and 1 respectively.
	public static Node[] mergeAlt(Node head1, Node head2) {
		// write your code here, and print the result
		Node[] a = new Node[2];
		Node c1 = head1;
		Node n1 = head1.next;
		Node c2 = head2;
		Node n2 = head2.next;
		while (n1 != null && n2 != null) {
			c1.next = c2;
			c2.next = n1;

			c1 = n1;
			n1 = n1.next;
			c2 = n2;
			n2 = n2.next;
		}
		a[0] = head1;
		if (c1.next == null) {
			c1.next = c2;
			c2.next = null;
			a[1] = n2;
		}

		else {
			c1.next=c2;
			c2.next=n1;
			a[1] = null;
		}

		return a;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();
		head1 = insert(head1, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			head1 = insert(head1, a);
		}

		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		head2 = insert(head2, a2);

		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			head2 = insert(head2, a);
		}
		Node[] res = mergeAlt(head1, head2);
		display(res[0]);
		display(res[1]);
		// head3 = sublinkedList(head, head2);
		// display(head3);

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

	static Node head1;

	static Node head2;

	static Node head3;

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node insert(Node head, int data) {

		if (head == null) {
			return new Node(data);
		}

		head.next = insert(head.next, data);
		return head;
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
		System.out.println();
	}
}
