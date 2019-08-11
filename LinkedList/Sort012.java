package LinkedList;

import java.util.*;

public class Sort012 {

	public static void linksort(Node head) {
		int n1 = 0, n2 = 0, n0 = 0;
		Node temp = head;
		while (temp != null) {
			if (temp.data == 0)
				n0++;
			else if (temp.data == 1)
				n1++;
			else
				n2++;
			temp = temp.next;
		}
		temp = head;
		while (n0 > 0) {
			temp.data = 0;
			n0--;
			temp = temp.next;
		}
		while (n1 > 0) {
			temp.data = 1;
			n1--;
			temp = temp.next;
		}
		while (n2 > 0) {
			temp.data = 2;
			n2--;
			temp = temp.next;
		}
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head = insert(head, a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			head = insert(head, a);
		}

		linksort(head);
		display(head);

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
