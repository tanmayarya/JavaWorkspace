package LinkedList;

import java.util.Scanner;

public class MultiplicationOfLL {

	public static long multiplyTwoLists(Node first, Node second) {
		// write your code here.
		long num1 = 0, num2 = 0;
		long a = 1000000007;
		while (first != null || second != null) {

			if (first != null) {
				num1 = (num1 * 10 + first.data) % a;
				first = first.next;
			}
			if (second != null) {
				num2 = (num2 * 10 + second.data) % a;
				second = second.next;
			}

		}

		return (num1 * num2) % a;

	}

	// -----------------------------------------------------

	static Node head1;

	static Node head2;

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

		int n2 = sc.nextInt();
		int a2 = sc.nextInt();

		head2 = tail = insert(null, a2);

		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			tail = insert(tail, a);
		}

		System.out.println(multiplyTwoLists(head1, head2));

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
	 * Input Parameters: tail: head of the linked list in which a new node is to be
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
