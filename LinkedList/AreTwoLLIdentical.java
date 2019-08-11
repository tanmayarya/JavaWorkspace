package LinkedList;

import java.util.Scanner;

public class AreTwoLLIdentical {

	public static boolean isIdentical(Node h1, Node h2) {
		// write your code here and return true if they are identical, otherwise
		// false
		Node n1 = h1;
		Node n2 = h2;
		int count = 0;
		int count2 = 0;

		while (n1 != null && n2 != null) {
			if (n1.data != n2.data) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
			count++;
		}

		if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
			return false;
		}
		return true;

	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();
		head = insert(head, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			head = insert(head, a);
		}

		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		head2 = insert(head2, a2);

		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			head2 = insert(head2, a);
		}

		if (isIdentical(head, head2)) {
			System.out.println("Identical");
		} else {
			System.out.println("Not Identical");
		}

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

	static Node head;

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
	}

}
