package LinkedList;

import java.util.*;

import LinkedList.FoldLL.Node;

public class palindrome {

	static Node left;

	// -----------------------------------------------------
	// This is a functional problem. You have to complete this function.
	// This function takes as input the head of the linked list.
	// It should return true if list is palindrome, else return false.

	public static boolean isPalindrome(Node head) {
		// write your code here.
		if (head.next == null)
			return true;
		if (head.next.next == null) {
			return head.data == head.next.data;
		}

		Node slow = head;
		Node fast = head;
		Node head2;
		while (fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast.next == null)
				break;
		}
		head2 = slow.next;
		slow.next = null;

		Node p = null;
		Node c = head2;
		Node n = c.next;
		while (n != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		if (p != null)
			c = p;
		head2 = c;

		Node c1 = head;
		Node n1 = head.next;
		Node c2 = head2;
		Node n2 = head2.next;
		while (c1 != null && c2 != null) {
			if(c1.data!=c2.data)
				return false;
			c1 = c1.next;
			c2 = c2.next;
		}

		return true;
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

		if (isPalindrome(head1)) {
			System.out.println("1");
		} else {
			System.out.println("0");
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
