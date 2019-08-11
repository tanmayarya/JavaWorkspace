package LinkedList;

import java.util.Scanner;

import LinkedList.Add1ToLL.Node;

public class AdditionOf2LL {

	public static Node addTwoNumbers(Node n1, Node n2) {
		Node p = null;
		Node c = n1;
		Node n = c.next;
		Node temp;
		while (c != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		Node h1 = p;

		p = null;
		c = n2;
		n = c.next;
		while (c != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		Node h2 = p;
		int carry = 0;
		Node head = null;
		Node tail = head;
		c = h1;
		n = h2;
		while (c != null && n != null) {
			if (head == null) {
				head = new Node(0, null);
				tail = head;
			} else {
				tail.next = new Node(0, null);
				tail = tail.next;
			}
			if (c.data + n.data + carry > 9) {
				tail.data = (c.data + n.data + carry) % 10;
				carry = 1;
			} else {
				tail.data = c.data + n.data + carry;
				carry = 0;
			}

			c = c.next;
			n = n.next;
		}
		
		if(n==null) 
			p = c;
		else p = n;
		
		while (p != null) {
			if (head == null) {
				head = new Node(0, null);
				tail = head;
			} else {
				tail.next = new Node(0, null);
				tail = tail.next;
			}
			tail.data =p.data + carry;
			if (tail.data > 9) {
				tail.data %= 10;
				carry = 1;
			} else
				carry = 0;

			if (p.next == null && carry == 1) {
				n = new Node(1,null);
				tail.next = n;
			}
			p = p.next;
		}
		
		p = null;
		c = head;
		n = c.next;
		while (c != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		
		return p;
		
	}

	// -----------------------------------------------------

	static Node head1;

	static Node head2;

	static Node head3;

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

		head3 = addTwoNumbers(head1, head2);
		display(head3);

	}

	// Class declaration for a Node of the Linked List
	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
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
			return new Node(data, null);
		}

		Node nn = new Node(data, null);
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
		System.out.println();
	}

}
