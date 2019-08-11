package LinkedList;

import java.util.*;

public class Add1ToLL {

	public static Node plusOne(Node node) {
		// write your code here
		int carry = 1;
		Node p = null;
		Node c = node;
		Node n = c.next;
		Node temp;
		while (n != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		if (p != null)
			c = p;
		temp = c;
		while (temp != null) {
			temp.data += carry;
			if (temp.data > 9) {
				temp.data %= 10;
				carry = 1;
			} else
				carry = 0;

			if (temp.next == null && carry == 1) {
				n = new Node(1);
				temp.next = n;
				temp = temp.next;
			}
			temp = temp.next;
		}
		n = c.next;
		p = null;
		while (n != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		if (p != null)
			c = p;
		return c;

////		l =l+1;
////		Node nh =null;
////		Node nt=null;
////		while(l!=0) {
////			nh = new Node(l%10);
////			l/=10;
////			nh.next = nt;
////			nt = nh;
////		}
//		return nh;
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

		head1 = plusOne(head1);
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
	}

}
